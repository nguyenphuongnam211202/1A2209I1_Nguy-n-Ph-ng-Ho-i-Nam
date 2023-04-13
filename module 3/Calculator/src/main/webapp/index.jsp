<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div>
    <form action="/calculator" method="post">
    <h1>Calculator</h1>
    <table>
        <tr>
            <td>First Operand</td>
            <td><input type="text" name="num1"></td>
        </tr>
        <tr>
            <td>Operator</td>
            <td><select name="phepTinh">
                <option value="cong">cong</option>
                <option value="tru">tru</option>
                <option value="nhan">nhan</option>
                <option value="chia">chia</option>
            </select></td>
        </tr>
        <tr>
            <td>Second operand</td>
            <td><input type="text" name="num2"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Calculate"></td>
        </tr>
    </table>
    </form>
    <p>${result}</p>

</div>
</body>
</html>