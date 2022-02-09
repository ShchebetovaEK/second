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
<div class="text-center">

<br/>
<form action="${abs}/controller" method="get">
    view all users    <input type="hidden" name="command" value="manager_page_command">
    <input type="submit" name="user">
</form>
<br/>

<form action="${abs}/controller" method="get"> <label class="form-label">view all patients</label>
    <input type="hidden" name="command" value="admin_take_all_patients_command">
      <input type="submit">
</form>
<br/>

<form action="${abs}/controller" method="get"> <label class="form-label">view all doctors </label>
    <input type="hidden" name="command" value="admin_take_all_doctors_command">
    <input type="submit" >
</form>
<br/>

<table class="table text-success table-hover">
    <tr>
        <th scope="col">id</th>
        <th scope="col">role</th>
        <th scope="col">login</th>
        <th scope="col">first name</th>
        <th scope="col">last name</th>
        <th scope="col">address</th>
        <th scope="col">email</th>
        <th scope="col">phone number</th>
        <th scope="col">data</th>
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

<%--            <c:if test="${doctor}">--%>
<%--                <td> ${user.category}</td>--%>
<%--                <td> ${user.experience}</td>--%>
<%--                <td> ${user.speciality}</td>--%>
<%--            </c:if>--%>

<%--            <c:if test="${patient}">--%>
<%--                <td> ${user.insurance}</td>--%>
<%--                <td> ${user.moneyAccount}</td>--%>
<%--                <td> ${user.discount}</td>--%>
<%--            </c:if>--%>

        </tr>
    </c:forEach>

</table>
<a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/main/user_manager.jsp"
   role="button">Back to manager</a>
<a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/select.jsp"
   role="button">Back to select page</a>
<a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/selectDoctor.jsp"
   role="button">Back to select doctor page</a>
<a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/selectPatient.jsp"
   role="button">Back to select patient page</a>
</div>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
