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
    <title>Select Doctor</title>
</head>
<body>

<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_all_doctors_command">
    <input type="submit"  name="doctor">
</form>

<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_doctors_by_category_command">
    please, input desired category: <input type="text" name="category" value="HIGH" >
    <input type="submit" >
</form>

<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_doctors_by_experience_command">
    please, input desired experience: <input type="text" name="experience" value="FIVE_YEARS">
    <input type="submit" >
</form>

<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_doctors_by_speciality_command">
    please, input desired speciality: <input type="text" name="speciality" value="UROLOGY">
    <input type="submit" >
</form>
<table>
    <tr>
        <th>id</th>
        <th>role</th>
        <th>login</th>
        <th>first name</th>
        <th>last name</th>
        <th>address</th>
        <th>email</th>
        <th>phone number</th>
        <th>data birthday</th>
        <th>category</th>
        <th>experience</th>
        <th>speciality</th>

    </tr>

    <c:forEach items="${users}" var="user">

        <tr>
            <td>${user.id}</td>
            <td>${user.role}</td>
            <td>${user.login}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.address}</td>
            <td>${user.email}</td>
            <td>${user.phoneNumber}</td>
            <td>${user.dataBirthday}</td>

            <c:if test="${doctor}">
                <td> ${user.category}</td>
                <td> ${user.experience}</td>
                <td> ${user.speciality}</td>
            </c:if>

        </tr>
    </c:forEach>

</table>

<a href="${pageContext.request.contextPath}/jsp/main/user_manager.jsp">Back to manager</a>
<a href="${pageContext.request.contextPath}/jsp/main/select.jsp">Back to select page</a>
<a href="${pageContext.request.contextPath}/jsp/main/selectDoctor.jsp">Back to select doctor page</a>
<a href="${pageContext.request.contextPath}/jsp/main/selectPatient.jsp">Back to select patient page</a>

<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>