<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ page import="org.apache.commons.lang3" %>--%>
<%--String str=request.getParameter("urlParam");--%>
<%--String safeOutput = StringEscapeUtils.escapeXml(str);--%>
<!DOCTYPE html>
<html>
<head>
    <title>MC FORESTMED</title>
</head>
<body>
<%--<h1> please registration </h1>--%>

<%--<form action="jsp/main/registration.jsp">--%>
<%--    <input type="submit" value="Registration"/>--%>
<%--</form>--%>


<%--<form action="jsp/main/welcome.jsp">--%>
<%--    <input type="submit" value="welcome"/>--%>
<%--</form>--%>
<%----%>

<form action="jsp/main/user_manager.jsp">
    <input type="submit" value="user_manager"/>
</form>

<form action="jsp/main/adminRegistration.jsp">
    <input type="submit" value="adminRegistration"/>
</form>

<form action="jsp/main/doctorRegistration.jsp">
    <input type="submit" value="doctorRegistration"/>
</form>
<%----%>
<%--<form action="jsp/main/admin.jsp">--%>
<%--    <input type="submit" value="doctor"/>--%>
<%--</form>--%>

<%--<form action="jsp/main/admin.jsp">--%>
<%--    <input type="submit" value="patients"/>--%>
<%--</form>--%>

<%--<form action="jsp/main/select.jsp">--%>
<%--    <input type="submit" value="select"/>--%>
<%--</form>--%>



<form action="jsp/main/main.jsp">
    <input type="submit" value="main"/>
</form>


<form action="jsp/main/login.jsp">
    <input type="submit" value="login"/>
</form>


<form action="jsp/main/update.jsp">
    <input type="submit" value="update_command"/>
</form>
<%--<form action="error400.jsp">--%>
<%--    <input type="submit" value="Registration"/>--%>
<%--</form>--%>


</body>
</html>