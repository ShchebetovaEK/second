<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="delete.title" var="title"/>
<fmt:message key="delete.message1" var="message1"/>
<fmt:message key="delete.message2" var="message2"/>
<fmt:message key="delete.message3" var="message3"/>
<fmt:message key="delete.message4" var="message4"/>
<fmt:message key="delete.message5" var="message5"/>

<html>
<header id="header">
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
    <title>${title}</title>
</head>
<body>

<div class="text-center">
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="admin_archiv_user_command">
        <label class="form-label"> ${message3} </label>
        <input type="text" name="users_id" required placeholder="id">
        <input type="submit" name="delete">
    </form>

    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="admin_delete_admin_command">
        <label class="form-label"> ${message5} </label>
        <input type="text" name="users_id" required placeholder="id">
        <input type="submit" name="delete">
    </form>
</div>

<a href="#header" class="btn-lg btn-danger">UP</a>

<footer>
    <div class="text-center"><ctg:footer/></div>
</footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>