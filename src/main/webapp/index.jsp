<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon-instagram" href="img/favicon.ico">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fontello.css">
    <link rel="stylesheet" href="css/style.css">
    <title>MC FORESTMED</title>
</head>
<body>
<header>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h1><%= "Welcome to \"ForestMed\" " %></h1>
                <h1 class="text-success text-center"> Welcome to FoRestMeD! </h1>
                <p>Today <%= new java.util.Date() %></p>
                <br/>
                <h3 class="text-center text-danger"><%= "Please, input your login and password :" %></h3>
                <br/>
                login:  <input type="email" name="email">
                <br/>
                password   <input type="password" name="password" minlength="6">
                <input type="button" value="push">
                <br/>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Email address</label>
                    <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
                </div>
                <br/>

            </div>
        </div>
        <a href="main-servlet">Hello Servlet</a>

        <form class="row g-3 needs-validation" novalidate>
            <div class="col-md-4">
                <label for="validationCustom01" class="form-label">First name</label>
                <input type="text" class="form-control" id="validationCustom01" value="Mark" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="col-md-4">
                <label for="validationCustom02" class="form-label">Last name</label>
                <input type="text" class="form-control" id="validationCustom02" value="Otto" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="col-md-4">
                <label for="validationCustomUsername" class="form-label">address</label>
                <div class="input-group">
                    <span class="input-group-text" id="inputGroupPrepend">@</span>
                    <input type="text" class="form-control" id="validationCustomUsername" aria-describedby="inputGroupPrepend" required>
                    <div class="invalid-feedback">
                        Please choose address
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <label for="validationCustom03" class="form-label">date</label>
                <input type="text" class="form-control" id="validationCustom03" required>
                <div class="invalid-feedback">
                    Please provide a valid date.
                </div>
            </div>
            <div class="col-md-3">
                <label for="validationCustom04" class="form-label">State</label>
                <select class="form-select" id="validationCustom04" required>
                    <option selected disabled value="">Choose...</option>
                    <option>...</option>
                </select>
                <div class="invalid-feedback">
                    Please select a valid state.
                </div>
            </div>
            <div class="col-12">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                    <label class="form-check-label" for="invalidCheck">
                        Agree to terms and conditions
                    </label>
                    <div class="invalid-feedback">
                        You must agree before submitting.
                    </div>
                </div>
            </div>
            <div class="col-12">
                <button class="btn btn-primary" type="submit">Submit form</button>
            </div>
        </form>
        <br/>
        <button type="button" class="btn btn-primary">Primary</button>
        <button type="button" class="btn btn-secondary">Secondary</button>
        <button type="button" class="btn btn-success">Success</button>
        <button type="button" class="btn btn-danger">Danger</button>
        <button type="button" class="btn btn-warning">Warning</button>
        <button type="button" class="btn btn-info">Info</button>
        <button type="button" class="btn btn-light">Light</button>
        <button type="button" class="btn btn-dark">Dark</button>
        <button type="button" class="btn btn-link">Link</button>
        <a href="#footer" class="table"></a>
    </div>
</header>
<footer>

</footer>
<script src="js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>