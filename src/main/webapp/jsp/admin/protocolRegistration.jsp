<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="protocolregistration.title" var="title"/>
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
    <title>PROTOCOL REGISTRATION</title>
</head>
<body>
<div class="text-center">
    <h1 class="text-center">registration</h1>
    <div class="container-fluid" id="container-fluid">
        <form action="${abs}/controller" method="post">
            <input type="hidden" name="command" value="admin_register_protocol_command">
            <label class="text-center">protocol_data</label>
            <input type="date" id="protocol_data" class="form-control" name="protocol_data">
            <%--        value="${valid_protocol_data}">--%>
            <%--        <c:choose>--%>
            <%--            <c:when test="${invalid_protocol_data eq 'invalid_message'}">--%>
            <%--                <div id="message1"><b>${invalid_protocol_data_message}</b></div>--%>
            <%--            </c:when>--%>
            <%--        </c:choose>--%>
            <br/><br/>
            <label class="text-center">protocol_payer:</label>
            <input type="text" id="protocol_payer" class="form-control" name="protocol_payer"
                   placeholder="patient  insurance">
            <%--        <c:if test="${invalid_passport eq 'invalid_message'}">--%>
            <%--            <div id="message2"><b>${invalid_psw_message}</b></div>--%>
            <%--        </c:if>--%>
            <%--        Confirm password: <input type="password" id="confirm-password" class="form-control" name="confirm_password">--%>
            <%--        <c:if test="${invalid_passport eq 'password_mismatch'}">--%>
            <%--            <div id="message2"><b>${psw_mismatch_message}</b></div>--%>
            <%--        </c:if>--%>
            <br/><br/>
            <label class="text-center">protocol_cost:</label>
            <input type="text" id="protocol_cost" class="form-control" name="protocol_cost"
                   placeholder="protocol_cost">
            <%--        <c:choose>--%>
            <%--            <c:when test="${invalid_first_name eq 'invalid_message'}">--%>
            <%--                <div id="message4"><b><${invalid_first_name_message}></b></div>--%>
            <%--            </c:when>--%>
            <%--        </c:choose>--%>
            <br/><br/>
            <label class="text-center">patients_users_id:</label>
            <input type="text" id="patients_users_id" class="form-control" name="patients_users_id">
            <%--        <c:choose>--%>
            <%--            <c:when test="${invalid_last_name eq 'invalid_message'}">--%>
            <%--                <div id="message5"><b><${invalid_last_name_message}></b></div>--%>
            <%--            </c:when>--%>
            <%--        </c:choose>--%>
            <br/><br/>
            <label class="text-center"> doctors_users_id:</label>
            <input type="text" id="doctors_users_id" class="form-control" name="doctors_users_id">
            <%--        <c:choose>--%>
            <%--            <c:when test="${invalid_databirthday eq 'invalid_message'}">--%>
            <%--                <div id="message6"><b><${invalid_databirthday_message}></b></div>--%>
            <%--            </c:when>--%>
            <%--        </c:choose>--%>
            <br/><br/>
            <label class="text-center"> application:</label>
            <input type="text" id="application" class="form-control" name="application">
            <br/>
            <input type="submit" class="form-control" id="sign_up" name="submit"><br/>
        </form>
    </div>
</div>
<a href="#header" class="btn-lg btn-danger">UP</a>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>