<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="adminpage.title" var="title"/>
<fmt:message key="adminpage.message1" var="message1"/>
<fmt:message key="adminpage.message2" var="message2"/>
<fmt:message key="adminpage.message3" var="message3"/>
<fmt:message key="adminpage.message4" var="message4"/>
<fmt:message key="adminpage.message5" var="message5"/>
<fmt:message key="adminpage.message6" var="message6"/>
<fmt:message key="adminpage.message7" var="message7"/>
<fmt:message key="adminpage.message8" var="message8"/>
<fmt:message key="adminpage.message9" var="message9"/>
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

<br>
<div class="container">
    <form method="POST" action="${abs}/controller">
        <div class="row align-items-center">
            <div class="col">
              ${message1}
            </div>
            <div class="col">
                ${message2}
            </div>
            <div class="col">
            ${message3}
            </div>
            <div class="col">
               ${message4}
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col">
                <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/select.jsp"
                   role="button"> ${message5} </a>
            </div>
            <div class="col">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/jsp/admin/update.jsp"
                   role="button">${message5}</a>
            </div>
            <div class="col">
                <a class="btn btn-warning" href="${pageContext.request.contextPath}/jsp/main/registration.jsp"
                   role="button"> ${message5}</a>
            </div>
            <div class="col">
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/jsp/admin/delete.jsp"
                   role="button"> ${message5}</a>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col">
                <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/selectDoctor.jsp"
                   role="button">${message6} </a>
            </div>
            <div class="col">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/jsp/admin/updateDoctor.jsp"
                   role="button">${message6}</a>
            </div>
            <div class="col">
                <a class="btn btn-warning" href="${pageContext.request.contextPath}/jsp/admin/doctorRegistration.jsp"
                   role="button"> ${message6}</a>
            </div>
            <div class="col">
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/jsp/admin/delete.jsp"
                   role="button"> ${message6}</a>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col">
                <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/selectPatient.jsp"
                   role="button"> ${message7}</a>
            </div>
            <div class="col">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/jsp/admin/updatePatient.jsp"
                   role="button"> ${message7} </a>
            </div>
            <div class="col">
                <a class="btn btn-warning" href="${pageContext.request.contextPath}/jsp/admin/adminRegistration.jsp"
                   role="button">${message8}</a>
            </div>
            <div class="col">
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/jsp/admin/delete.jsp"
                   role="button"> ${message7}</a>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col">
                <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/protocol.jsp"
                   role="button"> ${message9} </a>
            </div>
            <div class="col">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/jsp/admin/updateProtocol.jsp"
                   role="button"> ${message9}  </a>
            </div>
            <div class="col">
                <a class="btn btn-warning" href="${pageContext.request.contextPath}/jsp/admin/protocolRegistration.jsp"
                   role="button"> ${message9}  </a>
            </div>
            <div class="col">
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/jsp/admin/delete.jsp"
                   role="button"> ${message8}</a>
            </div>
        </div>
    </form>


<%--    <a class="btn btn-danger" href="${pageContext.request.contextPath}/jsp/main/totalsumprotocol.jsp"--%>
<%--       role="button"> totalcost</a>--%>
</div>
<footer>
    <div class="text-center"><ctg:footer/></div>
</footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
