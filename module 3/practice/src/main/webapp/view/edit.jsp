<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="webjars\bootstrap\5.2.3\css\bootstrap.css">
    <link rel="stylesheet" href="/static/style.css">

</head>
<body>
<center>
    <h1>Edit Product</h1>
</center>

<div>
    <form action="/products" method="post">
        <label>Id</label>
        <input type="text" name="id" readonly value="${product.getId()}">

        <label>Name</label>
        <input type="text" name="name" value="${product.getName()}">

        <label>Cost</label>
        <input type="text" name="cost" value="${product.getCost()}">

        <label>Quantity</label>
        <input type="text" name="quantity" value="${product.getQuantity()}">

        <label>Color</label>
        <input type="text" name="color" value="${product.getColor()}">

        <label>Describe</label>
        <input type="text" name="describe" value="${product.getDescribe()}">

        <label>Category</label>
        <select name="category">
            <option value="phone">phone</option>
            <option value="laptop">laptop</option>
            <option value="PC">PC</option>
            <option value="tablet">tablet</option>
            <option value="watch">watch</option>
        </select>

        <input type="submit" name="action" value=" update" style="display: inline-block;">

        <h2 style="display: inline-block; margin-left: 50px;"><a class="btn btn-warning" href="/products" style="display: inline-block; left: 100px ;width: 100%; ">Back to list
            product</a></h2>
    </form>
</div>




<!-- Modal -->
<%--<div class="modal fade" id="modelDelete" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">--%>
<%--    <div class="modal-dialog" role="document">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title">Bạn có chắc chắn xóa không :</h5>--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                    <span aria-hidden="true">&times;</span>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--                <p>Ban muon xoa: <span id="productName" style="color: red"></span> ?</p>--%>
<%--            </div>--%>
<%--            <form action="/products" method="get">--%>
<%--                <input type="hidden" name="action" value="delete">--%>
<%--                <input type="hidden" name="id" value="" id="productId">--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                    <button type="submit" class="btn btn-danger">Delete</button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"--%>
<%--        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"--%>
<%--        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"--%>
<%--        crossorigin="anonymous"></script>--%>

<%--<script src="../static/datatables/js/jquery.dataTables.js"></script>--%>
<%--<script src="../static/datatables/js/dataTables.bootstrap4.js"></script>--%>

<%--<script>--%>
<%--    $(document).ready(function () {--%>
<%--        $('#tableProduct').dataTable({--%>
<%--            'pageLength': 2,--%>
<%--            'searching': false--%>
<%--        })--%>
<%--    })--%>

<%--    function showModelDelete(id, name) {--%>
<%--        console.log(id, name);--%>
<%--        document.getElementById("productName").innerText = name;--%>
<%--        document.getElementById("productId").value = id;--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>

