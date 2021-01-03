<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="jsu.com.bean.User" %>
<%--
  Created by IntelliJ IDEA.
  User: dsl
  Date: 2020/12/30
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户修改密码</title>
    <link rel="stylesheet"  type="text/css" href="css/updateChangePassword.css">
    <style type="text/css">
        body{
            background:#fff url("images/背景图 (1).jpg") no-repeat left top;
            background-size:100%;
            position:relative;
        }
    </style>

    <script>
        function fun1() {
            var oldPassword=document.getElementById("oldPassword").value;
            var newPassword=document.getElementById("newPassword").value;
            var comparePassword=document.getElementById("comparePassword").value;

            if(oldPassword==''){
                alert("请输入原来的密码");
                return false;
            }

            if(newPassword==''||comparePassword==''){
                alert("新密码和确认密码不能为空");
                return false;
            }
            if(newPassword!=comparePassword){
                alert("新密码和确认密码不一致");
                return false;
            }
            if(oldPassword==newPassword){
                alert("旧密码和新密码一致，不能修改！");
                return false;
            }
            return true;
        }
    </script>

    <%
        User user=(User) request.getSession().getAttribute("user");
        //request.getSession().setAttribute("user",user);
    %>

</head>
<body>
<div class="header_area">
    <ul class="menu-list">
        <li><a href="/stock/GoodsBasicInfoServlet">商品信息管理</a></li>
        <li><a href="/stock/OrderServlet">商品出入库管理</a></li>
        <li><a href="/stock/ProviderServlet">供应商管理</a></li>
        <li><a href="/stock/UserChangePasswordServlet">修改密码</a></li>
    </ul>
</div>
<div class="user_info">
    <form action="/stock/ChangePasswordServlet" method="post" onsubmit="return fun1()">
        <input type="hidden" name="id" value="<%=user.getId()%>" />
        <div class="table_style">
            <table width="400" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                <tr>
                    <th width="150" align="right" bgcolor="#F8F8F8">用户名：</th>
                    <td bgcolor="#F8F8F8"><input class="username" type="text" value="<%=user.getUsername()%>" readonly></td>
                </tr>
            </table>
            <div class="space"></div>
            <table width="400" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                <tr>
                    <th width="150" align="right" bgcolor="#F8F8F8">旧密码：</th>
                    <td bgcolor="#F8F8F8"><input id="oldPassword" type="password" name="oldPassword"></td>
                </tr>
            </table>
            <div class="space"></div>
            <table width="400" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                <tr>
                    <th width="150" align="right" bgcolor="#F8F8F8">新密码：</th>
                    <td bgcolor="#F8F8F8"><input type="password" name="newPassword" id="newPassword"></td>
                </tr>
            </table>
            <div class="space"></div>
            <table width="400" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                <tr>
                    <th width="150" align="right" bgcolor="#F8F8F8">确认密码：</th>
                    <td bgcolor="#F8F8F8"><input type="password" name="comparePassword" id="comparePassword"></td>
                </tr>
            </table>
        </div>
        <div class="updata_button"><input name="update" type="submit" value="修改"/></div>
    </form>

    <%--<script>
        $(function () {
            $('#password').click(function () {

                alert();
                var uname = ${user.username};
                var password = document.getElementById("password");
                var url = "/stock/UserChangePasswordServlet";
                $.ajax({
                    async:false,
                    contentType:"application/x-www-form-urlencoded",
                    url:url,
                    data:"password="+password+"&uname="+uname,
                    type:"GET",
                    success:function () {
                        alert();
                    }
                })

            })
        })

    </script>--%>
</div>
</body>
</html>
