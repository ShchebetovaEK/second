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
    <title>Pediatric</title>
</head>
<body>
<h1> main!!</h1>


<div class="card text-center text-white bg-success mb-3" style="width: 30rem;">
    <img src='<%=request.getContextPath() %>/img/card16.jpeg'/>
    <%--    <img src="../../img/27178e1e4016a854ad194f90605ad6fe.jpg" class="card-img-top">--%>
    <div class="card-body">
        <h5 class="card-title"> Pediatric </h5>
        <p class="card-text" >
           Pediatric. pediatrics full of sympathy.</p>
        <a href="${pageContext.request.contextPath}/controller?command=go_to_price_command" class="card-link">price</a>
        <a href="${pageContext.request.contextPath}/controller?command=go_to_doctors_command"class="card-link">doctors</a>
    </div>
</div>



<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>