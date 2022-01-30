<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="registration.title" var="registration_title"/>
<fmt:message key="registration.sign_up_1" var="sign_up"/>
<fmt:message key="registration.login" var="login"/>
<fmt:message key="registration.password" var="psw"/>
<%--<fmt:message key="registration.confirm_password" var="confirm_psw"/>--%>
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
<fmt:message key="registration.not_unique_login" var="not_unique_login_message"/>
<fmt:message key="registration.password_mismatch" var="psw_mismatch_message"/>
<fmt:message key="registration.not_unique_email" var="not_unique_email_message"/>
<fmt:message key="registration.not_unique_mobile_number" var="not_unique_mobile_number_message"/>

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
<h1>registration</h1>
<div class="container-fluid" id="container-fluid">
    <form action="${abs}/controller" method="post">
        <input type="hidden" name="command" value="registration_command">

        Login: <input type="text" id="login" class="form-control" name="login" value="${valid_login}">
        <c:choose>
            <c:when test="${invalid_login eq 'invalid_message'}">
                <div id="message1"><b>${invalid_login_message}</b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        Password: <input type="password" id="password" class="form-control" name="password">
        <c:if test="${invalid_passport eq 'invalid_message'}">
            <div id="message2"><b>${invalid_psw_message}</b></div>
        </c:if>
        <br/><br/>
<%--        Confirm password: <input type="password" id="confirm-password" class="form-control" name="confirm_password">--%>
<%--        <c:if test="${invalid_passport eq 'password_mismatch'}">--%>
<%--            <div id="message2"><b>${psw_mismatch_message}</b></div>--%>
<%--        </c:if>--%>
        <br/><br/>
        First name: <input type="first_name" id="first_name" class="form-control" name="first_name">
        <c:choose>
            <c:when test="${invalid_first_name eq 'invalid_message'}">
                <div id="message4"><b><${invalid_first_name_message}></b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        Last name: <input type="last_name" id="last_name" class="form-control" name="last_name">
        <c:choose>
            <c:when test="${invalid_last_name eq 'invalid_message'}">
                <div id="message5"><b><${invalid_last_name_message}></b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        Data birthday: <input type="data_birthday" id="data_birthday" class="form-control" name="data_birthday">
        <c:choose>
            <c:when test="${invalid_databirthday eq 'invalid_message'}">
                <div id="message6"><b><${invalid_databirthday_message}></b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        Address: <input type="address" id="address" class="form-control" name="address">
        <c:choose>
            <c:when test="${invalid_address eq 'invalid_message'}">
                <div id="message7"><b><${invalid_address_message}></b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        Phone number: <input type="phone_number" id="phone_number" class="form-control" name="phone_number">
        <c:choose>
            <c:when test="${invalid_phone_number eq 'invalid_message'}">
                <div id="message8"><b><${invalid_phone_number_message}></b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        Email: <input type="email" id="email-address" class="form-control" name="email" value="${valid_email}">
        <c:choose>
            <c:when test="${invalid_email eq 'invalid_message'}">
                <div id="message9"><b>${invalid_email_message}</b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        <input type="submit" class="form-control" id="sign_up" name="submit"><br/>
    </form>
</div>


<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>