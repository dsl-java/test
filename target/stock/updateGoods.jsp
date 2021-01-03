<%@ page import="jsu.com.bean.GoodsBasicInfo" %><%--
  Created by IntelliJ IDEA.
  User: dsl
  Date: 2021/1/2
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改商品信息</title>
    <link rel="stylesheet"  type="text/css" href="css/updateGoods.css">
    <style type="text/css">
        body{
            background:#fff url("images/背景图 (1).jpg") no-repeat left top;
            background-size:100%;
        }
    </style>

    <%
        GoodsBasicInfo goodsBasicInfo=(GoodsBasicInfo) request.getSession().getAttribute("SESSION_goodsBasicInfo");
    %>
</head>
<body>
<div class="content-area">
    <div class="form_area">
        <form action="/stock/UpdateGoodsServlet" method="post">
            <input type="hidden" name="goods_id" value="<%=goodsBasicInfo.getGoodsId()%>">
            <div class="table-area">
                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="110" align="right" bgcolor="#F8F8F8">商品名：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="goods_name" value="<%=goodsBasicInfo.getGoodsName()%>"></td>
                    </tr>
                </table>

                <div class="he"></div>

                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="110" align="right" bgcolor="#F8F8F8">商品类型：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="goods_type" value="<%=goodsBasicInfo.getGoodsType()%>"/></td>
                    </tr>
                </table>

                <div class="he"></div>

                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="110" align="right" bgcolor="#F8F8F8">商品库存：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="goods_stock" value="<%=goodsBasicInfo.getGoodsStock()%>"/></td>
                    </tr>
                </table>

                <div class="he"></div>

                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="110" align="right" bgcolor="#F8F8F8">商品价格：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="goods_price" value="<%=goodsBasicInfo.getGoodsPrice()%>" /></td>
                    </tr>
                </table>

                <div class="he"></div>

                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="110" align="right" bgcolor="#F8F8F8">供应商：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="provider_id" value="<%=goodsBasicInfo.getProvider_id()%>"/></td>
                    </tr>
                </table>
            </div>

            <div class="button_area">
                <input type="submit" value="修改" name="addButton" />
            </div>
        </form>
    </div>
</div>
</body>
</html>
