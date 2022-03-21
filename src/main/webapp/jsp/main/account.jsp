<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="account.title" var="title"/>
<fmt:message key="account.logine" var="logine"/>
<fmt:message key="account.role" var="role"/>
<fmt:message key="account.firstname" var="firstname"/>
<fmt:message key="account.lastname" var="lastname"/>
<fmt:message key="account.address" var="address"/>
<fmt:message key="account.email" var="email"/>
<fmt:message key="account.phonenumber" var="phonenumber"/>
<fmt:message key="account.password" var="password"/>
<fmt:message key="account.confirmpassword" var="confirmpassword"/>
<fmt:message key="account.newpassword" var="newpassword"/>

<html>
<header>
    <%@include file="../header/header.jsp" %>
</header>
<head>
    <title>${title}</title>
</head>
<body>

</br>

<div class="text-center text-info">
    <form method="POST" action="${abs}/controller">
        <div class="row-cols-3">
            <input type="hidden" name="command" value="change_account_command">
            <label class="form-label"> ${logine} </label>
            <input name="login" value="${user.login}" required>

            <label class="form-label"> ${firstname} </label>
            <input type="text" name="first_name" value="${user.firstName}" required>

            <label class="form-label"> ${lastname} </label>
            <input type="text" name="last_name" value="${user.lastName}" required>

            <label class="form-label"> ${phonenumber} </label>
            <input type="text" name="phone_number" value="${user.phoneNumber}" required>

            <label class="form-label"> ${address} </label>
            <input type="text" name="address" value="${user.address}" required>

            <label class="form-label"> ${email} </label>
            <input type="text" name="email" value="${user.email}" required>

            <input type="submit" value="submit"><br/>
        </div>
    </form>
</div>


<%--<form method="POST" action="${abs}/controller">--%>
<%--    <div class="row-cols-3">--%>
<%--        <input type="hidden" name="command" value="change_password_command">--%>
<%----%>
<%--        <label class="form-label"> ${password} </label>--%>
<%--        <input type="password" name="password"  required>--%>
<%----%>
<%--        <label class="form-label"> ${newpassword} </label>--%>
<%--        <input type="password" name="new_password"  required>--%>
<%----%>
<%--        <label class="form-label"> ${confirmpassword} </label>--%>
<%--        <input type="password" name="confirm_password"  required>--%>
<%----%>
<%--        <input type="submit" value="submit"><br/>--%>
<%--    </div>--%>
<%--</form>--%>
<%--</div>--%>
<div class="text-center">
    <a class="btn btn-warning" href="${abs}/jsp/main/changePassword.jsp"
       role="button">select change password page</a>
</div>
<footer>
    <div class="text-center"><ctg:footer/></div>
</footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
