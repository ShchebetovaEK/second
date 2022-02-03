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
    <title>Manager Page</title>
</head>
<body>


<%-- <form action="${abs}/controller" method="get">--%>
<%--     <input type="hidden" name="command" value="manager_page_command">--%>
<%--     <input type="submit" >--%>
<%-- </form>--%>

<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_all_protocols_command">
    <input type="submit">
    <br/>
</form>
<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_protocol_by_doctor_command">
         <input type="text" name="id" placeholder="doctor id">
    <input type="submit">
</form>
<br/>
<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_protocol_by_patient_command">
         <input type="text" name="id" placeholder="patient id" >
    <input type="submit">
</form>

<table>
    <tr>
        <th>protocolId</th>
        <th>protocolData</th>
        <th>protocolPayer</th>
        <th> protocolCost</th>
        <th> patientId</th>
        <th>doctorId</th>

    </tr>

    <c:forEach items="${protocols}" var="protocol">
        <tr>
            <td>${protocol.protocolId}</td>
            <td>${protocol.protocolData}</td>
            <td>${protocol.protocolPayer}</td>
            <td>${protocol.protocolCost}</td>
            <td>${protocol.patientId}</td>
            <td>${protocol.doctorId}</td>

        </tr>
    </c:forEach>

</table>


<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
