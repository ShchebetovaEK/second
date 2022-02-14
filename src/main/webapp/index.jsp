<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:message key="index.title" var="title"/>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<jsp:forward page="/jsp/main/signIn.jsp"></jsp:forward>
</body>
</html>