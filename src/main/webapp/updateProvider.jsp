<%@ page import="jsu.com.bean.Provider" %>
<%--
  Created by IntelliJ IDEA.
  User: dsl
  Date: 2021/1/3
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>修改供应商信息</title>
    <link rel="stylesheet"  type="text/css" href="css/updateProvider.css">
    <style type="text/css">
        body{
            background:#fff url("images/背景图 (1).jpg") no-repeat left top;
            background-size:100%;
            position:relative;
        }
    </style>

    <script>
        function validate() {
            //通过id获取值
            var tel = document.getElementById("provider_tel").value;
            var provider_name=document.getElementById("provider_name").value;
            var provider_address=document.getElementById("provider_address").value;

            //验证电话号码合法性
            var pattern = /^[1][0-9]{10}$/;

            if(tel==''){
                alert("电话号码不能为空！");
                return false;
            }else if(!pattern.test(tel)){
                alert("电话号码格式不正确！");
                return false;
            }

            if(provider_name==''||provider_address==''){
                alert("供应商名和供应商地址不能为空！");
                return false;
            }

            return true;
        }
    </script>

    <%
        Provider provider=(Provider) request.getSession().getAttribute("SESSION_provider");
    %>
</head>
<body>
<div class="content-area">
    <div class="form_area">
        <form action="/stock/UpdateProviderServlet" method="post" onsubmit="return validate()">
            <input type="hidden" name="goods_id" value="<%=provider.getProviderId()%>">
            <div class="table-area">
                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="110" align="right" bgcolor="#F8F8F8">供应商名称：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="provider_name" id="provider_name" value="<%=provider.getProviderName()%>"></td>
                    </tr>
                </table>

                <div class="he"></div>

                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="110" align="right" bgcolor="#F8F8F8">供应商地址：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="provider_address" id="provider_address" value="<%=provider.getProviderAddress()%>"/></td>
                    </tr>
                </table>

                <div class="he"></div>

                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                    <tr>
                        <th width="110" align="right" bgcolor="#F8F8F8">供应商电话：</th>
                        <td bgcolor="#F8F8F8"><input type="text" name="provider_tel" id="provider_tel" value="<%=provider.getProviderTel()%>"/></td>
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
