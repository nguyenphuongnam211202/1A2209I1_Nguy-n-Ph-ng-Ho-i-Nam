<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>may tinh</title>
</head>
<body>
<form action="/calculate" method="post">
  <input type="text" name="num1" placeholder="so thu nhat">
  <input type="text" name="num2" placeholder="so thu hai">
  <br><br>
  <input type="submit" value="cong" name="action">
  <input type="submit" value="tru" name="action">
  <input type="submit" value="nhan" name="action">
  <input type="submit" value="chia" name="action">
  <br><br>
  <p>Result: ${result}</p>
</form>
</body>
</html>