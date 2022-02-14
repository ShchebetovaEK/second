<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../../imports.jspf" %>
<fmt:message key="header.login" var="login"/>
<fmt:message key="header.logout" var="logout"/>
<fmt:message key="header.main" var="main"/>
<fmt:message key="header.about" var="about"/>
<fmt:message key="header.our" var="our"/>
<fmt:message key="header.choose" var="choose_page"/>
<fmt:message key="header.administ" var="admin_page"/>
<fmt:message key="header.doctor" var="doctor_page"/>
<fmt:message key="header.price" var="price"/>
<fmt:message key="header.registration" var="registration"/>
<fmt:message key="header.search" var="search"/>
<fmt:message key="header.russian" var="ru"/>
<fmt:message key="header.english" var="en"/>
<fmt:message key="header.account" var="account"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="img/png-transparent-graphy-logo-tree-leaf-branch-logo.png" type="image/x-icon">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fontello.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">

            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=go_to_main">${main}</a>
            </li>

            <li class="nav-item active">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/controller?command=go_to_about_page_command">${about}</a>
            </li>

            <li class="nav-item">
                <a class="nav-link "
                   href="${pageContext.request.contextPath}/controller?command=go_to_our_doctors_command">${our}</a>
            </li>

            <li class="nav-item">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/controller?command=go_to_price_command">${price}</a>
            </li>

            <li class="nav-item">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/controller?command=go_to_registration_page">${registration}</a>
            </li>

            <li class="nav-item">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/controller?command=log_in_command">${login}</a>
            </li>

            <li class="nav-item">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/controller?command=log_out_command">${logout}</a>
            </li>

            <c:if test="${patient}">

                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/controller?command=go_to_choose">${choose_page}</a>
                </li>

            </c:if>

            <c:if test="${admin}">

                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/controller?command=go_to_admin_page">${admin_page}</a>
                </li>

            </c:if>
            <c:if test="${doctor}">

                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/controller?command=go_to_doctor_page">${doctor_page}</a>
                </li>

            </c:if>

            <form class="d-flex">
                <input class="form-control mr-2" type="text" name="last_name">
                <input type="hidden" name="command" value="search_by_last_name_command"
                      placeholder="Search by last name" aria-label="Search">
                <button class="btn btn-outline-success"  type="submit">${search}</button>
            </form>

            <li class="nav-item">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/controller?command=account_user_command">${account}</a>
            </li>

            <li class="nav-item">
                <a class="nav-link"
           href="${pageContext.request.contextPath}/controller?command=change_locale&locale=en_US">${en}</a>

            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/controller?command=change_locale&locale=ru_RU">${ru}</a>
            </li>

            <p>Today <%= new java.util.Date() %></p>
        </ul>
    </div>
</nav>
<img src='<%=request.getContextPath() %>/img/forest.jpeg'/>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
