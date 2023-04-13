<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/04/2023
  Time: 9:10 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<p>
    <a href="products">Back to Product List</a>
</p>
<fieldset>
    <legend>Product Information</legend>
    <table class="table">
        <tr>
            <td>Id:</td>
            <td>${product.id}</td>
        </tr>
        <tr>
            <td>Tên sản phẩm:</td>
            <td>${product.name}</td>
        </tr>
        <tr>
            <td>Giá:</td>
            <td>${product.price}</td>
        </tr>
        <tr>
            <td>Mô tả:</td>
            <td>${product.description}</td>
        </tr>
        <tr>
            <td>Nhà sản xuất: </td>
            <td>${product.producer}</td>
        </tr>

    </table>
</fieldset>
</body>
</html>
