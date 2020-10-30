<%@ page import="com.ntvu.web2.entity.SystemUsers" %>
<%@ page import="com.ntvu.web2.service.LoginService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ntvu.web2.common.Pager" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/5
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理界面</title>
    <style>
        .main{
            background-color: #009688;
            width: 1200px;
            margin: 0 auto;

        }
        table{
            text-align: center;
        }
        .th1{
            width: 10%;
        }
        .th2{
            width: 10%;
        }
        .th3{
            width: 10%;
        }
        .th4{
            width: 20%;
        }
        .th5{
            width: 10%;
        }
        .th6{
            width: 10%;
        }
        .th7{
            width: 30%;
        }
    </style>
</head>
<%

    String path = request.getContextPath();
    if (session.getAttribute("CurrentUserName") == null) {
        response.sendRedirect(path + "/index.jsp");
        return;
    }

    int pageIndex = 0;
    int pageSize = 0;
    String key = "";
    Pager<SystemUsers> pager = new LoginService().getPagers(pageIndex, pageSize, key);
%>
<body>
    欢迎光临 <% session.getAttribute("CurrentUserName").toString();%>, <a href="${pageContext.request.contextPath}/doLogout">注销</a>

    <hr/>
    <div class="main">
        <div class="query">
            <p>
                查询条件<input type="text" name="query">
                <input type="submit" value="查询">
            </p>
        </div>
        <div class="table">
            <table>
                <thead>
                <tr>
                    <th class="th1">选择<input type="checkbox" name="checkAll" id="checkAll"></th>
                    <th class="th2">用户名</th>
                    <th class="th3">手机号</th>
                    <th class="th4">邮箱</th>
                    <th class="th5">状态</th>
                    <th class="th6">角色</th>
                    <th class="th7">操作栏</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (SystemUsers user : pager.getData()) {
                %>
                <tr>
                    <td><input type="checkbox" name="check<%=user.getId()%>" id="check<%=user.getId()%>"></td>
                    <td><%=user.getLoginName()%></td>
                    <td><%=user.getTelephone()%></td>
                    <td><%=user.getEmail()%></td>
                    <td>
                        <img src="/images/<%=user.isStatus()%>.png" width="20px" title="<%=user.isStatus() ? "可用" : "不可用"%>">
                    </td>
                    <td><%=user.getRole().getRoleName()%></td>
                    <td>
                        <input type="button" value="删除">
                        <input type="button" value="编辑" onclick="location.href='edit.jsp?login_name=<%=user.getLoginName()%>'">
                        <input type="button" value="禁用">
                        <input type="button" value="重置密码">
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="7">
                        每页 <%=pager.getPageSize()%> 条
                        <a href="main.jsp">首页</a>
                        上一页
                        下一页
                        末页
                        跳到第 x 页
                        <%=pager.getIndex()%> / <%=pager.getTotalPage()%>
                        共 <%=pager.getTotalRecord()%> 条
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</body>
</html>
