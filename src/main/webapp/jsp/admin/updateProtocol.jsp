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
    <title>${title}</title>
</head>
<body>
<div class="text-center">
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="admin_update_protocol_cost_command">
        <label class="form-label">  please, input protocol_cost:</label>
        <input type="text" name="protocol_cost">
        <label class="form-label"> please, input protocol's id:</label>
        <input type="text" name="protocol_id">
        <input type="submit">
        <br/>
    </form>

    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="admin_update_protocol_status_command">
        <label class="form-label"> please, input protocol's id:</label>
        <input type="text" name="protocol_id">
        <label class="form-label">  please, input protocol status:</label>
        <input type="text" name="status">
        <input type="submit">
        <br/>
    </form>

    <br/>

    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="admin_update_protocol_application_command">
        <label class="form-label"> please, input protocol's id:</label>
        <input type="text" name="protocol_id">
        <label class="form-label">  please, input protocol application:</label>
        <input type="text" name="application">
        <input type="submit">
        <br/>
    </form>




    <br/>
    </form>
</div>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
