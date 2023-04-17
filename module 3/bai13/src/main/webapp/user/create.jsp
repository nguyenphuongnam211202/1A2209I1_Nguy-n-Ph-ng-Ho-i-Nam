<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13/04/2023
  Time: 5:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new user</title>
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users">Back to list user</a>
    </h2>
    <caption><h2>Create new user</h2></caption>
</center>
<div>
    <form action="/users" method="post">

        <label >Name: </label>
        <input type="text" name="name" placeholder="Nhap ten user">

        <label >Email: </label>
        <input type="text" name="email" placeholder="Nhap email">

        <label >Country</label>
        <input type="text"  name="country" placeholder="Nhap country">

        <input type="submit" name="action" value="create">
    </form>
    <h3>${message}</h3>
</div>
</body>
</html>
