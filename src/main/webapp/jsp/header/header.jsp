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
<fmt:message key="selectdoctor.THERAPY" var="THERAPY"/>
<fmt:message key="selectdoctor.PEDIATRICS" var="PEDIATRICS"/>
<fmt:message key="selectdoctor.SURGERY" var="SURGERY"/>
<fmt:message key="selectdoctor.DENTISTRY" var="DENTISTRY"/>
<fmt:message key="selectdoctor.NEUROLOGY" var="NEUROLOGY"/>
<fmt:message key="selectdoctor.CARDIOLOGY" var="CARDIOLOGY"/>
<fmt:message key="selectdoctor.OTOLARYNGOLOGY" var="OTOLARYNGOLOGY"/>
<fmt:message key="selectdoctor.OPHTHALMOLOGY" var="OPHTHALMOLOGY"/>
<fmt:message key="selectdoctor.GASTROENTEROLOGY" var="GASTROENTEROLOGY"/>
<fmt:message key="selectdoctor.PULMONOLOGY" var="PULMONOLOGY"/>
<fmt:message key="selectdoctor.ALLERGOLOGY" var="ALLERGOLOGY"/>
<fmt:message key="selectdoctor.DERMATOLOGY" var="DERMATOLOGY"/>
<fmt:message key="selectdoctor.GYNECOLOGY" var="GYNECOLOGY"/>
<fmt:message key="selectdoctor.UROLOGY" var="UROLOGY"/>
<fmt:message key="selectdoctor.ONCOLOGY" var="ONCOLOGY"/>
<fmt:message key="selectdoctor.PSYCHIATRY" var="PSYCHIATRY"/>
<fmt:message key="selectdoctor.IMMUNOLOGY" var="IMMUNOLOGY"/>
<fmt:message key="selectdoctor.ENDOCRINOLOGY" var="ENDOCRINOLOGY"/>
<fmt:message key="selectdoctor.NEPHROLOGY" var="NEPHROLOGY"/>
<fmt:message key="selectdoctor.ORTHOPEDICS" var="ORTHOPEDICS"/>
<fmt:message key="selectdoctor.TRAUMATOLOGY" var="TRAUMATOLOGY"/>

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

<%--            <li class="nav-item">--%>
<%--                <a class="nav-link"--%>
<%--                   href="${pageContext.request.contextPath}/controller?command=go_to_price_command">${price}</a>--%>
<%--            </li>--%>

            <li class="nav-item">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/controller?command=go_to_registration_page">${registration}</a>
            </li>

<%--            <li class="nav-item">--%>
<%--                <a class="nav-link"--%>
<%--                   href="${pageContext.request.contextPath}/controller?command=log_in_command">${login}</a>--%>
<%--            </li>--%>

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
<%--                <input class="form-control mr-2" type="text" name="last_name">--%>
<%--                <input class="form-control mr-2" type="text" name="speciality">--%>
<%--                <input type="hidden" name="command" value="search_by_last_name_command"--%>
                <input type="hidden" name="command" value="search_by_speciality_command">
    <select name="speciality" id="speciality">
        <option value="THERAPY">${THERAPY}</option>
        <option value="PEDIATRICS">${PEDIATRICS}</option>
        <option value="SURGERY">${SURGERY}</option>
        <option value="DENTISTRY">${DENTISTRY}</option>
        <option value="NEUROLOGY">${NEUROLOGY}</option>
        <option value="CARDIOLOGY">${CARDIOLOGY}</option>
        <option value="OTOLARYNGOLOGY">${OTOLARYNGOLOGY}</option>
        <option value="OPHTHALMOLOGY">${OPHTHALMOLOGY}</option>
        <option value="GASTROENTEROLOGY">${GASTROENTEROLOGY}</option>
        <option value="PULMONOLOGY">${PULMONOLOGY}</option>
        <option value="ALLERGOLOGY">${ALLERGOLOGY}</option>
        <option value="DERMATOLOGY">${DERMATOLOGY}</option>
        <option value="GYNECOLOGY">${GYNECOLOGY}</option>
        <option value="UROLOGY">${UROLOGY}</option>
        <option value="ONCOLOGY">${ONCOLOGY}</option>
        <option value="PSYCHIATRY">${PSYCHIATRY}</option>
        <option value="IMMUNOLOGY">${IMMUNOLOGY}</option>
        <option value="ENDOCRINOLOGY">${ENDOCRINOLOGY}</option>
        <option value="NEPHROLOGY">${NEPHROLOGY}</option>
        <option value="ORTHOPEDICS">${ORTHOPEDICS}</option>
        <option value="TRAUMATOLOGY">${TRAUMATOLOGY}</option>
    </select>

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
