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
    <title>Product List</title>
    <link rel="stylesheet" href="webjars\bootstrap\5.2.3\css\bootstrap.css">
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<h1>Product List</h1>

    <form class="w3-container" action="/products" method="post">
        <p>
            <input class="w3-input w3-border w3-sand" name="id"  type="text" placeholder="nhập Id sản phẩm muốn tìm" style="border-radius: 10px">
            <input type="submit" name="action" value="findById" class="button">
        </p>

    </form>

<p>
    <a href="/products?action=create">Create new product</a>
</p>
<table class="table table-dark table-striped">
    <tr class="table-danger">
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Mô tả</th>
        <th>Nhà sản xuất</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
<c:forEach items='${requestScope["products"]}' var="product">
    <tr class="table-warning">
        <td>${product.id}</td>
        <td><a href="/products?action=view&id=${product.getId()}">${product.name}</a></td>
        <td>${product.price}</td>
        <td>${product.description}</td>
        <td>${product.producer}</td>
        <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
        <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
