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
    <link rel="shortcut icon" href="../../img/png-transparent-graphy-logo-tree-leaf-branch-logo.png" type="image/x-icon">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/fontello.css">
    <title>Welcome</title>
</head>
<body>
<h1> WELCOME!!</h1>


<div class="card text-center text-white bg-success mb-3" style="width: 30rem;">
    <img src='<%=request.getContextPath() %>/img/card1.jpeg' class="card-img-top">
    <div class="card-body">
        <h5 class="card-title"> UltraSound </h5>
        <p class="card-text" >
            Ultrasound examinations are carried out in our center on the basis of modern equipment.</p>
        <a href="${pageContext.request.contextPath}/controller?command=go_to_price_command" class="card-link">price</a>
        <a href="${pageContext.request.contextPath}/controller?command=go_to_doctors_command"
           class="card-link">doctors</a>
    </div>
</div>

<div class="card-group">
    <div class="card text-body  bg-info mb-3">
        <img src='<%=request.getContextPath() %>/img/card2.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">Card title</h5>
            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional
                content. This content is a little bit longer.</p>
            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
        </div>
    </div>
    <div class="card bg-light mb-3">
        <img src='<%=request.getContextPath() %>/img/card3.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">Card title</h5>
            <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
        </div>
    </div>
    <div class="card bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card4.jpeg' class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">Card title</h5>
            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional
                content. This card has even longer content than the first to show that equal height action.</p>
            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
        </div>
    </div>
</div>
<img src="/img/iStock-1150397417_1000_d_850.jpg" class="img-fluid" alt="...">

<%--<label for="password">${psw}</label><br/>--%>
<%--<input type="password" id="password" class="form-control" name="password" placeholder="${psw}">--%>
<%--<c:if test="${invalid_passport eq 'invalid_message'}"><div id="message2"><b>${invalid_psw_message}</b></div></c:if>--%>
<%--<br/><br/>--%>
<%--<li><a href="${abs}/controller?command=change_locale_command">${nigiri_option}</a></li>--%>
<%--<h3 class="text-center text-danger"><%= "Please, input your login and password :" %>--%>
<%--</h3>--%>
<%--<br/>--%>
<%--<span class="border border-warning"></span>--%>
<%--login: <input type="email" name="email">--%>
<%--<br/>--%>
<%--password <input type="password" name="password" minlength="6">--%>
<%--<input type="button" value="push">--%>
<%--<br/>--%>
<%--<input type="button" value="registration">--%>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>