<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>User form</title>
</head>
<body>
<form:form modelAttribute="user">
  <table>
    <tr>
      <td>First Name:</td>
      <td><form:input path="firstName"/></td>
        <%-- Show errors for firstName field --%>
      <td><form:errors path="firstName" cssStyle="color: #ff0000;"/></td>
    </tr>
    <tr>
      <td>Last Name:</td>
      <td><form:input path="lastName"/></td>
      <td><form:errors path="lastName" cssStyle="color: #ff0000;"/></td>
    </tr>
    <tr>
      <td>Email:</td>
      <td><form:input path="email" type="email"/></td>
      <td><form:errors path="email" cssStyle="color: #ff0000;"/></td>
    </tr>
    <tr>
      <td>Sex:</td>
      <td>
          <%--<form:radiobuttons path="sex" items="${sexOptions}"/>--%>
        Male: <form:radiobutton path="sex" value="M"/> <br/>
        Female: <form:radiobutton path="sex" value="F"/>
      </td>
      <td><form:errors path="sex" cssStyle="color: #ff0000;"/></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td>
          <%--<form:password path="password" showPassword="true"/>--%>
        <form:password path="password"/>
      </td>
      <td><form:errors path="password"/></td>
    </tr>
    <tr>
      <td>Country:</td>
      <td>
        <form:select path="country">
          <form:option value="-" label="--Please Select"/>
          <form:options items="${countryList}"/>
        </form:select>
      </td>
      <td><form:errors path="country"/></td>
    </tr>
    <tr>
      <td>Notes:</td>
      <td><form:textarea path="notes" rows="3" cols="20"/></td>
      <td><form:errors path="notes"/></td>
    </tr>
    <tr>
      <td colspan="3">
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