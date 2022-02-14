<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="account.title" var="title"/>
<fmt:message key="account.login" var="login"/>
<fmt:message key="account.password" var="password"/>
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
    <br/>
    <input type="hidden" name="command" value="account_user_command">
    <label class="form-check"> ${login} </label>
    <input name="login"  value="${user.login}" required>
    <br/>
    <label class="form-label"> ${firstname} </label>
    <input name="first_name" value="${user.firstName}" required>
    <br/>
    <label class="form-label"> ${lastname} </label>
    <input name="last_name" value="${user.lastName}" required>
    <br/>
    <label class="form-label"> ${email} </label>
    <input name="email" value="${user.email}" required>
    <br/>
    <label class="form-label"> ${phonenumber} </label>
    <input name="phone_number" value="${user.phoneNumber}" required>
    <br/>
    <label class="form-label"> ${address} </label>
    <input name="address" value="${user.address}" required>
    <br/>

</form>
</div>


<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
