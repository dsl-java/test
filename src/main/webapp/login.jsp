<%--
  Created by IntelliJ IDEA.
  User: dsl
  Date: 2020/12/29
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet"  type="text/css" href="css/login.css">
    <style type="text/css">
        body{
            background:#fff url("images/背景图 (1).jpg") no-repeat left top;
            background-size:100%;
            position:relative;
        }
    </style>
</head>
<body>
<div class="text">
    超市库存管理系统
</div>
<div class="web_login">
    <div class="login_form">
        <form name="loginform" action="/stock/UserLoginServlet" method="get">
            <div class="span1">
                <input name="username" type="text"  placeholder="用户名/账号"/>
            </div>
            <div class="span1">
                <input name="password" type="password"  placeholder="密码"/>
            </div>
            <div class="span1 button">
                <input name="login" type="submit" value="登录" />
            </div>
            <div class="span1 button">
                <input name="register" type="button" value="注册" onclick="jump()"/>
            </div>
            <script>
                function jump() {
                    window.open("register.html");
                }
            </script>
        </form>
    </div>
</div>
<div class="end-area">
    <div class="login_foot_text">
        Copyright © 2010-2020 超市库存管理系统   All Rights Reserved
    </div>
</div>
</body>
</html>
