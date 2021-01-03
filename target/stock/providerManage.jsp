<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dsl
  Date: 2021/1/1
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>供应商管理</title>
    <link rel="stylesheet"  type="text/css" href="css/providerManage.css">
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
    <form action="/stock/LookupProviderServlet" method="get">
        <input type="text" name="search" placeholder="请输入供应商编号"/>
        <button >搜索<i class="fa fa-search"></i></button>
        <input type="button" value="添加" name="addButton" onclick="jump()"/>
        <script>
            function jump() {
                window.open("addProvider.jsp");
            }
        </script>
        <table border="1px" cellspacing="0"  cellpadding="5" align="center">
            <thead>
            <td width="140px">供应商编号</td>
            <td>供应商名称</td>
            <td>供应商地址</td>
            <td>供应商电话</td>
            <td>操作</td>
            </thead>
            <tbody>

            <c:forEach items="${providerList}" var="provider">
            <tr>
                <td>${provider.providerId}</td>
                <td>${provider.providerName}</td>
                <td>${provider.providerAddress}</td>
                <td>${provider.providerTel}</td>
                <td>
                   <%-- <input type="button" value="修改" naem="updateButton"/>
                    <input type="button" value="删除" naem="deleteButton"/>--%>
                       <a href="/stock/UpdateProviderBasicInfoServlet?providerId=${provider.providerId}" onclick="Location.reload()">修改</a>
                       <a href="/stock/DelProviderServlet?providerId=${provider.providerId}" onclick="Location.reload()" >删除</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
