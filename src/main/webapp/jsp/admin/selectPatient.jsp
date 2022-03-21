<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:message key="selectpatient.title" var="title" />
<fmt:message key="selectpatient.message1" var="message1" />
<fmt:message key="selectpatient.message2" var="message2" />
<fmt:message key="selectpatient.message3" var="message3" />
<fmt:message key="selectpatient.message4" var="message4" />
<fmt:message key="selectpatient.back1" var="back1" />
<fmt:message key="selectpatient.back2" var="back2" />
<fmt:message key="selectpatient.back3" var="back3" />
<fmt:message key="selectpatient.back4" var="back4" />
<fmt:message key="selectpatient.id" var="id"/>
<fmt:message key="selectpatient.role" var="role"/>
<fmt:message key="selectpatient.login" var="login"/>
<fmt:message key="selectpatient.firstName" var="firstName"/>
<fmt:message key="selectpatient.lastName" var="lastName"/>
<fmt:message key="selectpatient.address" var="address"/>
<fmt:message key="selectpatient.email" var="email"/>
<fmt:message key="selectpatient.phoneNumber" var="phoneNumber"/>
<fmt:message key="selectpatient.databirthday" var="dataBirthday"/>
<fmt:message key="selectpatient.archiv" var="archiv"/>
<fmt:message key="selectpatient.discount" var="discount"/>
<fmt:message key="selectpatient.insurance" var="insurance"/>
<fmt:message key="selectpatient.moneyAccount" var="moneyAccount"/>
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
    <title>${title}</title>
</head>
<div class="text-center">
<form action="${abs}/controller" method="get">
    <label class="form-label">${message1}</label>
    <input type="hidden" name="command" required value="admin_take_all_patients_command">
    <input type="submit"  >
</form>
<br/>
<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_all_patients_by_insurance_command">
   <label>${message2}</label>
    <input type="text" name="insurance" required pattern="(?i)(true|false)" >
    <input type="submit" >
</form>
<br/>
<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="admin_take_all_patients_by_discount_command">
    <label>${message3}</label>
    <input type="text" name="discount" value="5" required pattern="[0-9]{1,2}" >
    <input type="submit" >
</form>
<br/>
    <form action="${abs}/controller" method="get">
        <input type="hidden" name="command" value="admin_take_patients_by_balance_range_command">
        <label>${message3}</label>
        <input type="text" name="first_range"  required pattern="[0-9]{1,5}" >
        <input type="text" name="second_range"  required pattern="[0-9]{1,5}" >
        <input type="submit" >
    </form>

<table class="table text-primary">
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
        <th scope="col">${insurance}</th>
        <th scope="col">${moneyAccount}</th>
        <th scope="col">${discount}</th>

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


            <c:if test="${patient_req}">
                <td> ${user.insurance}</td>
                <td> ${user.moneyAccount}</td>
                <td> ${user.discount}</td>
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