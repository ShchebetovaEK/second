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
        <input type="hidden" name="command" value="update_user_first_name_command">
        <label class="form-label"> please, input user's id:</label>
        <input type="text" name="id">
        <label class="form-label"> please, input desired first name::</label>
        <input type="text" name="first_name">
        <input type="submit">
    </form>
    <br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_user_last_name_command">
        <label class="form-label"> please, input user's id:</label>
        <input type="text" name="id">
        <label class="form-label">please, input desired user's Last Name:</label>
        <input type="text" name="last_name">
        <input type="submit">
    </form>
    <br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_user_address_command">
        <label class="form-label"> please, input user's id:</label>
        <input type="text" name="id">
        <label class="form-label">please, input desired address:</label>
        <input type="text" name="address">
        <input type="submit">
    </form>
    <br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_user_phone_number_command">
        <label class="form-label"> please, input user's id:</label>
        <input type="text" name="id">
        <label class="form-label">please, input desired phone number:</label>
        <input type="text" name="phone_number">
        <input type="submit">
    </form>
    <br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_user_email_command">
        <label class="form-label"> please, input user's id:</label>
        <input type="text" name="id">
        <label class="form-label"> please, input desired email:</label>
        <input type="text" name="email">
        <input type="submit">
    </form>
</div>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
