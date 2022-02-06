<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
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
    <title>Main</title>
</head>
<body>
<br/>
<div class="text-center">
    <div class="mb-3">
        <form method="POST" action="${abs}/controller">
            <h2 class="text-center"> Hello , User! Please, LogIn or registrate!</h2>
            <br/>
            <input type="hidden" name="command" value="log_in_command">
            <label class="form-label"> Login</label>
            <input type="text" name="login" placeholder="login">
            <br/>
            <label class="form-label"> Password </label>
            <input name="password" type="password" placeholder="password">
            <br/>
            <p><input type="submit"></p>
            <br/>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/jsp/main/registration.jsp"
               role="button">Registration</a>
        </form>
    </div>
</div>
</body>
</html>
