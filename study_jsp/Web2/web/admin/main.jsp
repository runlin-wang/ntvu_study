<%@ page import="com.ntvu.web2.common.Pager" %>
<%@ page import="com.ntvu.web2.entity.SystemUsers" %>
<%@ page import="com.ntvu.web2.service.LoginService" %>
<%@ page import="com.ntvu.web2.util.Tools" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>后台管理界面</title>
    <link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/admin.css" />
</head>
<%

    String path = request.getContextPath();
    if (session.getAttribute("CurrentUserName") == null) {
        response.sendRedirect(path + "/index.jsp");
        return;
    }

    int pageIndex = Tools.getGreaterThanZero(request.getParameter("pageIndex"), 1);
    int pageSize = Tools.getGreaterThanZero(request.getParameter("pageSize"), 10);
    String key = Tools.getNullOrEmpty(request.getParameter("key"), "");
    Pager<SystemUsers> pager = new LoginService().getPagers(pageIndex, pageSize, key);
    int[] pageSizes = {10, 20, 50, 100};
%>
<body>
    <p class="text-center">
        欢迎光临 <%=session.getAttribute("CurrentUserName").toString()%>, <a href="${pageContext.request.contextPath}/doLogout">注销</a>
    </p>

    <hr/>
    <div class="main">
        <form action="main.jsp" name="queryForm">
        <div class="query text-center">
                <p>
                    <label>查询条件<input type="text" name="key" id="key" value="<%=key%>"></label>
                    <input type="submit" value="查询">
                    <button onclick="deleteOption()">删除选择项</button>
                </p>
        </div>
        <div class="table">
            <table>
                <thead>
                    <tr>
                        <th class="th1"><label for="checkAll">选择</label><input type="checkbox" name="checkAll" id="checkAll" onclick="selectAll()"></th>
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
                        <td><label for="check<%=user.getId()%>"></label><input type="checkbox" name="check<%=user.getId()%>" id="check<%=user.getId()%>"></td>
                        <td><%=user.getLoginName()%></td>
                        <td><%=user.getTelephone()%></td>
                        <td><%=user.getEmail()%></td>
                        <td>
                            <img src="/images/<%=user.isStatus()%>.png" width="20px" title="<%=user.isStatus() ? "可用" : "不可用"%>" alt="">
                        </td>
                        <td><%=user.getRole().getRoleName()%></td>
                        <td>
                            <input type="button" value="删除" onclick="deleteByName('<%=user.getLoginName()%>')">
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
                            <label for="page-sizes">
                                每页
                                <select id="page-sizes" class="pager-number">
                                    <%
                                        for (int i : pageSizes) {
                                    %>
                                    <option value="<%=i%>" <%= i == pager.getPageSize() ? "selected" : ""%>><%=i%></option>
                                    <%
                                        }
                                    %>
                                </select>
                                条
                            </label>
                            <a href="#" onclick="jump(1)">首页</a>
                            <a href="#" onclick="jump(<%=Tools.getGreaterThanZero(pageIndex - 1, 1)%>)" >上一页</a>
                            <a href="#" onclick="jump(<%=Math.min(pageIndex + 1, pager.getTotalPage())%>)" >下一页</a>
                            <a href="#" onclick="jump(<%=pager.getTotalPage()%>)" >末页</a>
                            <label for="page-jump">
                                跳到第
                                <select id="page-jump" class="pager-number" onchange="jump(document.getElementById('page-jump').value)">
                                    <%
                                        for (int i = 1; i <= pager.getTotalPage(); i++) {
                                    %>
                                    <option value="<%=i%>" <%= i == pager.getPageIndex() ? "selected" : ""%>><%=i%></option>
                                    <%
                                        }
                                    %>
                                </select>
                                页
                            </label>
                            <%=pager.getPageIndex()%> / <%=pager.getTotalPage()%>
                            共 <%=pager.getTotalRecord()%> 条
                        </td>
                    </tr>
                </tfoot>
            </table>
        </div>
        </form>
    </div>

    <script type="text/javascript">
        function jump(pageIndex) {
            const pageSize = document.getElementById("page-sizes").value;
            const key = document.getElementById("key").value;
            window.location.href = "main.jsp?pageIndex=" + pageIndex + "&pageSize=" + pageSize + "&key=" + key;
        }

        function deleteByName(LoginName) {
            if (typeof LoginName == "undefined" || LoginName == null || LoginName === '') {
                alert('当前参数错误');
                return;
            }
            if (confirm('当前操作不可恢复，确认删除吗？'))
                window.location.href = "/admin/delete.jsp?loginName=" + LoginName;
        }

        function selectAll(selected) {
            let chAll = document.getElementsByName("");
        }

        function deleteOption() {

        }
    </script>
</body>
</html>
