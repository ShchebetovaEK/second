<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="patientviewprotocol.title" var="title"/>
<fmt:message key="patientviewprotocol.back" var="back"/>
<fmt:message key="patientviewprotocol.protocolId" var="protocolId"/>
<fmt:message key="patientviewprotocol.protocolData" var="protocolData"/>
<fmt:message key="patientviewprotocol.protocolPayer" var="protocolPayer"/>
<fmt:message key="patientviewprotocol.protocolCost" var="protocolCost"/>
<fmt:message key="patientviewprotocol.patientId" var="patientId"/>
<fmt:message key="patientviewprotocol.doctorId" var="doctorId"/>
<fmt:message key="patientviewprotocol.status" var="status"/>
<fmt:message key="patientviewprotocol.application" var="application"/>

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
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="patient_view_my_protocol_command">
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
        </c:forEach>

    </table>
</div>
<a class="btn btn-success text-center" href="${pageContext.request.contextPath}/jsp/patient/chooseDoctor.jsp"
   role="button">${back}</a>
<footer>
    <div class="text-center"><ctg:footer/></div>
</footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
