<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Manager Page</title>
</head>
<body>



<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_update_protocol_application_command">
    please, input  id: <input type="text" name="protocol_id" >
    please, change application: <input type="text" name="application" value="approved" placeholder="approved" >
    <input type="submit" >
</form>
<br/>

<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_update_protocol_status_command">
    please, input  id: <input type="text" name="protocol_id" >
    please, change status: <input type="text" name="status" value="paid" placeholder="paid" >
    <input type="submit" >
</form>
<br/>


<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
