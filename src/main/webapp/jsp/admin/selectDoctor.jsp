<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="selectdoctor.title" var="title" />
<fmt:message key="selectdoctor.message1" var="message1" />
<fmt:message key="selectdoctor.message2" var="message2" />
<fmt:message key="selectdoctor.message3" var="message3" />
<fmt:message key="selectdoctor.message4" var="message4" />
<fmt:message key="selectdoctor.back1" var="back1" />
<fmt:message key="selectdoctor.back2" var="back2" />
<fmt:message key="selectdoctor.back3" var="back3" />
<fmt:message key="selectdoctor.back4" var="back4" />
<fmt:message key="selectdoctor.id" var="id"/>
<fmt:message key="selectdoctor.role" var="role"/>
<fmt:message key="selectdoctor.login" var="login"/>
<fmt:message key="selectdoctor.firstName" var="firstName"/>
<fmt:message key="selectdoctor.lastName" var="lastName"/>
<fmt:message key="selectdoctor.address" var="address"/>
<fmt:message key="selectdoctor.email" var="email"/>
<fmt:message key="selectdoctor.phoneNumber" var="phoneNumber"/>
<fmt:message key="selectdoctor.databirthday" var="dataBirthday"/>
<fmt:message key="selectdoctor.archiv" var="archiv"/>
<fmt:message key="selectdoctor.category" var="category"/>
<fmt:message key="selectdoctor.speciality" var="speciality"/>
<fmt:message key="selectdoctor.categoryfirst" var="first"/>
<fmt:message key="selectdoctor.categoryhigh" var="high"/>
<fmt:message key="selectdoctor.categorysecond" var="second"/>
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
<div class="text-center">
<form action="${abs}/controller" method="get">
    <label class="form-label">${message1} </label>
    <input type="hidden" name="command" value="admin_take_all_doctors_command">
    <input type="submit" value="submit">
</form>

<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_doctors_by_category_command">
 <label class="form-label">${message2} </label>
    <label><input type="radio" name="category" value="second">second</label>
    <label><input type="radio" name="category" value="high">high</label>
    <label><input type="radio" name="category" value="first">first</label>
    <input type="submit" value="submit" >
</form>

    <form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_doctors_by_speciality_command">
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
        </select>
        <br><br>
    <input type="submit" value="submit" >
</form>

<table class="table text-danger">
    <tr>
        <th scope="col">${id}</th>
        <th scope="col">${role}</th>
        <th scope="col">${login}</th>
        <th scope="col">${firstName} </th>
        <th scope="col">${lastName} </th>
        <th scope="col">${address}</th>
        <th scope="col">${email}</th>
        <th scope="col">${phoneNumber}</th>
        <th scope="col">${dataBirthday}</th>
        <th scope="col">${archiv}</th>
        <th scope="col">${category}</th>
        <th scope="col"> ${speciality}</th>
    </tr>

    <c:forEach items="${users}" var="user">

        <tr>
            <td>${user.id}</td>
            <td>${user.role}</td>
            <td>${user.login}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.address}</td>
            <td>${user.email}</td>
            <td>${user.phoneNumber}</td>
            <td>${user.dataBirthday}</td>
            <td>${user.archiv}</td>

              <c:if test="${doctor_req}">
                  <td> ${user.category}</td>
                <td> ${user.speciality}</td>
            </c:if>

        </tr>
    </c:forEach>

</table>
    <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/main/user_manager.jsp"
       role="button">${back1}</a>
    <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/select.jsp"
       role="button">${back2}</a>
    <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/selectDoctor.jsp"
       role="button">${back3}</a>
    <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/admin/selectPatient.jsp"
       role="button">${back4}</a>
</div>
<a href="#header" class="btn-lg btn-danger">UP</a>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>