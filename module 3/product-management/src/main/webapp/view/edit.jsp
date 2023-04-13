<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/04/2023
  Time: 9:09 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Form</title>
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
<h1>Edit Product</h1>
<p>${message}</p>
<p>
    <a href="/products">Back to Product List</a>
</p>
<form action="/products" method="post">
    <fieldset>
        <legend>Product Information</legend>
        <table class="table">
            <tr>
                <td>Id:</td>
                <td><input type="text" name="id" id="id" value="${product.id}" readonly ></td>
            </tr>
            <tr>
                <td>Tên sản phẩm</td>
                <td><input type="text" name="name" id="name" value="${product.name}"></td>
            </tr>
            <tr>
                <td>Giá:</td>
                <td><input type="text" name="price" id="price" value="${product.price}"></td>
            </tr>
            <tr>
                <td>Mô tả:</td>
                <td><input type="text" name="description" id="description" value="${product.description}"></td>
            </tr>
            <tr>
                <td>Nhà sản xuất: </td>
                <td><input type="text" name="producer" id="producer" value="${product.producer}"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="action" value="edit" class="button"></td>
            </tr>
    </table>
    </fieldset>
</form>
</body>
</html>
