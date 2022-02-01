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
<table>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th> </th>
        <th> </th>
        <th></th>
        <th></th>
        <th> </th>
    </tr>

    <c:forEach items="${protocols}" var="protocol">
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


<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
