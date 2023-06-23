<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24/06/2023
  Time: 12:59 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới sinh viên</h1>
<form action="/students" method="post">
<table>
    <tr><td>Mã sinh viên</td>
    <td><input type="text" name="mssv"></td>
    </tr>
    <tr><td>Họ tên</td>
    <td><input type="text" name="hoTen"></td>
    </tr>
    <tr>
        <td>Giới tính</td>
        <td><input name="gioiTinh" type="radio" value="Nam" />Nam
            <input name="gioiTinh" type="radio" value="Nữ" />Nữ</td>
    </tr>
    <tr><td>Khoa</td>
    <td><select name="listKhoa">
        <option value="khoa Toan">Khoa Toan</option>
        <option value="khoa Ly">Khoa Ly</option>
        <option value="khoa Hoa">Khoa Hoa</option>
        <option value="khoa CNTT">Khoa CNTT</option>
    </select></td></tr>
    <tr>
        <td></td>
        <td><input type="submit" name="action" value="them moi">
            <input type="submit" name="action" value="quay lai">
        </td>
    </tr>
</table>
</form>
</body>
</html>
