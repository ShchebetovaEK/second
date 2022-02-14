<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="logIn.title" var="title"/>
<fmt:message key="logIn.login" var="login"/>
<fmt:message key="logIn.password" var="password"/>

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
    <title>${title}</title>
</head>
<body>
<div class="text-center">
    <form method="POST" action="${abs}/controller">
        <br/>
        <input type="hidden" name="command" value="log_in_command">
        <label class="form-label"> ${login} </label>
        <input name="login" required pattern="(\w)[\w_-]{1,18}(\w)">
        <br/>
        <label class="form-label"> ${password} </label>
        <input name="password" type="password" required pattern="(.{4,40})">
        <br/>
        <p><input type="submit"></p>
    </form>

</div>

<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
