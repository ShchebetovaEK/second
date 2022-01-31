<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../imports.jspf" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="../../img/png-transparent-graphy-logo-tree-leaf-branch-logo.png" type="image/x-icon">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/fontello.css">
    <title>error 404</title>
</head>
<body>

<img src='<%=request.getContextPath() %>/img/error2.jpeg'/>

<%--<div style="font-size: 24px">Request from ${pageContext.errorData.requestURI} is failed</div><br/>--%>
<%--<div style="font-size: 20px">Servlet name: ${pageContext.errorData.servletName} </div><br/>--%>
<%--<hr/>--%>
<%--<div style="font-size: 14px">Exception: ${pageContext.exception}</div><br/>--%>
<%--<hr/>--%>
<%--<div style="font-size: 14px">Message from exception: ${pageContext.exception}</div>--%>
<%--<br>--%>
<a href="${pageContext.request.contextPath}/index.jsp">Back to homepage</a>


<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>