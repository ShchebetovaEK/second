<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<html>
<header>
    <%@include file="../header/header.jsp" %>
</header>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="../../img/png-transparent-graphy-logo-tree-leaf-branch-logo.png" type="image/x-icon">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/fontello.css">
    <title>Welcome</title>
</head>
<body>
<h1 class="text-center"> WELCOME, ${user.firstName} ${user.lastName}!!</h1>
<div class="card-group">
    <div class="card text-body  bg-info mb-3">
        <img src='<%=request.getContextPath() %>/img/card2.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title"> Our Laboratory</h5>
            <p class="card-text"> Our laboratory is equipped with modern equipment.</p>
            <p class="card-text">The analysis for Covid-19 is carried out by PCR. More..<small class="text-muted"></small></p>
        </div>
    </div>
    <div class="card bg-light mb-3">
        <img src='<%=request.getContextPath() %>/img/card3.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">Therapeutic direction</h5>
            <p class="card-text">The therapeutic direction is represented by all possible specializations.</p>
            <p class="card-text">More possible specializations here..<small class="text-muted"></small></p>
        </div>
    </div>
    <div class="card bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card4.jpeg' class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">Medical research</h5>
            <p class="card-text">In our center you can perform MRI, ultrasound, X-ray.</p>
            <p class="card-text">CT and lung ultrasound<small class="text-muted"></small></p>
        </div>
    </div>
</div>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>