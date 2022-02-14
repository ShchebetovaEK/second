<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="impossible.title" var="title"/>
<fmt:message key="impossible.message" var="message"/>
<fmt:message key="impossible.back" var="back"/>

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
    <div class="mb-3">
        <form method="POST" action="${abs}/controller">
            <h2 class="text-center text-black">
                ${message}</h2>
            <br/>
            <a class="btn btn-warning" href="${pageContext.request.contextPath}/jsp/main/account.jsp"
               role="button">${back}</a>
        </form>
    </div>
</div>



</div>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>