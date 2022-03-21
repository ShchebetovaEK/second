<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="welcome.title" var="title"/>
<fmt:message key="welcome.greeting" var="greeting"/>
<fmt:message key="welcome.message1" var="message1"/>
<fmt:message key="welcome.message2" var="message2"/>
<fmt:message key="welcome.message3" var="message3"/>
<fmt:message key="welcome.message4" var="message4"/>
<fmt:message key="welcome.message5" var="message5"/>
<fmt:message key="welcome.message6" var="message6"/>
<fmt:message key="welcome.message7" var="message7"/>
<fmt:message key="welcome.message8" var="message8"/>
<fmt:message key="welcome.message9" var="message9"/>
<html>
<header id="header">
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
<h1 class="text-center"> ${greeting}, ${user.firstName} ${user.lastName}!!</h1>
<div class="card-group">
    <div class="card text-body  bg-info mb-3">
        <img src='<%=request.getContextPath() %>/img/card2.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title"> ${message1}</h5>
            <p class="card-text"> ${message2}</p>
            <p class="card-text">${message3}<small class="text-muted"></small></p>
        </div>
    </div>
    <div class="card bg-light mb-3">
        <img src='<%=request.getContextPath() %>/img/card3.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${message4}</h5>
            <p class="card-text">${message5}</p>
            <p class="card-text">${message6}<small class="text-muted"></small></p>
        </div>
    </div>
    <div class="card bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card4.jpeg' class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${message7}</h5>
            <p class="card-text">${message8}</p>
            <p class="card-text">${message9}<small class="text-muted"></small></p>
        </div>
    </div>
</div>
<a href="#header" class = "text-center" class="btn-lg btn-danger" >UP</a>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>

</script>
</body>
</html>