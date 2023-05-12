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

  <h1 style="text-align: center">Sửa thông tin bệnh án</h1>


<div>
  <form action="/benhAn" method="post">

    <label >Mã bệnh án </label>
    <input type="text" name="maBenhAn" value="${ba.getMaBenhAn()}" readonly>
    <br><br>

    <label >Mã bệnh nhân </label>
    <input type="text" name="maBenhNhan" value="${ba.getMaBenhNhan()}" readonly>
    <br><br>

    <label >Tên bệnh nhân</label>
    <input type="text" name="tenBenhNhan" value="${ba.getTenBenhNhan()}" >
    <br><br>

    <label >Ngày nhập viện</label>
    <input type="text"  name="ngayNhapVien" value="${ba.getNgayNhapVien()}" >
    <br><br>

    <label >Ngày ra viện</label>
    <input type="text"  name="ngayRaVien" value="${ba.getNgayRaVien()}" >
    <br><br>

    <label >Lý do nhập viện</label>
    <input type="text"  name="lyDoNhapVien" value="${ba.getLyDo()}" >
    <br><br>

    <input type="submit" name="action" value="update">
    <button> <a href="/benhAn">Trở về danh sách</a></button>
  </form>
</div>
</body>
</html>