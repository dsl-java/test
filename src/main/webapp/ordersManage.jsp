<%--
  Created by IntelliJ IDEA.
  User: dsl
  Date: 2021/1/3
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>商品出入库管理</title>
    <link rel="stylesheet"  type="text/css" href="css/ordersManage.css">
    <link rel="stylesheet"  type="text/css" href="css/font-awesome.css">
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
        <li><a href="/stock/GoodsBasicInfoServlet">商品信息管理</a></li>
        <li><a href="/stock/OrderServlet">商品出入库管理</a></li>
        <li><a href="/stock/ProviderServlet">供应商管理</a></li>
        <li><a href="/stock/UserChangePasswordServlet">修改密码</a></li>
    </ul>
</div>
<div class="table-area">
    <form action="/stock/LookupOrdersServlet" method="get">
        <input type="text" name="search" placeholder="请输入订单号"/>
        <button >搜索<i class="fa fa-search"></i></button>
        <input type="button" value="添加" name="addButton" onclick="jump()"/>
        <script>
            function jump() {
                window.open("addOrders.jsp");
            }
        </script>
        <table border="1px" cellspacing="0"  cellpadding="5" align="center">
            <thead>
            <td>订单号</td>
            <td>订单类型</td>
            <td>交易人</td>
            <td>订购商品编号</td>
            <td>订单数量</td>
            </thead>
            <tbody>
            <c:forEach items="${ordersList}" var="orders">
            <tr>
                <td>${orders.orderId}</td>
                <td>${orders.orderType}</td>
                <td>${orders.trade}</td>
                <td>${orders.orderGoodsId}</td>
                <td>${orders.orderCount}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
