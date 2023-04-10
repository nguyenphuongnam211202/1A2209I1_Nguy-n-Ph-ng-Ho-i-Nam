<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="webjars\bootstrap\5.2.3\css\bootstrap.css">
</head>
<body>
<h1>Danh Sach Khach Hang</h1>
<table class="table">
    <thead>
    <tr >
        <th>tên</th>
        <th>ngày sinh</th>
        <th>địa chỉ</th>
        <th>ảnh</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customerList}" var="Customer">
        <tr >
            <td >${Customer.name}</td>
            <td >${Customer.birthday}</td>
            <td  >${Customer.address}</td>
            <td><img src="/static/img/${Customer.img}" alt="" width="50px"></td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>