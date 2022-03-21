<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="choose.title" var="title"/>
<fmt:message key="choose.message" var="message"/>
<fmt:message key="choose.message1" var="message1"/>
<fmt:message key="choose.message4" var="message4"/>
<fmt:message key="choose.message5" var="message5"/>
<fmt:message key="choose.message6" var="message6"/>
<fmt:message key="choose.message7" var="message7"/>
<fmt:message key="choose.message8" var="message8"/>
<fmt:message key="choose.message9" var="message9"/>
<fmt:message key="choose.message10" var="message10"/>
<fmt:message key="choose.doctorId" var="doctorId"/>
<fmt:message key="choose.firstName" var="firstName"/>
<fmt:message key="choose.lastName" var="lastName"/>
<fmt:message key="choose.category" var="category"/>
<fmt:message key="choose.speciality" var="speciality"/>
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
<div class="text-center">
<form action="${abs}/controller" method="get">

    <input type="hidden" name="command" value="patient_view_all_doctor_command">
    <h6 class="text-center text-black"> ${user.firstName},${message}</h6>
      <input type="submit" >
</form>
<br/>
<%--<form action="${abs}/controller" method="get">--%>
<%--    <h6> ${user.firstName}${message1}</h6>--%>
<%--    <input type="hidden" name="command" value="patient_choose_doctor_command">--%>
<%--   <label class="form-label">${message4} </label>--%>
<%--    <input type="text" name="speciality" value="PEDIATRICS" required pattern="(([A-z]){5,16})|(S|s)|(GY|gy)" placeholder="PEDIATRICS">--%>
<%--    <input type="submit" >--%>
<%--</form>--%>
    <br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="patient_choose_doctor_command">
        <label class="form-label">${message4}</label>
<%--        <label for="speciality">Choose a speciality:</label>--%>
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
        <input type="submit" >
    </form>

<table class="table table-hover">
    <tr>
        <th scope="col">${doctorid}</th>
        <th scope="col">${firstName}</th>
        <th scope="col">${lastName}</th>
        <th scope="col">${category}</th>
        <th scope="col">${speciality}</th>

    </tr>

    <c:forEach items="${users}" var="user">

        <tr>
            <td >${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>


            <c:if test="${doctor}">
                <td> ${user.category}</td>
                <td> ${user.speciality}</td>
            </c:if>

        </tr>
    </c:forEach>

</table>

    <br/>
<form action="${abs}/controller" method="get">
    <h6 class="text-center text-black"> ${user.firstName} ${message5}</h6>
    <input type="hidden" name="command" value="patient_take_protocol_command">
    <label  class="form-label"> ${message6}</label>
    <input type="text" name="users_id"  required pattern="([0-9]{1,10})" placeholder="doctor id" >
    <label class="form-label"> ${message7}</label>
    <input type="date" name="protocol_data"  required pattern="\d{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])">
    <label class="form-label" >${message8}</label>
<%--      <input type="text" name="protocol_payer" value="patient" pattern="(?i)(insurance)|(patient)" required placeholder="patient">--%>
    <select name="protocol_payer" id="payer">
        <option value="patient">patient</option>
<%--        ${ }--%>
        <option value="insurance">insurance</option>
<%--        ${}--%>
    </select>

    <br><br>
    <input type="submit"  value="send">
</form>
    <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/patient/viewMyProtocol.jsp"
       role="button">${message9} ${user.firstName} ${message10}</a>

</div>
<footer><div class="text-center"> <ctg:footer/> </div></footer>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>