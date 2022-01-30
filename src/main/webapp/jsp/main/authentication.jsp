<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${authentication_result eq 'false'}"><div class="alert alert-warning" id="message"><b class="invalid_message">${invalid_message}</b></div></c:when>
    <c:when test="${authentication_result eq 'true'}"><div class="alert alert-success" id="message"><b class="valid_message">${valid_message} ${user.login}</b></div></c:when>
</c:choose>
</body>
</html>
