<%@ page import="com.ntvu.web2.entity.SystemUsers" %>
<%@ page import="com.ntvu.web2.service.LoginService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>编辑用户信息</title>
    <script src="../plugins/jquery-1.10.2-min.js"></script>
    <script src="../js/validate.js"></script>
    <style type="text/css">
        .form-center {
            min-width: 300px;
            min-height: 500px;
            margin: auto;
        }

        .form-center table > tr > td {
            font-weight: bold;
            font-size: 18px;
            text-align: right;
        }
    </style>
</head>
<%
    System.out.println(request.getParameter("id"));
    SystemUsers user = new LoginService().findById(Integer.parseInt(request.getParameter("id")));
    List<String> roleNames = new LoginService().getRoleNameList();
    String userRoleName = user.getRole().getRoleName();
    String roleName;
%>
<body>
<div class="form-center">
    <form action="${pageContext.request.contextPath}/doEditUser" name="editUser">
        <input type="hidden" name="id" value="<%= user.getId()%>">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username" value="<%=user.getLoginName()%>" validateRule='[{"type" : "isEmpty"}, {"type" : "rangeLength", "min" : 3, "max" : 16}]'/></td>
            </tr>
            <tr>
                <td>手机号：</td>
                <td><input type="text" name="telephone" value="<%=user.getTelephone()%>" validateRule='[{"type" : "isEmpty"}, {"type" : "validTelephone"}]'/></td>
            </tr>
            <tr>
                <td>邮箱：</td>
                <td><input type="text" name="email" value="<%=user.getEmail()%>" validateRule='[{"type" : "isEmpty"}, {"type" : "validEmail"}]'/></td>
            </tr>
            <tr>
                <td>状态：</td>
                <td><input type="checkbox" name="status" <%=user.isStatus() ? "checked" : ""%> /></td>
            </tr>
            <tr>
                <td>角色：</td>
                <td>
                    <%--                    <input type="checkbox" name="roleId"  />--%>
                    <select name="roleName">
                        <option value="<%=userRoleName%>"><%=userRoleName%>
                        </option>
                        <%
                            for (String name : roleNames) {
                                roleName = name;
                                if (roleName.equals(userRoleName)) continue;
                        %>
                        <option value="<%=roleName%>"><%=roleName%></option>
                        <%
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="button" value="提交" onclick="doSubmit()"/>
                    <input type="button" value="返回" onclick="window.location.href='./main.jsp'"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<script>
    document.querySelectorAll("input[type=text]");

    function doSubmit() {
        const succeed = false;

        $("input[validateRule][type=text]").each(function () {
            const v = $(this).val();
            const rule = $(this).attr("validateRule");

            console.log(v);
            console.log(rule);

            //next:解析rule
            const ruleObject = jQuery.parseJSON(rule);
            console.log(ruleObject);

            for (let i = 0; i < ruleObject.length; i++) {
                const obj = ruleObject[i];
                console.log(obj);
            }
        });
    }
</script>
</body>
</html>