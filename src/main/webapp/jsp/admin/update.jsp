<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="update.title" var="title" />
<fmt:message key="update.message1" var="message1" />
<fmt:message key="update.message2" var="message2" />
<fmt:message key="update.message3" var="message3" />
<fmt:message key="update.message4" var="message4" />
<fmt:message key="update.message5" var="message5" />
<fmt:message key="update.message6" var="message6" />
<fmt:message key="update.back1" var="back1" />

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
        <input type="hidden" name="command" value="update_user_first_name_command">
        <label class="form-label">${message1}</label>
        <input type="text" required pattern="([0-9]{1,10})" name="id">
        <label class="form-label"> ${message2}</label>
        <input type="text"  required pattern="([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})" name="first_name">
        <input type="submit">
    </form>
    <br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_user_last_name_command">
        <label class="form-label"> ${message1}</label>
        <input type="text" required pattern="([0-9]{1,10})" name="id">
        <label class="form-label">${message3}</label>
        <input type="text" required pattern="([А-Я]{1}[а-яё]{1,30}|[A-Z]{1}[a-z]{1,30})" name="last_name">
        <input type="submit">
    </form>
    <br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_user_address_command">
        <label class="form-label"> ${message1}</label>
        <input type="text" required pattern="([0-9]{1,10})"name="id">
        <label class="form-label">${message4}</label>
        <input type="text"  required pattern="([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})(\s)(\d{1,3})\-(\d{1,3})" name="address">
        <input type="submit">
    </form>
    <br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_user_phone_number_command">
        <label class="form-label"> ${message1}</label>
        <input type="text" required pattern="([0-9]{1,10})" name="id">
        <label class="form-label">${message5}</label>
        <input type="text"  required pattern="((\+375|80)(25|29|33|44)\d{7})" name="phone_number">
        <input type="submit">
    </form>
    <br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_user_email_command">
        <label class="form-label"> ${message1}</label>
        <input type="text" required pattern="([0-9]{1,10})" name="id">
        <label class="form-label"> ${message6}</label>
        <input type="text"  required pattern="((\w|[-+])+(\.(\w|[-+])*)*@[a-z]+\.[a-z]+)" name="email">
        <input type="submit">
    </form>
    <a class="btn btn-success" href="${abs}/jsp/admin/update.jsp"
       role="button">${back1}</a>
</div>
<a href="#header" class="btn-lg btn-danger">UP</a>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
