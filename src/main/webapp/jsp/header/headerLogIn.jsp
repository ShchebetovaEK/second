<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="header.english" var="en"/>
<fmt:message key="header.russian" var="ru"/>

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
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/controller?command=change_locale&locale=en_US">${en}</a>

            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/controller?command=change_locale&locale=ru_RU">${ru}</a>
            </li>
            <p>Today <%= new java.util.Date() %>
        </ul>

    </div>
</nav>
<img src='<%=request.getContextPath() %>/img/forest.jpeg'/>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
