<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../imports.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<header>
    <%@include file="../header/header.jsp" %>
</header>
<head>
    <title>Manager Page</title>
</head>
<body>
 <h2> gdfjgkdjg</h2>
<c:forEach items="${requestScope.users}" var="user">
<c:out value="${user.}"
</c:forEach>


 <div class="modal-body">
     <form action="${abs}/controller" method="post" id="manager-form">
         <input type="hidden" name="command" value="registration_command">
         <input type="hidden" name="role" value="manager">
         <div class="form-group">
             <label for="login">${login}</label>
         LOGIN:    <input type="text" id="login" class="form-control" name="login">
         </div>
         <div class="form-group">
             <label for="psw">${password}</label>
           PASSWORD: <input type="password" id="psw" class="form-control" name="password">
         </div>
         <div class="form-group">
             <label for="confirm_psw">${confirm_psw}</label>
           CONFIRM  <input type="password" id="confirm_psw" class="form-control" name="confirm_password">
         </div>
         <div class="form-group">
             <label for="first_name">${first_name}</label>
           Firstname:  <input type="text" id="first_name" class="form-control" name="first_name">
         </div>
         <div class="form-group">
             <label for="last_name">${last_name}</label>
           lastname:  <input type="text" id="last_name" class="form-control" name="last_name">
         </div>
         <div class="form-group">
             <label for="address">${address}</label>
          address:   <input type="text" id="address" class="form-control" name="address">
         </div>
         <div class="form-group">
             <label for="data_birthday">${data_birthday}</label>
         data:    <input type="text" id="data_birthday" class="form-control" name="data_birthday">
         </div>
         <div class="form-group">
             <label for="phone_number">${phone_number}</label>
        phone:     <input type="text" id="phone_number" class="form-control" name="phone_number">
         </div>
         <div class="form-group">
             <label for="email">${email}</label>
          email:   <input type="email" id="email" class="form-control" name="email">
         </div>
     </form>
 </div>

 <table>
     <tr>
         <th>id</th>
         <th>role</th>
         <th>login</th>
         <th>first name</th>
         <th>last name</th>
         <th>address</th>
         <th>email</th>
         <th>phone number </th>
         <th>data</th>

     </tr>

     <c:forEach items="${requestScope.users}" var="user">
         <tr>
             <td>${user.id}</td>
             <td>${user.role}</td>
             <td>${user.first_name}</td>
             <td>${user.last_name}</td>
             <td>${user.address}</td>
             <td>${user.email}</td>
             <td>${user.phone_number}</td>
             <td>${user.data_birthday}</td>
         </tr>
     </c:forEach>

 </table>
 </body>
</html>
