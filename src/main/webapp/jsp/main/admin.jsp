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
    <title>admin Page</title>
</head>
<body>

 <br>
<div class="flex-column text-center">
    <div class="md-3">
        <form method="POST" action="${abs}/controller">

            <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/main/select.jsp"
               role="button">Select</a>
            <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/main/update.jsp"
               role="button">Update</a>
            <a class="btn btn-danger" href="${pageContext.request.contextPath}/jsp/main/delete.jsp"
               role="button">Delete</a>
            <a class="btn btn-info" href="${pageContext.request.contextPath}/jsp/main/adminRegistration.jsp"
               role="button">Registration Admin</a>
            <a class="btn btn-info" href="${pageContext.request.contextPath}/jsp/main/doctorRegistration.jsp"
               role="button">Registration Doctor</a>
            <a class="btn btn-info" href="${pageContext.request.contextPath}/jsp/main/protocolRegistration.jsp"
               role="button">Registration Protocol</a>
        </form>
    </div>
</div>


<%--<form action="${abs}/controller" method="get">--%>
<%--    <input type="hidden" name="command" value="admin_take_all_doctors_command">--%>
<%--    <input type="submit" >--%>
<%--</form>--%>
<%----%>
<%--<table>--%>
<%--    <tr>--%>
<%--        <th>id</th>--%>
<%--        <th>role</th>--%>
<%--        <th>login</th>--%>
<%--        <th>first name</th>--%>
<%--        <th>last name</th>--%>
<%--        <th>address</th>--%>
<%--        <th>email</th>--%>
<%--        <th>phone number </th>--%>
<%--        <th> category</th>--%>
<%--        <th> experience</th>--%>
<%--        <th> speciality</th>--%>
<%----%>
<%----%>
<%--    </tr>--%>
<%----%>
<%--    <c:forEach items="${doctors}" var="doctor">--%>
<%--        <tr>--%>
<%--            <td>${doctor.id}</td>--%>
<%--            <td>${doctor.role}</td>--%>
<%--            <td>${doctor.login}</td>--%>
<%--            <td>${doctor.firstName}</td>--%>
<%--            <td>${doctor.lastName}</td>--%>
<%--            <td>${doctor.address}</td>--%>
<%--            <td>${doctor.email}</td>--%>
<%--            <td>${doctor.phoneNumber}</td>--%>
<%--            <td>${doctor.category}</td>--%>
<%--            <td>${doctor.experience}</td>--%>
<%--            <td>${doctor.speciality}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%----%>
<%--</table>--%>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
