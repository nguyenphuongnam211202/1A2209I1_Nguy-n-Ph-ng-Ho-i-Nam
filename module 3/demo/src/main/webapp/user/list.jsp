<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13/04/2023
  Time: 5:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="webjars\bootstrap\5.2.3\css\bootstrap.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="/static/css/style.css">
    <style>
        #button{
            background-color: #d78b3c;
            border: none;
            color: white;
            padding: 8px 16px;
            text-decoration: none;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 20px;
            display: inline;
            width: 136px;
            height: 38px;
        }
    </style>
</head>
<body>
<center>
    <h1>User Management</h1>
    <caption> <h2>
        <a href="/users">List user</a>
    </h2></caption>
    <h2><a href="users?action=create">Create new user</a></h2>
    <form class="w3-container" action="/users" method="post">
        <p>
            <input class="w3-input w3-border w3-sand" name="findCountry"  type="text" placeholder="Nhập country user mà bạn muốn tìm" style="border-radius: 10px">
            <br>
            <input type="submit" name="action" value="findByCountry" id="button">
        </p>

    </form>
    <form action="/users" method="post">
        <input type="submit" name="action" value="sortByName" >
    </form>
</center>
<table class="table table-dark table-striped">
    <tr  class="table-danger">
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th colspan="2" style="text-align: center">Actions</th>
    </tr>
    <c:forEach items="${listUser}" var="user">
        <tr class="table-warning">
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td>
                <a href="/users?action=edit&id=${user.id}">Edit</a>
            </td>
            <td>
                <a href="/users?action=delete&id=${user.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
