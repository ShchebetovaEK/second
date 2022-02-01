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
<form method="POST" action="${abs}/controller">
<input type="hidden" name="command" value="log_in_command">
Login
<input name="login" >
<br/>
Password
<input name="password" type="password" >
<br/>
<p><input type="submit"></p>
</form>
<a href="${pageContext.request.contextPath}/jsp/main/registration.jsp"></a>


</body>
</html>
