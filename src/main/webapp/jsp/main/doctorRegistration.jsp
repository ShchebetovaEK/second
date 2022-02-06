<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="by.tms.project.model.entity.Category"%>
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
<div class="text-center">
<h1 class="text-center">registration</h1>
<div class="container-fluid" id="container-fluid">
    <form action="${abs}/controller" method="post">
        <input type="hidden" name="command" value="admin_register_doctors_command">
        <label class="form-label"> Login:</label>
        <input type="text" id="login" class="form-control" name="login" value="${valid_login}" placeholder="login">
        <c:choose>
            <c:when test="${invalid_login eq 'invalid_message'}">
                <div id="message1"><b>${invalid_login_message}</b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        <label class="form-label">  Password:</label>
       <input type="password" id="password" class="form-control" name="password" placeholder="password">
        <c:if test="${invalid_passport eq 'invalid_message'}">
            <div id="message2"><b>${invalid_psw_message}</b></div>
        </c:if>
        <br/><br/>
        <%--        Confirm password: <input type="password" id="confirm-password" class="form-control" name="confirm_password">--%>
        <%--        <c:if test="${invalid_passport eq 'password_mismatch'}">--%>
        <%--            <div id="message2"><b>${psw_mismatch_message}</b></div>--%>
        <%--        </c:if>--%>
        <br/><br/>
        <label class="form-label"> First name:</label>
        <input type="first_name" id="first_name" class="form-control" name="first_name" placeholder="Сергей">
        <c:choose>
            <c:when test="${invalid_first_name eq 'invalid_message'}">
                <div id="message4"><b><${invalid_first_name_message}></b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        <label class="form-label"> Last name: </label>
       <input type="last_name" id="last_name" class="form-control" name="last_name" placeholder="Петров">
        <c:choose>
            <c:when test="${invalid_last_name eq 'invalid_message'}">
                <div id="message5"><b><${invalid_last_name_message}></b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        <label class="form-label"> Data birthday:</label>
        <input type="date" id="data_birthday" class="form-control" name="data_birthday" >
        <c:choose>
            <c:when test="${invalid_databirthday eq 'invalid_message'}">
                <div id="message6"><b><${invalid_databirthday_message}></b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        <label class="form-label"> Address: </label>
       <input type="address" id="address" class="form-control" name="address" placeholder="Карвата 12-15">
        <c:choose>
            <c:when test="${invalid_address eq 'invalid_message'}">
                <div id="message7"><b><${invalid_address_message}></b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        <label class="form-label"> Phone number:</label>
        <input type="phone_number" id="phone_number" class="form-control" name="phone_number" placeholder="+375(25/29/44/33)XXXXXXX">
        <c:choose>
            <c:when test="${invalid_phone_number eq 'invalid_message'}">
                <div id="message8"><b><${invalid_phone_number_message}></b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        <label class="form-label"> Email:</label>
        <input type="email" id="email-address" class="form-control" name="email" value="${valid_email}" placeholder="petrov@mail.ru">
        <c:choose>
            <c:when test="${invalid_email eq 'invalid_message'}">
                <div id="message9"><b>${invalid_email_message}</b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        <label class="form-label"> category:</label>
        <input type="category" id="category" class="form-control" name="category" value="${valid_categoty}" placeholder="HIGH  SECOND  FIRST">
        <c:choose>
            <c:when test="${invalid_category eq 'invalid_message'}">
                <div id="message10"><b>${invalid_category_message}</b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        <label class="form-label">experience:</label>
         <input type="experience" id="experience" class="form-control" name="experience" value="${valid_experience}" placeholder="FIVE_YEARS">
        <c:choose>
            <c:when test="${invalid_experience eq 'invalid_message'}">
                <div id="message12"><b>${invalid_experience_message}</b></div>
            </c:when>
        </c:choose>
        <br/><br/>
        <label class="form-label"> speciality:</label>
        <input type="speciality" id="speciality" class="form-control" name="speciality" value="${valid_speciality}" placeholder="UROLOGY   THERAPY   PEDIATRICS">
        <c:choose>
            <c:when test="${invalid_speciality eq 'invalid_message'}">
                <div id="message13"><b>${invalid_speciality_message}</b></div>
            </c:when>
        </c:choose>
        <br/><br/>
</div>
        <input type="submit" class="form-control" id="sign_up" name="submit"><br/>
    </form>
</div>


<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>