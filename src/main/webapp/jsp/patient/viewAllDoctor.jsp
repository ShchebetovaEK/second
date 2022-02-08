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
<div class="text-center">
    <form action="${abs}/controller" method="get">
        <label class="form-label">view all doctor's </label>
        <input type="hidden" name="command" value="patient_view_all_doctor_command">
        <input type="submit"  >
    </form>

    <table class="table text-danger">
        <tr>
            <th scope="col">id</th>
            <th scope="col">role</th>
            <th scope="col">login</th>
            <th scope="col">first name</th>
            <th scope="col">last name</th>
            <th scope="col">address</th>
            <th scope="col">email</th>
            <th scope="col">phone number</th>
            <th scope="col">data birthday</th>
            <th scope="col">category</th>
            <th scope="col">experience</th>
            <th scope="col"> speciality</th>

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
    <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/patient/chooseDoctor.jsp"
       role="button">Back to choose doctor page</a>

</div>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>