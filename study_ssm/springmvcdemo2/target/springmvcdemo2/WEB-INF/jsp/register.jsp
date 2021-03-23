<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/global.css">
</head>
<body>
<div id="root">
    <div class="container">
        <div class="nav">This is logo!</div>
        <div class="form">
            <form action="">
                <div class="head">
                    <h1>欢迎注册</h1>
                </div>
                <div class="input-div">
                    <div class="input-top">用户名</div>
                    <input type="text" name="username" id="username" placeholder="请输入你的用户名">
                </div>
                <div class="input-div">
                    <div class="input-top">密码</div>
                    <input type="password" name="pwd" id="pwd" placeholder="请输入你的登录密码">
                </div>
                <div class="input-div">
                    <div class="input-top">密码</div>
                    <input type="password" name="pwd2" id="pwd2" placeholder="请确认你的登录密码">
                </div>
                <div class="login">进入</div>
            </form>
        </div>
    </div>
</div>
</body>
</html>