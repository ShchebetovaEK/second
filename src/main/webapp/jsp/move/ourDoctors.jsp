<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<html>
<header>
    <%@include file="../header/header.jsp" %>
</header>
<head>
    <title>${title}</title>
</head>
<body>
<h2 class="text-center text-primary">we have best doctors at the world!</h2>
<div class="card-group">
    <div class="card text-body  bg-info mb-3">
        <img src='<%=request.getContextPath() %>/img/card21.jpeg' class="card-img-top" alt="...">

        <div class="card-body">

            <p class="card-text">
                new approaches to covid-19 therapy </p>
        </div>
    </div>
    <div class="card text-body  bg-info mb-3">
        <img src='<%=request.getContextPath() %>/img/card14.jpeg' class="card-img-top" alt="...">

        <div class="card-body">
            <p class="card-text"> blood pressure calculation </p>
        </div>
    </div>
    <div class="card text-body  bg-info mb-3">
        <img src='<%=request.getContextPath() %>/img/card10.jpeg' class="card-img-top" alt="...">
        <div class="card-body">

            <p class="card-text"> issues of CT diagnostics of the lungs.</p>
        </div>
    </div>
</div>

<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>

