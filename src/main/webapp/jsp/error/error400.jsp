<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="error400.title" var="title"/>
<fmt:message key="error400.back" var="back"/>
<html>
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
    <img src='<%=request.getContextPath() %>/img/error2.jpeg'/>
    <a href="${pageContext.request.contextPath}/index.jsp">${back}</a>
</div>


<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
