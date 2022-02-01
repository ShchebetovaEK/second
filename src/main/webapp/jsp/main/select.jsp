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
    <link rel="shortcut icon" href="../../img/png-transparent-graphy-logo-tree-leaf-branch-logo.png" type="image/x-icon">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/fontello.css">
    <title>Manager Page</title>
</head>
<body>


 <form action="${abs}/controller" method="get">
     <input type="hidden" name="command" value="manager_page_command">
  click to view all users   <input type="submit" >
 </form>


<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_user_by_login_command">
    please, input desired Login: <input type="text" name="login" >
    <input type="submit" >
</form>

<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_user_by_first_name_command">
    please, input desired First Name: <input type="text" name="first_name" >
    <input type="submit" >
</form>


<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_user_by_last_name_command">
    please, input desired Last Name: <input type="text" name="last_name" >
    <input type="submit" >
</form>

<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_user_by_id_command">
    please, input desired id: <input type="text" name="id" value="id">
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
        <th>phone number </th>


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
