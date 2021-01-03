<%--
  Created by IntelliJ IDEA.
  User: dsl
  Date: 2021/1/2
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
    <link rel="stylesheet"  type="text/css" href="css/addGoods.css">
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
        <form action="/stock/AddGoodsBasicInfoServlet" method="post">
            <div class="table-area">
                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="110" align="right" bgcolor="#F8F8F8">商品名：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="goods_name"></td>
                    </tr>
                </table>

                <div class="he"></div>

                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="110" align="right" bgcolor="#F8F8F8">商品类型：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="goods_type" /></td>
                    </tr>
                </table>

                <div class="he"></div>

                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="110" align="right" bgcolor="#F8F8F8">商品库存：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="goods_stock" /></td>
                    </tr>
                </table>

                <div class="he"></div>

                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="110" align="right" bgcolor="#F8F8F8">商品价格：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="goods_price" /></td>
                    </tr>
                </table>

                <div class="he"></div>

                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="110" align="right" bgcolor="#F8F8F8">供应商：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="provider_id" /></td>
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
