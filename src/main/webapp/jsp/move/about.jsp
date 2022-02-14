<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="about.title" var="title"/>
<fmt:message key="about.greeting" var="greting"/>
<fmt:message key="about.message1" var="message1"/>
<fmt:message key="about.address1" var="address1"/>
<fmt:message key="about.address2" var="address2"/>
<fmt:message key="about.address3" var="address3"/>
<html>
<header id="header">
    <%@include file="../header/header.jsp" %>
</header>
<head>
    <title>${title}</title>
</head>
<body>
    <div class="text-center text-success">
     <h2> ${greting}</h2>
    </div>
    <br/>
    <div class="text-center text-danger"><h1> ${message1} </h1></div>
<div class="card-group">
    <div class="card text-body  bg-info mb-3">
        <img src='<%=request.getContextPath() %>/img/clinic1.jpeg' class="card-img-top" alt="...">

        <div class="card-body">

            <p class="card-text"> ${address1} </p>
        </div>
    </div>
    <div class="card text-body  bg-info mb-3">
        <img src='<%=request.getContextPath() %>/img/clinic2.jpeg' class="card-img-top" alt="...">

        <div class="card-body">

            <p class="card-text">  ${address2}</p>
        </div>
    </div>
    <div class="card text-body  bg-info mb-3">
        <img src='<%=request.getContextPath() %>/img/clinic3.jpeg' class="card-img-top" alt="...">
        <div class="card-body">

            <p class="card-text"> ${address3} </p>
        </div>
    </div>
</div>
    <a href="#header" class="btn-lg btn-danger">UP</a>
    <footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
