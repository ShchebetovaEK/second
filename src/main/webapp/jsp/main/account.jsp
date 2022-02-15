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

<html>
<header>
    <%@include file="../header/header.jsp" %>
</header>
<head>
    <title>${title}</title>
</head>
<body>


 <div class="text-center text-info">
<form method="POST" action="${abs}/controller">

    <input type="hidden" name="command" value="account_user_command">
    <br/>
    <label class="form-check"> ${logine} </label>
    <input name="login"  value="${user.login}" required>


    <input name="role"  value="${user.role}" required>

    <label class="form-label"> ${firstname} </label>
    <input name="first_name" value="${user.firstName}" required>

    <label class="form-label"> ${lastname} </label>
    <input name="last_name" value="${user.lastName}" required>

    <label class="form-label"> ${email} </label>
    <input name="email" value="${user.email}" required>

    <label class="form-label"> ${phonenumber} </label>
    <input name="phone_number" value="${user.phoneNumber}" required>

    <label class="form-label"> ${address} </label>
    <input name="address" value="${user.address}" required>


</form>

</div>


<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
