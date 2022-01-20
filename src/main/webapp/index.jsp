<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fontello.css">
        <link rel="stylesheet" href="css/style.css">
    <title>MC FORESTMED</title>
</head>
<body>
<label for="password">${psw}</label><br/>
<input type="password" id="password" class="form-control" name="password" placeholder="${psw}">
<c:if test="${invalid_passport eq 'invalid_message'}"><div id="message2"><b>${invalid_psw_message}</b></div></c:if>
<br/><br/>
<li><a href="${abs}/controller?command=change_locale_command">${nigiri_option}</a></li>
<h3 class="text-center text-danger"><%= "Please, input your login and password :" %>
</h3>
<br/>
<span class="border border-warning"></span>
login: <input type="email" name="email">
<br/>
password <input type="password" name="password" minlength="6">
<input type="button" value="push">
<br/>
    <script src="js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
</body>
</html>