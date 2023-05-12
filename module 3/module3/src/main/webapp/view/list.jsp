<%--
  Created by IntelliJ IDEA.
  User: thu
  Date: 11/12/2020
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thống kê sách đang cho </title>
</head>
<body>
<table>
    <tr>
        <th>Mã mượn sách</th>
        <th>Tên sách</th>
        <th>Tác Giả</th>
        <th>Tên Học Sinh</th>
        <th>Lớp</th>
        <th>Ngày Mượn</th>
        <th>Ngày Trả</th>
        <th></th>

    </tr>
    <c:forEach items="${theMuonSachList}" var="theMuonSach">
        <tr>
            <td>${theMuonSach.getMaMuonSach()}</td>
            <td>${theMuonSach.getSach().getTenSach()}</td>
            <td>${theMuonSach.getSach().getTacGia()}</td>
            <td>${theMuonSach.getHocSinh().getHoTen()}</td>
            <td>${theMuonSach.getHocSinh().getLop()}</td>
            <td>${theMuonSach.getNgayMuon()}</td>
            <td>${theMuonSach.getNgayTra()}</td>
            <td>
                <a href="/books?action=edit&id=${product.getProductId()}">Mượn</a>
            </td>


        </tr>
    </c:forEach>
</table>

</body>
</html>
