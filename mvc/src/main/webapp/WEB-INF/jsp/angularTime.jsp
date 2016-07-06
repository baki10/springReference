<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Angular Time</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
</head>
<body>
    <div ng-app="myApp" ng-controller="myCtrl">

    <p>The time is:</p>

    <h1>{{theTime}}</h1>

    </div>

    <p>The $interval service runs a function every specified millisecond.</p>

    <script>
    var app = angular.module('myApp', []);
    app.controller('myCtrl', function($scope, $interval) {
      $scope.theTime = new Date().toLocaleTimeString();
      $interval(function () {
          $scope.theTime = new Date().toLocaleTimeString();
      }, 1000);
    });
    </script>

    </body>
</body>
</html>