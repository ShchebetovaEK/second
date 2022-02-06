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
    <link rel="shortcut icon" href="../../img/png-transparent-graphy-logo-tree-leaf-branch-logo.png"
          type="image/x-icon">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/fontello.css">
    <title>Manager Page</title>
</head>
<body>
<div class="text-center">
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_doctor_category_command">.
        <label class="form-label"> please, input doctor's id:</label>
        <input type="text" name="users_id">
        <label class="form-label">please, input desired category::</label>
        <input type="text" name="category">
        <input type="submit">
    </form>
    <br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_doctor_experience_command">
        <label class="form-label"> please, input doctor's id:</label>
        <input type="text" name="users_id">
        <label class="form-label">please, input desired experience:</label>
        <input type="text" name="experience">
        <input type="submit">
    </form>
    <br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_doctor_speciality_command">
        <label class="form-label"> please, input doctor's id:</label>
        <input type="text" name="users_id">
        <label class="form-label"> please, input desired speciality:</label>
        <input type="text" name="speciality">
        <input type="submit">
    </form>
</div>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
