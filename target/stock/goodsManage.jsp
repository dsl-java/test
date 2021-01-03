<%--
  Created by IntelliJ IDEA.
  User: dsl
  Date: 2021/1/1
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>商品信息管理</title>
    <link rel="stylesheet"  type="text/css" href="css/goodsManage.css">
    <link rel="stylesheet"  type="text/css" href="css/font-awesome.css"/>
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
        <form action="/stock/LookupGoodsBasicInfoServlet" method="post">
            <input type="text" name="search" placeholder="请输入商品编号" />
            <button>搜索<i class="fa fa-search"></i></button>
            <input type="button" value="添加" name="addButton" onclick="jump()"/>
            <script>
                function jump() {
                    window.open("addGoods.jsp");
                }
            </script>
            <table border="1px" cellspacing="0"  cellpadding="5" align="center">

                <thead>
                <td width="140px">商品编号</td>
                <td>商品名</td>
                <td>商品类型</td>
                <td>库存</td>
                <td>价格</td>
                <td>提供商</td>
                <td>操作</td>
                </thead>
                <tbody>
                <c:forEach items="${goodsBasicInfoList}" var="goodsBasicInfo">
                <tr>
                    <td bgcolor="">${goodsBasicInfo.goodsId}</td>
                    <td>${goodsBasicInfo.goodsName}</td>
                    <td>${goodsBasicInfo.goodsType}</td>
                    <td>${goodsBasicInfo.goodsStock}</td>
                    <td>${goodsBasicInfo.goodsPrice}</td>
                    <td>${goodsBasicInfo.provider_id}</td>
                    <td>
                       <%-- <input type="button" value="修改" naem="updateButton"/>
                        <input type="button" value="删除" naem="deleteButton"/>--%>
                        <a href="/stock/UpdateGoodsBasicInfoServlet?goodsId=${goodsBasicInfo.goodsId}" onclick="Location.reload()">修改<i class="fa fa-pencil"></i></a>
                           <a href="/stock/DelGoodsBasicInfoServlet?goodsId=${goodsBasicInfo.goodsId}" onclick="Location.reload()" >删除<i class="fa fa-trash"></i></a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>

            </table>
        </form>
    </div>


</body>
</html>
