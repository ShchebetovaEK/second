<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="registration.title" var="registration_title"/>
<fmt:message key="registration.greeting" var="greeting"/>
<fmt:message key="registration.login" var="login"/>
<fmt:message key="registration.password" var="psw"/>
<fmt:message key="registration.first_name" var="first_name"/>
<fmt:message key="registration.last_name" var="last_name"/>
<fmt:message key="registration.address" var="address"/>
<fmt:message key="registration.databirthday" var="data_birthday"/>
<fmt:message key="registration.phone_number" var="phone_number"/>
<fmt:message key="registration.email" var="email"/>
<fmt:message key="registration.invalid_login" var="invalid_login_message"/>
<fmt:message key="registration.invalid_passport" var="invalid_psw_message"/>
<fmt:message key="registration.invalid_first_name" var="invalid_first_name_message"/>
<fmt:message key="registration.invalid_last_name" var="invalid_last_name_message"/>
<fmt:message key="registration.invalid_address" var="invalid_address_message"/>
<fmt:message key="registration.invalid_databirthday" var="invalid_databirthday_message"/>
<fmt:message key="registration.invalid_email" var="invalid_email_message"/>
<fmt:message key="registration.invalid_phone_number" var="invalid_phone_number_message"/>
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
<h1 class="text-center">${greeting}</h1>

<div class="text-center text-info">
    <form  method="post" action="${abs}/controller">
        <div class="row-cols-2">
            <input type="hidden" name="command" value="registration_command">

            <label class="form-label"> login </label>
            <input type="text" id="login" class="form-control" required name="login"
                   pattern="(\w)[\w_-]{1,18}(\w)"
                   value="menistrelka">


<%--            <c:choose>--%>
<%--            <c:when test="${invalid_login eq 'invalid_message'}"><div id="message1"><b>${invalid_login_message}</b></div>--%>
<%--        </c:when>--%>
<%--        </c:choose>--%>
<%--        <br/><br/>--%>


        <label class="form-label"> password </label>
        <input type="password" id="password" class="form-control" value="menistrelka" required
               name="password" pattern="(.{4,40})">


        <c:if test="${invalid_password eq 'invalid_message'}">
        <div id="message2"><b>${invalid_psw_message}</b></div>
        </c:if>
        <br/><br/>


        <label class="form-label"> first name </label>
        <input type="first_name" id="first_name" class="form-control" value="Anna" required
               name="first_name"
               pattern="([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})">


<%--        <c:choose>--%>
<%--        <c:when test="${invalid_first_name eq 'invalid_message'}">--%>
<%--        <div id="message4"><b><${invalid_first_name_message}></b></div>--%>
<%--        </c:when>--%>
<%--        </c:choose>--%>
<%--        <br/><br/>--%>


        <label class="form-label"> last name </label>
        <input type="last_name" id="last_name" class="form-control" value="Pliats" required
               name="last_name"
               pattern="([А-Я]{1}[а-яё]{1,30}|[A-Z]{1}[a-z]{1,30})">

<%--        <c:choose>--%>
<%--        <c:when test="${invalid_last_name eq 'invalid_message'}">--%>
<%--        <div id="message5"><b><${invalid_last_name_message}></b></div>--%>
<%--        </c:when>--%>
<%--        </c:choose>--%>
<%--        <br/><br/>--%>

        <label class="form-label"> data </label>
        <input type="date" id="data_birthday" class="form-control" required name="data_birthday"
               pattern="\d{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])">

<%--        <c:choose>--%>
<%--        <c:when test="${invalid_databirthday eq 'invalid_message'}">--%>
<%--        <div id="message6"><b><${invalid_databirthday_message}></b></div>--%>
<%--        </c:when>--%>
<%--        </c:choose>--%>
<%--        <br/><br/>--%>


        <label class="form-label"> address </label>
        <input type="address" id="address" class="form-control" value="Острошицкая 23-168" required
               name="address"
               pattern="([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})(\s)(\d{1,3})\-(\d{1,3})">

<%--        <c:choose>--%>
<%--        <c:when test="${invalid_address eq 'invalid_message'}">--%>
<%--        <div id="message7"><b><${invalid_address_message}></b></div>--%>
<%--        </c:when>--%>
<%--        </c:choose>--%>
<%--        <br/><br/>--%>


        <label class="form-label"> phone number </label>
        <input type="phone_number" id="phone_number" class="form-control" value="+375292561473"
               required name="phone_number"
               pattern="((\+375|80)(25|29|33|44)\d{7})">

<%--        <c:choose>--%>
<%--        <c:when test="${invalid_phone_number eq 'invalid_message'}">--%>
<%--        <div id="message8"><b><${invalid_phone_number_message}></b></div>--%>
<%--        </c:when>--%>
<%--        </c:choose>--%>
<%--        <br/><br/>--%>

        <label class="form-label"> email </label>
        <input type="email" id="email-address" class="form-control" name="email"
               placeholder="arbat413@gmail.com" value="ap.wiskiss@gmail.com"
               required pattern="((\w|[-+])+(\.(\w|[-+])*)*@[a-z]+\.[a-z]+)">

<%--        <c:choose>--%>
<%--        <c:when test="${invalid_email eq 'invalid_message'}">--%>
<%--        <div id="message9"><b>${invalid_email_message}</b></div>--%>
<%--        </c:when>--%>
<%--        </c:choose>--%>
<%--        <br/><br/>--%>
            <label class="form-label"> insurance </label>
            <input type="insurance" id="insurance" class="form-control" name="insurance"
                   placeholder="true" value="true"
                   required pattern="i?(true)(false)">

            <label class="form-label"> money account </label>
            <input type="money_account" id="money_account" class="form-control" name="money_account"
                   placeholder="2" value="5"
                   required  >

<%--            <label class="form-label"> discount </label>--%>
<%--            <input type="discount" id="discount" class="form-control" name="discount"--%>
<%--                   placeholder="2" value="1"--%>
<%--                   required >--%>


            <input type="submit" class="form-control" id="sign_up" value="submit"><br/>
        </div>
</form>
</div>

<a href="#header" class="btn-lg btn-danger">UP</a>

<footer>
    <div class="text-center"><ctg:footer/></div>
</footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>