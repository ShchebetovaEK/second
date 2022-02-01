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
    <link rel="shortcut icon" href="../../img/png-transparent-graphy-logo-tree-leaf-branch-logo.png"
          type="image/x-icon">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/fontello.css">
    <title>Main</title>
</head>
<body>
<div class="text-center text-success">
    our destinations
</div>
<div class="card-group">
    <div class="card text-body  bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card3.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">THERAPY</h5>
            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional
                content. This content is a little bit longer.</p>
            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
        </div>
    </div>
    <div class="card bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card9.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">PEDIATRICS</h5>
            <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
            <a href="${pageContext.request.contextPath}/controller?command=go_to_pediatric_command"  class="btn btn-outline-primary" tabindex="-1" role="button" aria-disabled="true">GO TO</a>
        </div>
    </div>
    <div class="card bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card13.jpeg' class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title"> SURGERY </h5>
            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional
                content. This card has even longer content than the first to show that equal height action.</p>
            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
        </div>
    </div>
</div>


<div class="card-group">
    <div class="card text-body  bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card7.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title"> INJECTION</h5>
            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional
                content. This content is a little bit longer.</p>
            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
        </div>
    </div>
    <div class="card bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card17.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">VACCINATION</h5>
            <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
        </div>
    </div>
    <div class="card bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card22.jpeg' class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title"> LABORATORY </h5>
            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional
                content. This card has even longer content than the first to show that equal height action.</p>
            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
        </div>
    </div>
</div>

<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>