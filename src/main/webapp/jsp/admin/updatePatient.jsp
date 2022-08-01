<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="updatepatient.title" var="title" />
<fmt:message key="updatepatient.message1" var="message1" />
<fmt:message key="updatepatient.message2" var="message2" />
<fmt:message key="updatepatient.message3" var="message3" />
<fmt:message key="updatepatient.message4" var="message4" />
<fmt:message key="updatepatient.message5" var="message5" />
<fmt:message key="updatepatient.back1" var="back1" />
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
        <input type="hidden" name="command" value="update_patient_insurance_command">
        <label class="form-label">${message1}</label>
        <input type="text" required pattern="([0-9]{1,10})" name="users_id">
        <label class="form-label">${message2}</label>
        <input type="text"  required  pattern="(?i)(true)(false)" name="insurance">
        <input type="submit">
    </form>
    <br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_patient_discount_command">
        <label class="form-label"> ${message1}</label>
        <input type="text"  required pattern="([0-9]{1,10})" name="users_id">
        <label class="form-label"> ${message3}</label>
        <input type="text" name="discount" required pattern="[0-9]{1,2}">
        <input type="submit">
    </form>
    <br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_patient_money_account_command">
        <label class="form-label"> ${message1}</label>
        <input type="text" required pattern="([0-9]{1,10})" name="users_id">
        <label class="form-label"> ${message4}</label>
        <input type="text" required  pattern="([0-9]{1,10})" name="money_account">
        <input type="submit">
    </form>


    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_patient_balance_command">
        <label class="form-label"> ${message1}</label>
        <input type="text" required pattern="([0-9]{1,10})" name="users_id">
        <label class="form-label"> ${message5}</label>
        <input type="text" required  pattern="([0-9]{1,10})" name="balance">
        <input type="submit">
    </form>
    <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/update.jsp"
       role="button">${back1}</a>
</div>
<a href="#header" class="btn-lg btn-danger">UP</a>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
