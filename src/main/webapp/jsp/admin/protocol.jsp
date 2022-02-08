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
    <title>${title}</title>
</head>
<body>


<%-- <form action="${abs}/controller" method="get">--%>
<%--     <input type="hidden" name="command" value="manager_page_command">--%>
<%--     <input type="submit" >--%>
<%-- </form>--%>
<div class="text-center">
<form action="${abs}/controller" method="get">
    <label class="form-label"> view all protocol</label>
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
<br/>
<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_protocol_by_payer_command">
    <input type="text" name="protocol_payer" placeholder="payer" >
    <input type="submit">
</form>
<br/>
<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_protocol_by_data_command">
    <input type="date" name="protocol_data" placeholder="YYYY-MM-DD" >
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
        <th>insurance</th>
        <th>moneyAccount</th>
        <th>discount</th>
        <th>category</th>
        <th>experience</th>
        <th>speciality</th>


    </tr>

    <c:forEach items="${protocols}" var="protocol">
        <tr>
            <td>${protocol.protocolId}</td>
            <td>${protocol.protocolData}</td>
            <td>${protocol.protocolPayer}</td>
            <td>${protocol.protocolCost}</td>
            <td>${protocol.patientsUsersId}</td>
            <td>${protocol.doctorsUsersId}</td>

<%--            <c:if test="${patient}">--%>
<%--                <td> ${user.insurance}</td>--%>
<%--                <td> ${user.moneyAccount}</td>--%>
<%--                <td> ${user.discount}</td>--%>
<%--            </c:if>--%>
<%----%>
<%--            <c:if test="${doctor}">--%>
<%--                <td> ${user.category}</td>--%>
<%--                <td> ${user.experience}</td>--%>
<%--                <td> ${user.speciality}</td>--%>
<%--            </c:if>--%>
        </tr>
    </c:forEach>

</table>

</div>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
