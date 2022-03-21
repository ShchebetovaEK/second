<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="search.title" var="title"/>
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
<br/>
<div class="text-center">
    <div class="mb-3">


<table class="table text-success table-hover">
<tr>
    <th scope="col">id</th>
    <th scope="col">role</th>
    <th scope="col">first name</th>
    <th scope="col">last name</th>
    <th scope="col">speciality</th>
    <th scope="col">category</th>

</tr>

<c:forEach items="${users}" var="user">

    <tr>
    <td>${user.id}</td>
    <td>${user.role}</td>
    <td>${user.firstName}</td>
    <td>${user.lastName}</td>
        <td>${user.speciality}</td>
        <td>${user.category}</td>


    </tr>
</c:forEach>

</table>
    </div>
</div>
<a href="#header" class="btn-lg btn-danger">UP</a>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
    </body>
</html>
