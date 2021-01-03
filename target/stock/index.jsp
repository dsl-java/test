<%@ page import="jsu.com.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: dsl
  Date: 2020/12/30
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>超市库存管理系统-首页</title>
    <link rel="stylesheet"  type="text/css" href="css/index.css">
    <style type="text/css">
        body{
            background:#fff url("images/背景图 (1).jpg") no-repeat left top;
            background-size:100%;
            position:relative;
        }
    </style>
</head>
<body>
<div class="header_area">
    <ul class="menu-list">
        <%
            User user=(User) request.getSession().getAttribute("user");
            request.getSession().setAttribute("user",user);
        %>
        <li><a href="/stock/GoodsBasicInfoServlet">商品信息管理</a></li>
        <li><a href="/stock/OrderServlet">商品出入库管理</a></li>
        <li><a href="/stock/ProviderServlet">供应商管理</a></li>
        <li><a href="/stock/UserChangePasswordServlet">修改密码</a></li>
    </ul>
</div>
<div class="text">
    欢迎使用超市库存管理系统
</div>
</body>
</html>
