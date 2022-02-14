<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="sign.title" var="title"/>
<fmt:message key="sign.login" var="login"/>
<fmt:message key="sign.password" var="password"/>
<fmt:message key="sign.registration" var="registration"/>
<fmt:message key="sign.greeting" var="greeting"/>

<html>
<header>
    <%@include file="../header/headerLogIn.jsp" %>
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

<br/>
<div class="text-center">
    <div class="text-center ">
        <form method="POST" action="${abs}/controller">
            <h2 class="text-center"> ${greeting}</h2>
            <br/>
            <input type="hidden" name="command" value="log_in_command">
            <div class="row align-items-center">
                <div class="col">
                    <label class="form-label"> ${login} </label>
                    <input type="text" name="login" placeholder="login" required pattern="(\w)[\w_-]{1,18}(\w)">
                </div>
                <div class="col">
                    <label class="form-label"> ${password} </label>
                    <input name="password" type="password" placeholder="password" required pattern="(.{4,40})">
                    <br/>
                </div>
                <div class="col">
                    <p><input type="submit"></p>
                </div>
                <br/>
            </div>
            <br/>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/jsp/main/registration.jsp"
               role="button">${registration}</a>
        </form>
    </div>
</div>
<footer>
    <div class="text-center"><ctg:footer/></div>
</footer>
</body>
</html>
