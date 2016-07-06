<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello world</title>
    <script src="<c:url value="/resources/js/menuScript.js" />"></script>
</head>
<body>
${message}
<hr/>
<script>
    addButton();
</script>
<div id="menuList"></div>
<hr/>
<ul>
    <li>
        <a href="oop">OOP</a>
    </li>
    <li>
        <a href="<c:url value="/aquarium" />">Aquarium</a>
    </li>
    <li>
        <a href="lesson4">Zamyikaniya</a>
    </li>
    <li>
        <a href="lesson5">AJAX</a>
    </li>
    <li>
        <a href="angularPage">Angular</a>
    </li>
    <li>
        <a href="errorPage">NPE</a>
    </li>
    <li>
        <a href="errorPage404">404</a>
    </li>
</ul>
</body>
</html>