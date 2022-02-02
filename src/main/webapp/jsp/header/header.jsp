<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../../imports.jspf" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="img/png-transparent-graphy-logo-tree-leaf-branch-logo.png" type="image/x-icon">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fontello.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=go_to_main">Main</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/controller?command=go_to_about_page_command">About  us</a>
            </li>
            <li class="nav-item">
                <a class="nav-link "
                   href="${pageContext.request.contextPath}/controller?command=go_to_doctors_command"> Our  Doctors</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/controller?command=go_to_price_command">Price</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/controller?command=go_to_welcome">Welcome</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/controller?command=go_to_registration_page">Registration</a>
            </li>
            <li class="nav-item">
            <a class="nav-link"
               href="${pageContext.request.contextPath}/controller?command=log_in_command">LogIn</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/controller?command=log_out_command">LogOut</a>
            </li>
            <form class="d-flex">
                <input class="form-control mr-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </ul>
    </div>
</nav>
<img src='<%=request.getContextPath() %>/img/forest.jpeg'/>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
