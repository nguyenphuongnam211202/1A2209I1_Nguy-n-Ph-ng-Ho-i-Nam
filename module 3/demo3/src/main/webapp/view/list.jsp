<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23/06/2023
  Time: 11:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="display:inline-block;float: left">
    <form action="/students" method="post">
        <select name="listKhoa">
            <option value="khoa Toan">Khoa Toan</option>
            <option value="khoa Ly">Khoa Ly</option>
            <option value="khoa Hoa">Khoa Hoa</option>
            <option value="khoa CNTT">Khoa CNTT</option>
        </select>
        <input type="submit" name="action" value="xem">
    </form>
</div>
<table class="table table-dark table-striped">
    <tr  class="table-danger">
        <th>MSV</th>
        <th>Họ và tên</th>
        <th>Giới tính</th>
        <th>Khoa</th>
        <th></th>
    </tr>
    <c:forEach items="${studentList}" var="student">
        <tr class="table-warning">
            <td>${student.mssv}</td>
            <td>${student.hoTen}</td>
            <td>${student.gioiTinh}</td>
            <td>${student.khoa}</td>

            <td>
                <a href="/students?action=edit&id=${student.id}">Edit</a>
                <a href="/students?action=delete&id=${student.id}">Delete</a>
            </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
