<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="updateprotocol.title" var="title" />
<fmt:message key="updateprotocol.message1" var="message1" />
<fmt:message key="updateprotocol.message2" var="message2" />
<fmt:message key="updateprotocol.message3" var="message3" />
<fmt:message key="updateprotocol.message4" var="message4" />
<fmt:message key="updateprotocol.back1" var="back1" />
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
        <input type="hidden" name="command" value="admin_update_protocol_cost_command">
        <label class="form-label">  ${message2}</label>
        <input type="text"  required  pattern="([0-9]{1,10})"name="protocol_cost">
        <label class="form-label"> ${message1}</label>
        <input type="text" required pattern="([0-9]{1,10})"name="protocol_id">
        <input type="submit">
        <br/>
    </form>

    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="admin_update_protocol_status_command">
        <label class="form-label"> ${message1}</label>
        <input type="text"  required pattern="([0-9]{1,10})"  name="protocol_id">
        <label class="form-label"> ${message3}</label>
        <input type="text" required  pattern="(?i)(paid)|(duty)" name="status">
        <input type="submit">
        <br/>
    </form>

    <br/>

    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="admin_update_protocol_application_command">
        <label class="form-label"> ${message1}</label>
        <input type="text"  required pattern="([0-9]{1,10})" name="protocol_id">
        <label class="form-label">  ${message4}</label>
        <input type="text" required  pattern="(?i)(approved)|(active)" name="application">
        <input type="submit">
        <br/>
    </form>
    <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/update.jsp"
       role="button">${back1}</a>

    <br/>
    </form>
</div>
<a href="#header" class="btn-lg btn-danger">UP</a>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
