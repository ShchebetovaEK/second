<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<html>
<header>
    <%@include file="../header/header.jsp" %>
</header>
<head>
    <title>About Us</title>
</head>
<body>
    <div class="text-center text-success">
        Multidisciplinary medical company "ForestMed" has been operating since 2002.
        For almost 20 years of activity, the centers have received many awards in their industry and, most importantly,
        people's trust and recognition. "ForestMed" is among the most famous medical centers of the Republic of Belarus.
        Assistance to the population is provided in more than 20 specialties.
        The quality of the services provided
        is under constant control of the company's management so that patient care meets the highest international standards
    </div>
    <br/>
    <div class="text-center text-danger"><h1> Our Centers </h1></div>
<div class="card-group">
    <div class="card text-body  bg-info mb-3">
        <img src='<%=request.getContextPath() %>/img/clinic1.jpeg' class="card-img-top" alt="...">

        <div class="card-body">

            <p class="card-text">  Minsk city, Gikalo street, 1 </p>
        </div>
    </div>
    <div class="card text-body  bg-info mb-3">
        <img src='<%=request.getContextPath() %>/img/clinic2.jpeg' class="card-img-top" alt="...">

        <div class="card-body">

            <p class="card-text">  Minsk city, Independence street, 58A</p>
        </div>
    </div>
    <div class="card text-body  bg-info mb-3">
        <img src='<%=request.getContextPath() %>/img/clinic3.jpeg' class="card-img-top" alt="...">
        <div class="card-body">

            <p class="card-text"> Minsk city, Pritytskogo street, 140 </p>
        </div>
    </div>
</div>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
