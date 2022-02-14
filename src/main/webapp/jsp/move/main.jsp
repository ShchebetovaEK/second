<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="main.title" var="title"/>
<fmt:message key="main.message" var="message"/>
<fmt:message key="main.message1" var="message1"/>
<fmt:message key="main.message2" var="message2"/>
<fmt:message key="main.message3" var="message3"/>
<fmt:message key="main.message4" var="message4"/>
<fmt:message key="main.message5" var="message5"/>
<fmt:message key="main.message6" var="message6"/>
<fmt:message key="main.message7" var="message7"/>
<fmt:message key="main.message8" var="message8"/>
<fmt:message key="main.message9" var="message9"/>
<fmt:message key="main.message10" var="message10"/>
<fmt:message key="main.message11" var="message11"/>
<fmt:message key="main.message12" var="message12"/>
<fmt:message key="main.message13" var="message13"/>
<fmt:message key="main.message14" var="message14"/>
<fmt:message key="main.message15" var="message15"/>
<fmt:message key="main.message16" var="message16"/>
<fmt:message key="main.message17" var="message17"/>
<fmt:message key="main.message18" var="message18"/>
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
<div class="text-center text-success">
     <h1>${message}</h1>
         <br/>
</div>
<div class="card-group">
    <div class="card text-body  bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card3.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${message1}</h5>
            <p class="card-text">
                ${message2}</p>
            <p class="card-text"><small class="text-muted"> ${message3}</small></p>
        </div>
    </div>
    <div class="card bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card9.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${message4}</h5>
            <p class="card-text">${message5}</p>
            <p class="card-text"><small class="text-muted">${message6}</small></p>
            <a href="${pageContext.request.contextPath}/controller?command=go_to_pediatric_command"  class="btn btn-outline-primary" tabindex="-1" role="button" aria-disabled="true">GO TO</a>
        </div>
    </div>
    <div class="card bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card13.jpeg' class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title"> ${message7} </h5>
            <p class="card-text">${message8}</p>
            <p class="card-text"><small class="text-muted"> ${message9}</small></p>
        </div>
    </div>
</div>

<div class="card-group">
    <div class="card text-body  bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card7.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title"> ${message10}</h5>
            <p class="card-text">${message11}</p>
            <p class="card-text"><small class="text-muted">${message12}</small></p>
        </div>
    </div>
    <div class="card bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card17.jpeg'
             class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${message13}</h5>
            <p class="card-text">${message14}</p>
            <p class="card-text"> ${message15}<small class="text-muted"></small></p>
        </div>
    </div>
    <div class="card bg-warning mb-3">
        <img src='<%=request.getContextPath() %>/img/card22.jpeg' class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title"> ${message16} </h5>
            <p class="card-text"> ${message17}</p>
            <p class="card-text"> ${message18}<small class="text-muted"></small></p>
        </div>
    </div>
</div>
<a href="#header" class="btn-lg btn-danger">UP</a>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>