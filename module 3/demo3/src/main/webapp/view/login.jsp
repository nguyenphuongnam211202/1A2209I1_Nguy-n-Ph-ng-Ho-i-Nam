<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23/06/2023
  Time: 11:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/students" method="post">
    <h1>Đăng nhập hệ thống</h1>
    <label>Tên đăng nhập</label>
    <input type="text" name="tenDangNhap">
    <br> <br>
    <label>Mật khẩu</label>
    <input type="password" name="matKhau">
    <br><br>
    <input type="submit" value="dangnhap" name="action">
    <input type="reset" value="Hủy">
</form>
<p>${message}</p>
</body>
</html>
