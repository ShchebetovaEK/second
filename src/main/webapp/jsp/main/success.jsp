<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
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
<br/>
<div class="text-center">
    <div class="mb-3">
        <form method="POST" action="${abs}/controller">
            <h2 class="text-center text-black">
                OPERATION WAS SUCCESSFUL</h2>
            <br/>
            <a class="btn btn-warning" href="${pageContext.request.contextPath}/jsp/move/main.jsp"
               role="button">Back to main</a>
        </form>
    </div>
</div>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
