<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 08/05/2023
  Time: 6:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="webjars\bootstrap\5.2.3\css\bootstrap.css">
    <title>Title</title>
</head>
<body>
<h2 style="text-align: center">Danh Sách Bệnh Án</h2>
<table class="table table-dark table-striped">
    <tr  class="table-danger">
        <th>Mã bệnh án</th>
        <th>Mã bệnh nhân</th>
        <th>Tên bệnh nhân</th>
        <th>Ngày nhập viện</th>
        <th>Ngày ra viện</th>
        <th>Lý do nhập viện</th>
        <th >Tác vụ</th>
    </tr>
    <c:forEach items="${listBenhAn}" var="ba">
        <tr class="table-warning">
            <td>${ba.maBenhAn}</td>
            <td>${ba.maBenhNhan}</td>
            <td>${ba.tenBenhNhan}</td>
            <td>${ba.ngayNhapVien}</td>
            <td>${ba.ngayRaVien}</td>
            <td>${ba.lyDo}</td>
            <td>
                <a href="/benhAn?action=edit&id=${ba.maBenhAn}">Edit</a>
                <a href="/benhAn?action=delete&id=${ba.maBenhAn}">Delete</a>
            </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
