<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create</title>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="/static/style.css">
    <link rel="stylesheet" href="../static/bootstrap-5.0.2-dist/css/bootstrap.min.css">

</head>
<body>
<center>
    <h1>Create Product</h1>
</center>
    <div>
        <form action="/products" method="post">
            <label>Name</label>
                <input type="text"  name="name" id="name" >

            <label >Cost</label>
            <input type="text"  name="cost" id="cost">

            <label >Quantity</label>
            <input type="text"  name="quantity" id="quantity" >

            <label >Color</label>
            <input type="text"  name="color" id="color">

            <label >Describe</label>
            <input type="text"  name="describe" id="describe">

            <label >Category</label>
            <select  name="category" id="category">
                <option value="phone">phone</option>
                <option value="laptop">laptop</option>
                <option value="PC">PC</option>
                <option value="tablet">tablet</option>
                <option value="watch">watch</option>
            </select>

            <button
                    onclick="showModelCreate()"
                    type="button" class="btn btn-success"
                    style="display: inline-block;" id="button">Create
            </button>

            <h2 style="display: inline-block; margin: 50px;"><a class="btn btn-warning" href="/products" style="display: inline-block; left: 100px ;width: 100%; ">Back to list product</a></h2>

        </form>
    </div>

<!-- Modal -->
<div class="modal fade" id="modelEdit" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Xác nhận update:</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Ban muon create: <span id="nameProduct" style="color: green"></span> ?</p>
            </div>
            <form action="/products" method="post">
                <input type="hidden" name="action" value="create">
                <input type="hidden" name="name" value="" id="productName">
                <input type="hidden" name="cost" value="" id="productCost">
                <input type="hidden" name="quantity" value="" id="productQuantity">
                <input type="hidden" name="color" value="" id="productColor">
                <input type="hidden" name="describe" value="" id="productDescribe">
                <input type="hidden" name="category" value="" id="productCategory">
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-success">Create</button>

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

<script src="../static/datatables/js/jquery.dataTables.js"></script>
<script src="../static/datatables/js/dataTables.bootstrap4.js"></script>

<script>
    function showModelCreate(){
        var name = document.getElementById("name").value;
        var cost = document.getElementById("cost").value;
        var quantity = document.getElementById("quantity").value;
        var color = document.getElementById("color").value;
        var describe = document.getElementById("describe").value;
        var category = document.getElementById("category").value;

        function check(){
            var check = true;

            if(name==="" || name === "vui long nhap chinh xac"){
                var elm = document.getElementById("name");
                elm.style.color = "red";
                elm.value = "vui long nhap chinh xac";
                check = false;

            }
            if (cost==="" || isNaN(cost) || cost === "vui long nhap chinh xac"){
                var elm = document.getElementById("cost");
                elm.style.color = "red";
                elm.value = "vui long nhap chinh xac";
                check =  false;
            }
            if (quantity ==="" || isNaN(quantity) || quantity === "vui long nhap chinh xac"){
                var elm = document.getElementById("quantity");
                elm.style.color = "red";
                elm.value = "vui long nhap chinh xac";
                check = false;
            }

            if(color==="" || color === "vui long nhap chinh xac"){
                var elm = document.getElementById("color");
                elm.style.color = "red";
                elm.value = "vui long nhap chinh xac";
                check = false;
            }

            if(describe ==="" || describe === "vui long nhap chinh xac"){
                var elm = document.getElementById("describe");
                elm.style.color = "red";
                elm.value = "vui long nhap chinh xac";
                check = false;
            }

            return check;

        }
        if(check()){
            var btn = document.getElementById("button");
            btn.setAttribute("data-toggle","modal");
            btn.setAttribute("data-target","#modelEdit");
            document.getElementById("nameProduct").innerText = name;
            document.getElementById("productName").value = name;
            document.getElementById("productCost").value = cost;
            document.getElementById("productQuantity").value = quantity;
            document.getElementById("productColor").value = color;
            document.getElementById("productDescribe").value = describe;
            document.getElementById("productCategory").value = category;
        }
    }



</script>
</body>
</html>
