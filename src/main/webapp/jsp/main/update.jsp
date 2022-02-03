<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Manager Page</title>
</head>
<body>



<%--<form action="${abs}/controller" method="get">--%>
<%--    <input type="hidden" name="command" value="update_user_first_name_command">--%>
<%--    please, input  id: <input type="text" name="id" >--%>
<%--    please, input desired first name: <input type="text" name="first_name" >--%>
<%--    <input type="submit" >--%>
<%--</form>--%>
<%--<br/>--%>
<%--<form action="${abs}/controller" method="get">--%>
<%--    <input type="hidden" name="command" value="update_user_last_name_command">--%>
<%--    please, input  id: <input type="text" name="id" >--%>
<%--    click to update last name  <input type="text" name="last_name" >--%>
<%--    <input type="submit" >--%>
<%--</form>--%>
<%--<br/>--%>
<%--<form action="${abs}/controller" method="get">--%>
<%--    <input type="hidden" name="command" value="update_user_address_command">--%>
<%--    please, input  id: <input type="text" name="id" >--%>
<%--    please, input desired address: <input type="text" name="address" >--%>
<%--    <input type="submit" >--%>
<%--</form>--%>
<%--<br/>--%>
<%--<form action="${abs}/controller" method="get">--%>
<%--    <input type="hidden" name="command" value="update_user_phone_number_command">--%>
<%--    please, input  id: <input type="text" name="id" >--%>
<%--    please, input desired phone number: <input type="text" name="phone_number" >--%>
<%--    <input type="submit" >--%>
<%--</form>--%>
<%--<br/>--%>
<%--<form action="${abs}/controller" method="get">--%>
<%--    <input type="hidden" name="command" value="update_user_email_command">--%>
<%--    please, input  id: <input type="text" name="id" >--%>
<%--    please, input desired email: <input type="text" name="email" >--%>
<%--    <input type="submit" >--%>
<%--</form>--%>

<%--<form action="${abs}/controller" method="get">--%>
<%--    <input type="hidden" name="command" value="update_doctor_category_command">--%>
<%--    please, input  id: <input type="text" name="users_id" >--%>
<%--    please, input desired category: <input type="text" name="category" pattern="HIGH"pattern ="SECOND" pattern="FIRST">--%>
<%--    <input type="submit" >--%>
<%--</form>--%>
<%--<form action="${abs}/controller" method="get">--%>
<%--    <input type="hidden" name="command" value="update_doctor_experience_command">--%>
<%--    please, input  id: <input type="text" name="users_id" >--%>
<%--    please, input desired experience: <input type="text" name="experience" >--%>
<%--    <input type="submit" >--%>
<%--</form>--%>
<%--<form action="${abs}/controller" method="get">--%>
<%--    <input type="hidden" name="command" value="update_doctor_speciality_command">--%>
<%--    please, input  id: <input type="text" name="users_id" >--%>
<%--    please, input desired speciality: <input type="text" name="speciality" >--%>
<%--    <input type="submit" >--%>
<%--</form>--%>
<%--<br/>--%>
<%--<form action="${abs}/controller" method="get">--%>
<%--    <input type="hidden" name="command" value="update_patient_insurance_command">--%>
<%--    please, input  id: <input type="text" name="users_id" >--%>
<%--    please, input desired insurance: <input type="text" name="insurance" pattern="true" pattern="false">--%>
<%--    <input type="submit" >--%>
<%--</form>--%>
<%--<br/>--%>
<%--<form action="${abs}/controller" method="get">--%>
<%--    <input type="hidden" name="command" value="update_patient_discount_command">--%>
<%--    please, input  id: <input type="text" name="users_id" >--%>
<%--    please, input desired discount: <input type="text" name="discount" >--%>
<%--    <input type="submit" >--%>
<%--</form>--%>
<%--<br/>--%>
<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="update_patient_money_account_command">
    please, input  id: <input type="text" name="users_id" >
    please, input new money account: <input type="text" name="money_account" >
    <input type="submit" >
</form>


<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
