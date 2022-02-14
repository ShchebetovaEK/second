<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="doctorviewprotocol.title" var="title"/>
<fmt:message key="doctorviewprotocol.back" var="back"/>
<fmt:message key="doctorviewprotocol.protocolId" var="protocolId"/>
<fmt:message key="doctorviewprotocol.protocolData" var="protocolData"/>
<fmt:message key="doctorviewprotocol.protocolPayer" var="protocolPayer"/>
<fmt:message key="doctorviewprotocol.protocolCost" var="protocolCost"/>
<fmt:message key="doctorviewprotocol.patientId" var="patientId"/>
<fmt:message key="doctorviewprotocol.doctorId" var="doctorId"/>
<fmt:message key="doctorviewprotocol.status" var="status"/>
<fmt:message key="doctorviewprotocol.application" var="application"/>
<html>
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
<div class="text-center">
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="doctor_view_protocol_command">
        <input type="submit">
    </form>
    <br/>

    <table class="table text-info">
        <tr>
            <th scope="col">${protocolId}</th>
            <th scope="col">${protocolData}</th>
            <th scope="col">${protocolPayer}</th>
            <th scope="col">${protocolCost} </th>
            <th scope="col">${patientId} </th>
            <th scope="col">${doctorId}</th>
            <th scope="col">${status}</th>
            <th scope="col">${application}</th>

        </tr>

        <c:forEach items="${protocols}" var="protocol">
            <tr>
                <td>${protocol.protocolId}</td>
                <td>${protocol.protocolData}</td>
                <td>${protocol.protocolPayer}</td>
                <td>${protocol.protocolCost}</td>
                <td>${protocol.patientsUsersId}</td>
                <td>${protocol.doctorsUsersId}</td>
                <td>${protocol.status}</td>
                <td>${protocol.application}</td>

            </tr>
        </c:forEach>

    </table>
</div>
<a href="#header" class="btn-lg btn-danger">UP</a>
<a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/doctor/doctor.jsp"
   role="button">${back}</a>
<footer>
    <div class="text-center"><ctg:footer/></div>
</footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
