<%--
  Created by IntelliJ IDEA.
  User: alin
  Date: 2021/3/22
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <form action="/doLogin" method="post">
        用户名：<input type="text" name="userName" id="user-name"/>
        密码：<input type="password" name="pwd" id="pwd"/>

        <a href="/doRegister">注册</a>
    </form>

</body>
</html>
