<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Angular Search</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
    <script src="<c:url value="/resources/js/sortNamesCtrl.js" />"></script>
</head>
<body>
    <div ng-app="myApp" ng-controller="namesCtrl">

    <table border="1" width="100%">
        <tr>
            <th ng-click="orderByMe('name')">Name</th>
            <th ng-click="orderByMe('country')">Country</th>
        </tr>
        <tr ng-repeat="x in names | orderBy:myOrderBy">
            <td>{{x.name}}</td>
            <td>{{x.country}}</td>
        </tr>
    </table>

    </div>
</body>
</html>