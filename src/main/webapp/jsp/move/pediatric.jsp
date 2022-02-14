<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="pediatric.title" var="title"/>
<fmt:message key="pediatric.message1" var="message1"/>
<fmt:message key="pediatric.message2" var="message2"/>
<fmt:message key="pediatric.price" var="price"/>
<fmt:message key="pediatric.doctors" var="doctors"/>

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
    <title>${title}</title>
</head>
<body>
<div class="card text-center text-white bg-success mb-3" style="width: 30rem;">
    <img src='<%=request.getContextPath() %>/img/card16.jpeg'/>
    <div class="card-body">
        <h5 class="card-title"> ${message1} </h5>
        <p class="card-text" > ${message2}</p>
        <a href="${pageContext.request.contextPath}/controller?command=go_to_price_command" class="card-link">${price}</a>
        <a href="${pageContext.request.contextPath}/controller?command=go_to_doctors_command"class="card-link">${doctors}</a>
    </div>
</div>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>