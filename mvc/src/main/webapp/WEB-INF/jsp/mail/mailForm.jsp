<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Mail form</title>
</head>
<body>
<form:form modelAttribute="message">
  <table>
    <tr>
      <td>Name:</td>
      <td><form:input path="customerName"/></td>
    </tr>
    <tr>
      <td>To:</td>
      <td><form:input path="customerEmailAddress" type="email"/></td>
    </tr>
    <tr>
      <td>Text:</td>
      <td><form:textarea path="text" rows="3" cols="20"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Send mail"/>
      </td>
    </tr>
  </table>
</form:form>

<c:url value="/logout" var="logoutUrl"/>
<form id="logout" action="${logoutUrl}" method="post">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<a href="javascript:document.getElementById('logout').submit()">Logout</a>
</body>
</html>