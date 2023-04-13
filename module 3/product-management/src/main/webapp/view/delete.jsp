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
    <title>Delete Product</title>
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
<h1>Delete Product</h1>
<p>
    <a href="/products">Back to Product List</a>
</p>
<form action="/products" method="post">
    <h3>Are you sure you want to delete this product?</h3>
        <fieldset>
            <legend>Product Information</legend>
            <table class="table">
                <tr>
                    <td>Id:</td>
                    <td><input type="text" name="id" id="id" value="${product.id}" readonly ></td>
                </tr>
                <tr>
                    <td>Tên sản phẩm</td>
                    <td><input type="text" name="name" id="name" value="${product.name}" readonly></td>
                </tr>
                <tr>
                    <td>Giá:</td>
                    <td><input type="text" name="price" id="price" value="${product.price}" readonly></td>
                </tr>
                <tr>
                    <td>Mô tả:</td>
                    <td><input type="text" name="description" id="description" value="${product.description}" readonly></td>
                </tr>
                <tr>
                    <td>Nhà sản xuất: </td>
                    <td><input type="text" name="producer" id="producer" value="${product.producer}" readonly></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="action" value="delete" class="button"></td>
                </tr>
                <tr>
                    <td colspan="2">${message}</td>
                </tr>
            </table>
        </fieldset>
</form>
</body>
</html>
