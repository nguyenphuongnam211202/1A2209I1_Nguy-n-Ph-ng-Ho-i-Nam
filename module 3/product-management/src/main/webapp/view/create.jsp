<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/04/2023
  Time: 9:09 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Form</title>
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
<h1>Create new Product</h1>
<p>
        <span>${message}</span>
</p>
<p>
    <a href="/products">Back to product List</a>
</p>
<form action="/products" method="post">
    <legend>Product Information</legend>
    <table class="table">
        <tr >
            <td>Id</td>
            <td><input type="text" name="id" id="id"></td>
        </tr>
        <tr >
            <td>Tên sản phẩm</td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td>Giá:</td>
            <td><input type="text" name="price" id="price"></td>
        </tr>
        <tr>
            <td>Mô tả:</td>
            <td><input type="text" name="description" id="description"></td>
        </tr>
        <tr>
            <td>Nhà sản xuất: </td>
            <td><input type="text" name="producer" id="producer"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="action" value="create" class="button" c></td>
        </tr>
    </table>
</form>
</body>
</html>
