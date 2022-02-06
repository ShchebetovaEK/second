<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
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
    <title>Main</title>
</head>
<body>
<div class="text-center text-success">
     <h1>our destinations </h1>
         <br/>
</div>
<div class="card-group">
    <div class="card text-body  bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card3.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">THERAPY</h5>
            <p class="card-text">
                In our center, you can get advice from a general practitioner
                about measures to prevent hypertension, congestive heart failure and other.</p>
            <p class="card-text"><small class="text-muted"> Appointment to the doctor.</small></p>
        </div>
    </div>
    <div class="card bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card9.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">PEDIATRICS</h5>
            <p class="card-text">Our best specialists will take care of your child's health.</p>
            <p class="card-text"><small class="text-muted">Personal pediatrician service available.</small></p>
            <a href="${pageContext.request.contextPath}/controller?command=go_to_pediatric_command"  class="btn btn-outline-primary" tabindex="-1" role="button" aria-disabled="true">GO TO</a>
        </div>
    </div>
    <div class="card bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card13.jpeg' class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title"> SURGERY </h5>
            <p class="card-text">On the basis of our center it is possible to carry out surgical manipulations</p>
            <p class="card-text"><small class="text-muted"> More information here.</small></p>
        </div>
    </div>
</div>

<div class="card-group">
    <div class="card text-body  bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card7.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title"> INJECTION</h5>
            <p class="card-text">Carrying out injections in our center under the supervision of experienced specialists.</p>
            <p class="card-text"><small class="text-muted"> Price here</small></p>
        </div>
    </div>
    <div class="card bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card17.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">VACCINATION</h5>
            <p class="card-text">Vaccination is the main measure against many infectious diseases.</p>
            <p class="card-text"> Vaccination against covid-19<small class="text-muted"></small></p>
        </div>
    </div>
    <div class="card bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card22.jpeg' class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title"> LABORATORY </h5>
            <p class="card-text">Laboratory diagnostics is represented by blood sampling, urine sampling, sputum culture.</p>
            <p class="card-text">Tests for Antibodies to covid-19<small class="text-muted"></small></p>
        </div>
    </div>
</div>

<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>