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
    <title>${title}</title>
</head>
<body>


<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_delete_patient_command">
    please, input  id patient: <input type="text" name="users_id" placeholder="id" >

    <input type="submit" name="delete" >
</form>
<br/>
<form action="${abs}/controller" method="get">
  archiv  <input type="hidden" name="command" value="admin_archiv_patient_command">
    please, input  id patient: <input type="text" name="users_id" placeholder="id" >

    <input type="submit" >
</form>

<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_delete_doctor_command">
    please, input  id doctor: <input type="text" name="users_id" placeholder="id" >

    <input type="submit" name="delete" >
</form>


<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_archiv_user_command">
    please, input  id user: <input type="text" name="users_id" placeholder="id" >

    <input type="submit" name="delete" >
</form>

<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_delete_admin_command">
    please, input  id doctor: <input type="text" name="users_id" placeholder="id" >

    <input type="submit" name="delete" >
</form>
<%--<footer> <%@include file="../footer/footer.jsp" %></footer>--%>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>