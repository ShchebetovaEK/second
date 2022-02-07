<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>choose Doctor</title>
</head>
<body>

<form action="${abs}/controller" method="get">

    <input type="hidden" name="command" value="admin_take_all_doctors_command">
    <h2> view all doctors</h2>     <input type="submit" >
</form>

<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="patient_choose_doctor_command">
   <label class="form-label"> please, input desired category: </label>
    <input type="text" name="category" value="HIGH" placeholder="HIGH" >
  <label class="form-label">please, input desired experience: </label>
    <input type="text" name="experience" value="FIVE_YEARS" placeholder="FIVE_YEARS">
   <label class="form-label">please, input desired speciality: </label>
    <input type="text" name="speciality" value="PEDIATRICS" placeholder="PEDIATRICS">
    <input type="submit" >
</form>

<table class="table table-hover">
    <tr>
        <th scope="col">doctor's id</th>
        <th scope="col">first name</th>
        <th scope="col">last name</th>
        <th scope="col">category</th>
        <th scope="col">experience</th>
        <th scope="col">speciality</th>

    </tr>

    <c:forEach items="${users}" var="user">

        <tr>
            <td >${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>


            <c:if test="${doctor}">
                <td> ${user.category}</td>
                <td> ${user.experience}</td>
                <td> ${user.speciality}</td>
            </c:if>

        </tr>
    </c:forEach>

</table>


<form action="${abs}/controller" method="get">
    <input type="hidden" name="command" value="patient_take_protocol_command">
<%--    please, input doctor first name: <input type="text" name="first_name" value="Антонина" placeholder="Антонина" >--%>
<%--    please, input doctor last name: <input type="text" name="last_name" value="Нестерович" placeholder="Нестерович" >--%>
    <label  class="form-label"> please, input desired doctors id:</label>
    <input type="text" name="users_id" value="" placeholder="doctor id" >
    <label class="form-label"> please, input desired protocol data:</label>
    <input type="date" name="protocol_data"  >
    <label class="form-label" >please, input desired protocol payer:</label>
    <input type="text" name="protocol_payer" value="patient" placeholder="patient">

    <input type="submit" >
</form>


<a href="${pageContext.request.contextPath}/jsp/patient/chooseDoctor.jsp">Back to choose doctor page</a>

<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>