<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<header>
    <%@include file="../header/header.jsp" %>
</header>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="img/png-transparent-graphy-logo-tree-leaf-branch-logo.png" type="image/x-icon">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fontello.css">
    <title>Title</title>
</head>
<body>
<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="authentication_command">
    <input type="text" name="login" >
    <input type="password" name="password" >
    <input type="submit" >
</form>

<c:choose>
    <c:when test="${authentication_result eq 'false'}"><div class="alert alert-warning" id="message"><b class="invalid_message">${invalid_message}</b></div></c:when>
    <c:when test="${authentication_result eq 'true'}"><div class="alert alert-success" id="message"><b class="valid_message">${valid_message} ${user.login}</b></div></c:when>
</c:choose>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
