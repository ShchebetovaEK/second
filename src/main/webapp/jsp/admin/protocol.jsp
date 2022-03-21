<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="protocol.title" var="title"/>
<fmt:message key="protocol.protocolId" var="protocolId"/>
<fmt:message key="protocol.protocolData" var="protocolData"/>
<fmt:message key="protocol.protocolCost" var="protocolCost"/>
<fmt:message key="protocol.protocolPayer" var="protocolPayer"/>
<fmt:message key="protocol.patientId" var="patientId"/>
<fmt:message key="protocol.doctorId" var="doctorId"/>
<fmt:message key="protocol.status" var="status"/>
<fmt:message key="protocol.application" var="application"/>
<fmt:message key="protocol.message1" var="message_1"/>
<fmt:message key="protocol.message2" var="message_2"/>
<fmt:message key="protocol.message3" var="message_3"/>
<fmt:message key="protocol.message4" var="message_4"/>
<fmt:message key="protocol.message5" var="message_5"/>
<fmt:message key="protocol.message6" var="message_6"/>
<fmt:message key="protocol.message7" var="message_7"/>
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
    <label class="form-label"> ${message_1}</label>
    <input type="hidden" name="command" value="admin_take_all_protocols_command">
    <input type="submit">
    <br/>
</form>
<form action="${abs}/controller" method="get">

    <input type="hidden" name="command" value="admin_take_protocol_by_doctor_command">
    <label class="form-label"> ${message_2}</label>
         <input type="text" name="id" placeholder="doctor id"  required pattern="[0-9]{1,10}">
    <input type="submit">
</form>
<br/>
<form action="${abs}/controller" method="get">
    <label class="form-label"> ${message_3}</label>
    <input type="hidden" name="command" value="admin_take_protocol_by_patient_command">
         <input type="text" name="id" required placeholder="patient id" pattern="[0-9]{1,10}">
    <input type="submit">
</form>
<br/>
<form action="${abs}/controller" method="get">
    <label class="form-label"> ${message_4}</label>
    <input type="hidden" name="command" value="admin_take_protocol_by_payer_command">
    <input type="text" name="protocol_payer" required placeholder="payer" pattern="(?i)(insurance)|(patient)">
    <input type="submit">
</form>
<br/>
<form action="${abs}/controller" method="get">
    <label class="form-label"> ${message_5}</label>
    <input type="hidden" name="command" value="admin_take_protocol_by_data_command">
    <input type="text" name="protocol_data"  required placeholder="YYYY-MM-DD" pattern="\d{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])">
    <input type="submit">
</form>
<br/>
    <form action="${abs}/controller" method="get">
        <label class="form-label"> ${message_6}</label>
        <input type="hidden" name="command" value="admin_take_protocol_by_status_command">
        <input type="text" name="status" required  value="duty" pattern="(?i)(duty)|(paid)" >
        <input type="submit">
    </form>
<br/>
    <form action="${abs}/controller" method="get">
        <label class="form-label"> ${message_7}</label>
        <input type="hidden" name="command" value="admin_take_protocol_by_application_command">
        <input type="text" name="application"  value="active"  pattern="(?i)(active)|(approved)" >
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
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
