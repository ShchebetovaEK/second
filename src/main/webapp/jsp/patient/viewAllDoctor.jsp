<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="patientviewdoc.title" var="title"/>
<fmt:message key="patientviewdoc.message" var="message"/>
<fmt:message key="patientviewdoc.back" var="back"/>
<fmt:message key="patientviewdoc.id" var="id"/>
<fmt:message key="patientviewdoc.firstName" var="firstName"/>
<fmt:message key="patientviewdoc.lastName" var="lastName"/>
<fmt:message key="patientviewdoc.category" var="icategoryd"/>
<fmt:message key="patientviewdoc.speciality" var="speciality"/>
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
        <label class="form-label">${message} </label>
        <input type="hidden" name="command" value="patient_view_all_doctor_command">
        <input type="submit">
    </form>

    <table class="table text-danger">
        <tr>
            <th scope="col">${id}</th>
            <th scope="col">${firstName}</th>
            <th scope="col">${lastName} </th>
            <th scope="col">${category}</th>
            <th scope="col">${speciality} </th>

        </tr>

        <c:forEach items="${users}" var="user">

            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>

                <c:if test="${doctor_req}">
                    <td> ${user.category}</td>
                    <td> ${user.speciality}</td>
                </c:if>

            </tr>
        </c:forEach>

    </table>
    <a class="btn btn-success text-center" href="${pageContext.request.contextPath}/jsp/patient/chooseDoctor.jsp"
       role="button">${back}</a>

</div>
<footer>
    <div class="text-center"><ctg:footer/></div>
</footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>