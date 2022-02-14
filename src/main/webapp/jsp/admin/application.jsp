<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="application.title" var="title"/>
<fmt:message key="application.message" var="message"/>
<fmt:message key="application.message1" var="message1"/>
<fmt:message key="application.message2" var="message2"/>
<html>
<header id="header">
    <%@include file="../header/header.jsp" %>
</header>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="../../img/png-transparent-graphy-logo-tree-leaf-branch-logo.png" type="image/x-icon">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/fontello.css">
    <title>${title}</title>
</head>
<body>

<div class="text-center">
<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_update_protocol_application_command">
    <label>${message}</label>
    <input type="text" name="protocol_id" >
    <label>${message1}</label>

    <input type="text" name="application" value="approved" required placeholder="approved" >
    <input type="submit" >
</form>
<br/>

<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_update_protocol_status_command">
    <label>${message}</label>
    <input type="text" name="protocol_id" >
    <label>${message2}</label>
       <input type="text" name="status" value="paid" required placeholder="paid" >
    <input type="submit" >
</form>
<br/>

</div>
<a href="#header" class="btn-lg btn-danger">UP</a>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
