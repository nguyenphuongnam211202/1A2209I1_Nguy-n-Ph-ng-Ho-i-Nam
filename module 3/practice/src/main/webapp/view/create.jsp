<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/04/2023
  Time: 11:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="webjars\bootstrap\5.2.3\css\bootstrap.css">
    <link rel="stylesheet" href="/static/style.css">

</head>
<body>
<center>
    <h1>Create Product</h1>
</center>
    <div>
        <form action="/products" method="post">
            <label>Name</label>
                <input type="text"  name="name" >

            <label >Cost</label>
            <input type="text"  name="cost" >

            <label >Quantity</label>
            <input type="text"  name="quantity" >

            <label >Color</label>
            <input type="text"  name="color" >

            <label >Describe</label>
            <input type="text"  name="describe" >

            <label >Category</label>
            <select  name="category">
                <option value="phone">phone</option>
                <option value="laptop">laptop</option>
                <option value="PC">PC</option>
                <option value="tablet">tablet</option>
                <option value="watch">watch</option>
            </select>

            <input type="submit" name="action" value="create">
        </form>
    </div>

</body>
</html>
