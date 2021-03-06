<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="doctor.title" var="ttile"/>
<fmt:message key="doctor.message1" var="message1"/>
<fmt:message key="doctor.message2" var="message2"/>
<html>
<header id="header">
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

<br>
<div class="flex-column text-center">
    <div class="md-3">
        <form method="POST" action="${abs}/controller">

            <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/doctor/viewAllPatient.jsp"
               role="button">${message1}</a>

        <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/doctor/viewProtocol.jsp"
           role="button">${message2}l</a>
        </form>
    </div>
</div>
<a href="#header" class="btn-lg btn-danger">UP</a>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
