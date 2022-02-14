<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="ourdoctors.title" var="title"/>
<fmt:message key="ourdoctors.message" var="message"/>
<fmt:message key="ourdoctors.message1" var="message1"/>
<fmt:message key="ourdoctors.message2" var="message2"/>
<fmt:message key="ourdoctors.message3" var="message3"/>
<html>
<header id="header">
    <%@include file="../header/header.jsp" %>
</header>
<head>
    <title>${title}</title>
</head>
<body>
<h2 class="text-center text-primary">${message}</h2>
<div class="card-group">
    <div class="card text-body  bg-info mb-3">
        <img src='<%=request.getContextPath() %>/img/card21.jpeg' class="card-img-top" alt="...">
        <div class="card-body">
            <p class="card-text">
              ${message1} </p>
        </div>
    </div>
    <div class="card text-body  bg-info mb-3">
        <img src='<%=request.getContextPath() %>/img/card14.jpeg' class="card-img-top" alt="...">
        <div class="card-body">
            <p class="card-text">${message2}</p>
        </div>
    </div>
    <div class="card text-body  bg-info mb-3">
        <img src='<%=request.getContextPath() %>/img/card10.jpeg' class="card-img-top" alt="...">
        <div class="card-body">
            <p class="card-text"> ${message3}</p>
        </div>
    </div>
</div>
<a href="#header" class="btn-lg btn-danger">UP</a>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>

