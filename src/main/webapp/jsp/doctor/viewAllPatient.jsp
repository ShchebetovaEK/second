<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="doctorviewpatient.title" var="title"/>
<fmt:message key="doctorviewpatient.message1" var="message1"/>
<fmt:message key="doctorviewpatient.back" var="back"/>
<fmt:message key="doctorviewpatient.id" var="id"/>
<fmt:message key="doctorviewpatient.role" var="role"/>
<fmt:message key="doctorviewpatient.firstName" var="firstName"/>
<fmt:message key="doctorviewpatient.lastName" var="lastName"/>
<fmt:message key="doctorviewpatient.address" var="address"/>
<fmt:message key="doctorviewpatient.email" var="email"/>
<fmt:message key="doctorviewpatient.phoneNumber" var="phoneNumber"/>
<fmt:message key="doctorviewpatient.dataBirthday" var="dataBirthday"/>
<fmt:message key="doctorviewpatient.archiv" var="archiv"/>
<fmt:message key="doctorviewpatient.insurance" var="insurance"/>
<fmt:message key="doctorviewpatient.moneyAccount" var="moneyAccount"/>
<fmt:message key="doctorviewpatient.discount" var="discount"/>
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
        <label class="form-label">${message1} </label>
        <input type="hidden" name="command" value="doctor_view_all_patient_command">
        <input type="submit">
    </form>

    <table class="table text-danger">
        <tr>
            <th scope="col">${id}</th>
            <th scope="col">${role}</th>
            <th scope="col">${firstName}</th>
            <th scope="col">${lastName}</th>
            <th scope="col">${address}</th>
            <th scope="col">${email}</th>
            <th scope="col">${phoneNumber}</th>
            <th scope="col">${dataBirthday}</th>
            <th scope="col">${archiv}</th>
            <th scope="col">${insurance}</th>
            <th scope="col">${moneyAccount}</th>
            <th scope="col">${discount}</th>

        </tr>

        <c:forEach items="${users}" var="user">

            <tr>
                <td>${user.id}</td>
                <td>${user.role}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.address}</td>
                <td>${user.email}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.dataBirthday}</td>

                <c:if test="${patient_req}">
                    <td> ${user.insurance}</td>
                    <td> ${user.moneyAccount}</td>
                    <td> ${user.discount}</td>
                </c:if>

            </tr>
        </c:forEach>

    </table>
    <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/doctor/doctor.jsp"
       role="button">${back}</a>
</div>
<a href="#header" class="btn-lg btn-danger">UP</a>
<footer>
    <div class="text-center"><ctg:footer/></div>
</footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>