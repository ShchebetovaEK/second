<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="updatedoctor.title" var="title"/>
<fmt:message key="updatedoctor.message1" var="message1"/>
<fmt:message key="updatedoctor.message2" var="message2"/>
<fmt:message key="updatedoctor.message3" var="message3"/>
<fmt:message key="updatedoctor.message4" var="message4"/>
<fmt:message key="updatedoctor.back1" var="back1"/>
<fmt:message key="updatedoctor.categoryfirst" var="first"/>
<fmt:message key="updatedoctor.categoryhigh" var="high"/>
<fmt:message key="updatedoctor.categorysecond" var="second"/>
<fmt:message key="updatedoctor.THERAPY" var="THERAPY"/>
<fmt:message key="updatedoctor.PEDIATRICS" var="PEDIATRICS"/>
<fmt:message key="updatedoctor.SURGERY" var="SURGERY"/>
<fmt:message key="updatedoctor.DENTISTRY" var="DENTISTRY"/>
<fmt:message key="updatedoctor.NEUROLOGY" var="NEUROLOGY"/>
<fmt:message key="updatedoctor.CARDIOLOGY" var="CARDIOLOGY"/>
<fmt:message key="updatedoctor.OTOLARYNGOLOGY" var="OTOLARYNGOLOGY"/>
<fmt:message key="updatedoctor.OPHTHALMOLOGY" var="OPHTHALMOLOGY"/>
<fmt:message key="updatedoctor.GASTROENTEROLOGY" var="GASTROENTEROLOGY"/>
<fmt:message key="updatedoctor.PULMONOLOGY" var="PULMONOLOGY"/>
<fmt:message key="updatedoctor.ALLERGOLOGY" var="ALLERGOLOGY"/>
<fmt:message key="updatedoctor.DERMATOLOGY" var="DERMATOLOGY"/>
<fmt:message key="updatedoctor.GYNECOLOGY" var="GYNECOLOGY"/>
<fmt:message key="updatedoctor.UROLOGY" var="UROLOGY"/>
<fmt:message key="updatedoctor.ONCOLOGY" var="ONCOLOGY"/>
<fmt:message key="updatedoctor.PSYCHIATRY" var="PSYCHIATRY"/>
<fmt:message key="updatedoctor.IMMUNOLOGY" var="IMMUNOLOGY"/>
<fmt:message key="updatedoctor.ENDOCRINOLOGY" var="ENDOCRINOLOGY"/>
<fmt:message key="updatedoctor.NEPHROLOGY" var="NEPHROLOGY"/>
<fmt:message key="updatedoctor.ORTHOPEDICS" var="ORTHOPEDICS"/>
<fmt:message key="updatedoctor.TRAUMATOLOGY" var="TRAUMATOLOGY"/>
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
    <title>${title} </title>
</head>
<body>


        <form action="${abs}/controller" method="get">
            <div class="row align-items-center">
                <div class="row-cols-1">
            <input type="hidden" name="command" value="update_doctor_category_command">
            <label class="form-label"> ${message1}</label>
            <input type="text" required pattern="([0-9]{1,10})" name="users_id">

            <label class="form-label">${message2} </label>
            <label><input type="radio" name="category" value="second">${second}</label>
            <label><input type="radio" name="category" value="high">${high}</label>
            <label><input type="radio" name="category" value="first">${first}</label>
            <input type="submit" value="submit">
                </div>
            </div>
        </form>

        <form action="${abs}/controller" method="get">
            <input type="hidden" name="command" value="update_doctor_speciality_command">
            <div class="row align-items-center">
                <div class="row-cols-3">
            <label class="form-label"> ${message1}</label>
            <input type="text" required pattern="([0-9]{1,10})" name="users_id">


            <label class="form-label">${message4}</label>
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
                <input type="submit" value="submit">
            </select>
                </div>
            </div>
        </form>

<a class="btn btn-success" href="${abs}/jsp/admin/update.jsp"
   role="button">${back1}</a>

<a href="#header" class="btn-lg btn-danger">UP</a>
<footer>
    <div class="text-center"><ctg:footer/></div>
</footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
