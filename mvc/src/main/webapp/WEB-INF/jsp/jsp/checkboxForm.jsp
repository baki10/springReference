<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Checkbox</title>
</head>
<body>
<form:form modelAttribute="preferences">
  <table>
    <tr>
      <td>Subscribe to newsletter?:</td>
        <%-- Approach 1: Property is of type java.lang.Boolean --%>
      <td><form:checkbox path="receiveNewsletter"/></td>
    </tr>
    <tr>
      <td>Interests:</td>
        <%-- Approach 2: Property is of an array or of type java.util.Collection --%>
      <td>
        <%--<form:checkboxes path="preferences.interests" items="${interestList}"/>--%>
        Soccer: <form:checkbox path="interests" value="Soccer"/>
        Biathlon: <form:checkbox path="interests" value="Biathlon"/>
        Poker: <form:checkbox path="interests" value="Poker"/>
      </td>
    </tr>
    <tr>
      <td>Favourite Word:</td>
        <%-- Approach 3: Property is of type java.lang.Object --%>
      <td>
        Magic: <form:checkbox path="favouriteWord" value="Magic"/>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Save Changes"/>
      </td>
    </tr>
  </table>
  <div>
    <a href="<c:url value="/jspSample"/> ">Back</a>
  </div>
</form:form>
</body>
</html>