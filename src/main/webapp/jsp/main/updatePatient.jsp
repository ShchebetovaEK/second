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
    <link rel="shortcut icon" href="../../img/png-transparent-graphy-logo-tree-leaf-branch-logo.png"
          type="image/x-icon">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/fontello.css">
    <title>Manager Page</title>
</head>
<body>
<div class="text-center">
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_patient_insurance_command">
        <label class="form-label"> please, input patient's id:</label>
        <input type="text" name="users_id">
        <label class="form-label"> please, input desired insurance:</label>
        <input type="text" name="insurance">
        <input type="submit">
    </form>
    <br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_patient_discount_command">
        <label class="form-label"> please, input patient's id:</label>
        <input type="text" name="users_id">
        <label class="form-label"> please, input desired discount:</label>
        <input type="text" name="discount">
        <input type="submit">
    </form>
    <br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="update_patient_money_account_command">
        <label class="form-label"> please, input patient's id:</label>
        <input type="text" name="users_id">
        <label class="form-label"> please, input money account:</label>
        <input type="text" name="money_account">
        <input type="submit">
    </form>
</div>

<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
