<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Ứng dụng chuyển đổi tiền tệ</h1>
<form action="/change" method="post">
    <input type="text" name="usd" placeholder="USD">
    <input type="submit" value="change">
</form>
<p>${vnd} </p>
</body>
</html>