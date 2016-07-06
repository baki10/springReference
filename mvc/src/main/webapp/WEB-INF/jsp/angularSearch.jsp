<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Angular Search</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
    <script src="<c:url value="/resources/js/search.js" />"></script>
</head>
<body>
    <div ng-app="myApp" ng-controller="namesCtrl">

        <p>Type a letter in the input field:</p>

        <p><input type="text" ng-model="test"></p>

        <ul>
            <li ng-repeat="x in names | filter:test">
                {{ x }}
            </li>
        </ul>

    </div>
</body>
</html>