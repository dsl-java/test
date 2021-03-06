<%--
  Created by IntelliJ IDEA.
  User: dsl
  Date: 2020/12/29
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet"  type="text/css" href="css/register.css">
    <style type="text/css">
        body{
            background:#fff url("images/背景图 (1).jpg") no-repeat left top;
            background-size:100%;
        }
    </style>

    <script>
        function validate() {
            //通过ID获取值
            var username = document.getElementById("username").value;
            var  password = document.getElementById("password").value;

            // 验证邮箱合法性
            var pattern = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
            if(username == ''){
                alert("用户名不能为空！");
                return false;
            }else if(!pattern.test(username)){
                alert("用户名格式不正确！");
                return false;
            }

            //验证password
            if(password == ''){
                alert("password不能为空！");
                return false;
            }else if(password.length<6 || password.length>12){
                alert("密码长度要在6-12位！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="text">
    超市库存管理系统
</div>
<div class="web_login">
    <div class="login_form">
        <form name="loginform"  action="/stock/UserRegisterServlet" method="get" onsubmit="return validate()">
            <div class="span1">
                <input id="username" name="username" type="text"  placeholder="用户名/账号"/>
            </div>
            <div class="span1">
                <input id="password" name="password" type="password"  placeholder="密码"/>
            </div>
            <div class="span1 button">
                <input name="register" type="submit" value="立即注册" />
            </div>
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
