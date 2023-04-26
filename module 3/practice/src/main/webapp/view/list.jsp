<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List</title>
    <link rel="stylesheet" href="webjars\bootstrap\5.2.3\css\bootstrap.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="/static/css/style.css">

    <style>
        #button {
            background-color: #d78b3c;
            border: none;
            color: white;
            padding: 8px 16px;
            text-decoration: none;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 20px;
            display: inline;
            width: 136px;
            height: 38px;
        }
    </style>
</head>
<body>
<center>
    <h1 ><a href="/products" style="font-family: 'Times New Roman';text-decoration: none">List Product</a> </h1>
    <h2>
        <a class="btn btn-success"  href="products?action=create" style="float: left; width: 15%; margin: 10px">Create new product</a>
        <div style="float: right; display: inline-block; width: 40%;margin: 10px" >
            <form action="/products" method="post">
                <div class="input-group mb-3" >
                    <input type="text" class="form-control" placeholder="Nhập id muốn tìm" name="id" >
                    <input class="btn btn-outline-success" type="submit" id="button-addon2" name="action" value="search">
                </div>
            </form>
        </div>
    </h2>
</center>
<table class="table table-dark table-striped" id="tableProduct">
    <thead>
    <tr class="table-danger">
        <th>ID</th>
        <th>Name</th>
        <th>COST</th>
        <th>QUANTITY</th>
        <th>COLOR</th>
        <th>DESCRIBE</th>
        <th>CATEGORY</th>
        <th style="text-align: center">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productList}" var="product">
        <tr class="table-warning">
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.cost}</td>
            <td>${product.quantity}</td>
            <td>${product.color}</td>
            <td>${product.describe}</td>
            <td>${product.category}</td>
            <td>
                <a  class="btn btn-primary" href="/products?action=edit&id=${product.id}">Edit</a>
            <button
                    onclick="showModelDelete('${product.id}','${product.name}')"
                    type="button" class="btn btn-danger" data-toggle="modal" data-target="#modelDelete">Delete</button>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="modelDelete" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Bạn có chắc chắn xóa không :</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Ban muon xoa: <span id="productName" style="color: red"></span> ?</p>
            </div>
            <form action="/products" method="get">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="" id="productId">
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableProduct').dataTable({
            'pageLength' : 2,
            'searching' : false
        })
    })

    function showModelDelete(id, name) {
        console.log(id, name);
        document.getElementById("productName").innerText = name;
        document.getElementById("productId").value = id;
    }
</script>
</body>
</html>
