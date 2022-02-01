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
    <input type="hidden" name="command" value="manager_page_command">
    <%--     <input type="text" name="id" >--%>
    <input type="submit">
</form>
<form action="${abs}/controller" method="get">
    doctor <input type="hidden" name="command" value="admin_take_all_doctors_command">
    <%--     <input type="text" name="id" >--%>
    <input type="submit" value="doctor">
</form>
<form action="${abs}/controller" method="get">
    doctor <input type="hidden" name="command" value="admin_take_doctors_by_category_command">
    <%--     <input type="text" name="id" >--%>
    please, input desired category: <input type="text" name="category" >
    <input type="submit" value="category">
</form>
<form action="${abs}/controller" method="get">
    doctor <input type="hidden" name="command" value="admin_take_doctors_by_experience_command">
    <%--     <input type="text" name="id" >--%>
    please, input desired category: <input type="text" name="experience" >
    <input type="submit" value="experience">
</form>
<form action="${abs}/controller" method="get">
    doctor <input type="hidden" name="command" value="admin_take_doctors_by_speciality_command">
    <%--     <input type="text" name="id" >--%>
    please, input desired category: <input type="text" name="speciality" >
    <input type="submit" value="speciality">
</form>






<form action="${abs}/controller" method="get">
    doctor <input type="hidden" name="command" value="admin_take_all_patients_command">
    <%--     <input type="text" name="id" >--%>
    <input type="submit" value="patient">
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
        <th>data</th>
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

            <c:if test="${patient}">
                <td> ${user.insurance}</td>
                <td> ${user.moneyAccount}</td>
                <td> ${user.discount}</td>
            </c:if>

        </tr>
    </c:forEach>

</table>


<a href="${pageContext.request.contextPath}/jsp/main/select.jsp">Back to select page</a>

<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
