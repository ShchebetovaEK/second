<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="select.title" var="title" />
<fmt:message key="select.message1" var="message1" />
<fmt:message key="select.message2" var="message2" />
<fmt:message key="select.message3" var="message3" />
<fmt:message key="select.message4" var="message4" />
<fmt:message key="select.message5" var="message5" />
<fmt:message key="select.message6" var="message6" />
<fmt:message key="select.back1" var="back1" />
<fmt:message key="select.back2" var="back2" />
<fmt:message key="select.back3" var="back3" />
<fmt:message key="select.back4" var="back4" />
<fmt:message key="select.id" var="id"/>
<fmt:message key="select.role" var="role"/>
<fmt:message key="select.login" var="login"/>
<fmt:message key="select.firstName" var="firstName"/>
<fmt:message key="select.lastName" var="lastName"/>
<fmt:message key="select.address" var="address"/>
<fmt:message key="select.email" var="email"/>
<fmt:message key="select.phoneNumber" var="phoneNumber"/>
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

<div class="text-center">
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="databirthday_discount_command">
        <label class="form-label">${message6} </label>
        <input type="date"  name="data_birthday" required >
        <input type="submit">
    </form>
    <br/>

</div>

<a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/select.jsp"
   role="button">${back2}</a>
<a href="#header" class="btn-lg btn-danger">UP</a>
<footer id="footer">
    <div class="text-center"> <ctg:footer/>
    </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>

</body>
</html>