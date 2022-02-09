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
    <title>admin Page</title>
</head>
<body>

<br>
<div class="container">
    <form method="POST" action="${abs}/controller">
    <div class="row align-items-center">
        <div class="col" >
         SELECT
        </div>
        <div class="col">
          UPDATE
        </div>
        <div class="col">
           REGISTRATION
        </div>
    </div>
        <div class="row align-items-center">
            <div class="col">
                <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/select.jsp"
                   role="button"> USER's </a>
            </div>
            <div class="col">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/jsp/admin/update.jsp"
                   role="button">User's</a>
            </div>
            <div class="col">
                <a class="btn btn-warning" href="${pageContext.request.contextPath}/jsp/main/registration.jsp"
                   role="button"> User's</a>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col">
                <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/selectDoctor.jsp"
                   role="button">Doctor's </a>
            </div>
            <div class="col">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/jsp/admin/updateDoctor.jsp"
                   role="button">Doctor's</a>
            </div>
            <div class="col">
                <a class="btn btn-warning" href="${pageContext.request.contextPath}/jsp/admin/doctorRegistration.jsp"
                   role="button"> Doctor's</a>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col" >
                <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/selectPatient.jsp"
                   role="button"> Patient </a>
            </div>
            <div class="col">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/jsp/admin/updatePatient.jsp"
                   role="button"> Patient </a>
            </div>
            <div class="col">
                <a class="btn btn-warning" href="${pageContext.request.contextPath}/jsp/admin/adminRegistration.jsp"
                   role="button">Admin's</a>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col" >
                <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/protocol.jsp"
                   role="button"> Protocol </a>
            </div>
            <div class="col">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/jsp/admin/updateProtocol.jsp"
                   role="button"> Protocol </a>
            </div>
            <div class="col">
                <a class="btn btn-warning" href="${pageContext.request.contextPath}/jsp/admin/protocolRegistration.jsp"
                   role="button"> Protocol </a>
            </div>
        </div>
    </form>

</div>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
