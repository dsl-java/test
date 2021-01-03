<%--
  Created by IntelliJ IDEA.
  User: dsl
  Date: 2021/1/3
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加订单</title>
    <link rel="stylesheet"  type="text/css" href="css/addOrders.css">
    <style type="text/css">
        body{
            background:#fff url("images/背景图 (1).jpg") no-repeat left top;
            background-size:100%;
            position:relative;
        }
    </style>
</head>
<body>
<div class="content-area">
    <div class="form_area">
        <form action="/stock/AddOrdersServlet" method="post">
            <div class="table-area">

                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="120" align="right" bgcolor="#F8F8F8">订单类型：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="order_type" /></td>
                    </tr>
                </table>

                <div class="he"></div>

                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="120" align="right" bgcolor="#F8F8F8">交易人：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="trader" /></td>
                    </tr>
                </table>

                <div class="he"></div>

                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="120" align="right" bgcolor="#F8F8F8">订购商品编号：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="order_goods_id"></td>
                    </tr>
                </table>

                <div class="he"></div>

                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="120" align="right" bgcolor="#F8F8F8">订单数量：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="order_count"></td>
                    </tr>
                </table>

            </div>
            <div class="button_area">
                <input type="submit" value="添加" name="addButton" />
            </div>
        </form>
    </div>
</div>
</body>
</html>
