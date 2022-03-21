<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="account.title" var="title"/>
<fmt:message key="account.logine" var="logine"/>
<fmt:message key="account.password" var="password"/>
<fmt:message key="account.confirmpassword" var="confirmpassword"/>
<fmt:message key="account.newpassword" var="newpassword"/>
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
        <title> change password</title>

</head>
<body>

</br>
<div class="text-center text-info">
<form method="POST" action="${abs}/controller">
    <div class="row-cols-3">
        <input type="hidden" name="command" value="change_password_command">

        <label class="form-label"> ${password} </label>
        <input type="password" name="password"  required>

        <label class="form-label"> ${newpassword} </label>
        <input type="password" name="new_password"  required>

        <label class="form-label"> ${confirmpassword} </label>
        <input type="password" name="confirm_password"  required>

        <input type="submit" value="submit"><br/>
    </div>
</form>
</div>
<footer>
    <div class="text-center"><ctg:footer/></div>
</footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
