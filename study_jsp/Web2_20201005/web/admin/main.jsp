<%--
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
</head>
<%

    String path = request.getContextPath();
    if (session.getAttribute("CurrentUserName") == null) {
        response.sendRedirect(path + "/index.html");
        return;
    }

%>
<body>
<%--session.getAttribute("CurrentUserName").toString();--%>
    欢迎光临 <% session.getAttribute("CurrentUserName").toString();%>, <a href="/doLogout">注销</a>
</body>
</html>
