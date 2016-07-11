<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
  <title>Products</title>
</head>
<body>
<section>
  <div class="jumbotron">
    <div class="container">
      <h1>Products</h1>
      <p>Add products</p>
    </div>
  </div>
</section>
<div class="container">
  <div class="row">
    <div class="col-md-4 col-md-offset-4">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">Please sign in</h3>
        </div>
        <div class="panel-body">
          <c:if test="${not empty error}">
            <div class="alert alert-danger">
              Wrong username or password!
            </div>
          </c:if>
          <form action="<c:url value="/login"></c:url>" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <fieldset>
              <div class="form-group">
                <input class="form-control" placeholder=
                    "User Name" name='username' type="text">
              </div>
              <div class="form-group">
                <input class="form-control" placeholder=
                    "Password" name='password' type=
                           "password" value="">
              </div>
              <input class="btn btn-lg btn-success btn-block"
                     type="submit" value="Login">
            </fieldset>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>