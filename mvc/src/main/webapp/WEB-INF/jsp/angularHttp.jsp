<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app="myApp">
<head>
    <title>Angular HTTP</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>

    <link rel="stylesheet" href="<c:url value="/resources/css/table.css"/>">
</head>
<body>
    <div ng-controller="customersCtrl">

    <table>
        <caption>Table from JSON string</caption>
        <tr ng-repeat="x in myData | orderBy:'Country'">
            <td>{{ $index + 1 }}</td>
            <td>{{ x.Name }}</td>
            <td>{{ x.Country | uppercase}}</td>
        </tr>
    </table>

    </div>

    <br>
    <div ng-controller="sqlController">

    <table>
        <caption>Table from database(as JSON objects)</caption>
        <tr ng-repeat="x in players | orderBy:'firstName'">
            <td>{{ $index + 1 }}</td>
            <td>{{ x.firstName }}</td>
            <td>{{ x.lastName | uppercase}}</td>
        </tr>
    </table>

    </div>

    <script>
    var app = angular.module('myApp', []);
    app.controller('customersCtrl', function($scope, $http) {
        $http.get("<c:url value="/rest/customers" />").then(function(response) {
            $scope.myData = response.data.records;
        });
    });
    app.controller('sqlController', function($scope, $http) {
        $http.get("<c:url value="/rest/player" />").then(function(response) {
            $scope.players = response.data;
        });

    });
    </script>
</body>
</html>