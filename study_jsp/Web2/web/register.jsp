<%@ page import="com.ntvu.web2.util.Tools" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
</head>
<link rel="stylesheet" href="css/global.css">
<body>

<div id="root">
    <div class="container">
        <div class="nav">This is logo!</div>
        <div class="form">
            <form action="${pageContext.request.contextPath}/doRegister">
                <div class="head">
                    <h1>欢迎注册</h1>
                </div>

                <div class="input-div">
                    <div class="txt"><label for="username">用户名</label></div>
                    <input id="username" name="username" placeholder="请输入你的用户名" type="text" value="<%=Tools.getNullOrEmpty(request.getAttribute("txtLoginName"), "")%>">
                </div>

                <div class="input-div">
                    <div class="txt"><label for="pwd">密码</label></div>
                    <input id="pwd" name="pwd" placeholder="请输入你的登录密码" type="password">
                </div>

                <div class="input-div">
                    <div class="txt"><label for="pwd2">确认密码</label></div>
                    <input id="pwd2" name="pwd2" placeholder="请再次输入密码" type="password">
                </div>

                <div class="input-div">
                    <div class="txt"><label for="telephone">手机号</label></div>
                    <input id="telephone" name="telephone" placeholder="请输入手机号" type="text" value="<%=Tools.getNullOrEmpty(request.getAttribute("telephone"), "")%>">
                </div>

                <div class="input-div">
                    <div class="txt"><label for="email">邮箱</label></div>
                    <input id="email" name="email" placeholder="请输入邮箱" type="text" value="<%=Tools.getNullOrEmpty(request.getAttribute("email"), "")%>">
                </div>

                <div id="register">同意条款并注册</div>
            </form>
        </div>
    </div>
</div>

<script>
    document.querySelector('#register').onclick = function () {
        document.querySelector('form').submit();
    }
</script>
</body>
</html>