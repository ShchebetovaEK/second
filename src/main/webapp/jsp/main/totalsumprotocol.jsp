<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="totalsumprotocol.title" var="title"/>
<fmt:message key="totalsumprotocol.message" var="message"/>
<fmt:message key="totalsumprotocol.protocolId" var="protocolId"/>
<fmt:message key="totalsumprotocol.protocolData" var="protocolData"/>
<fmt:message key="totalsumprotocol.protocolPayer" var="protocolPayer"/>
<fmt:message key="totalsumprotocol.protocolCost" var="protocolCost"/>
<fmt:message key="totalsumprotocol.patientId" var="patientId"/>
<fmt:message key="totalsumprotocol.doctorId" var="doctorId"/>
<fmt:message key="totalsumprotocol.status" var="status"/>
<fmt:message key="totalsumprotocol.application" var="application"/>
<html>
<header>
    <%@include file="../header/header.jsp" %>
</header>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="../../img/png-transparent-graphy-logo-tree-leaf-branch-logo.png" type="image/x-icon">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/fontello.css">
    <title>${title}</title>
</head>
<body>


<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_protocol_cost_command">
   <label>${message} </label>
    <input type="text" name="forestmed.capabilities.protocols_protocol_id" >
    <input type="submit" >
</form>

<table class="table text-info">
    <tr>
        <th scope="col">${protocolId}</th>
        <th scope="col">${protocolData}</th>
        <th scope="col">${protocolPayer}</th>
        <th scope="col"> ${protocolCost}</th>
        <th scope="col"> ${patientId}</th>
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
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
