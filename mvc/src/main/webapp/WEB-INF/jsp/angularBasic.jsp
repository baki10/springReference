<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Angular</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
</head>
<body>
<div ng-app="myApp" ng-controller="myCtrl" ng-init="myColor='aqua'">
    <label>Name:</label>
    <input type="text" ng-model="yourName" placeholder="Enter a name here">
    <hr>
    <h2>Hello {{yourName | uppercase}}!</h2>
    <hr>
    <input style="background-color:{{myColor}}" ng-model="myColor" value="{{myColor}}">
    <hr>
    <w3-test-directive></w3-test-directive>
    <hr>
    <h1>Price: {{ price | currency }}</h1>
    <hr>
    <p>Select a car:</p>
    <select ng-model="selectedCar" ng-options="y.brand for (x, y) in cars">
    </select>

    <h1>You selected: {{selectedCar.brand}}</h1>
    <h2>Model: {{selectedCar.model}}</h2>
    <h3>Color: {{selectedCar.color}}</h3>
    <hr>
    <p>
        <button ng-disabled="mySwitch">Click Me!</button>
    <p ng-show="mySwitch">I am ng-show.</p>
    <p ng-hide="!mySwitch">I am ng-hide.</p>
    </p>
    <p>
       <input type="checkbox" ng-model="mySwitch"/>Disable
    </p>
    <hr>
    <h1 ng-mousemove="count = count + 1">Mouse Over Me!</h1>
    <button ng-click="myFunction()">Click me!</button>
    <h2>{{ count }}</h2>
    <hr>
    <h1 ng-mousemove="myFunc($event)">Mouse Over Me!</h1>
    <p>Coordinates: {{x1 + ', ' + y1}}</p>
    <hr>

    <form>
        Pick a topic:
        <input type="radio" ng-model="myVar" value="dogs">Dogs
        <input type="radio" ng-model="myVar" value="tuts">Tutorials
        <input type="radio" ng-model="myVar" value="cars">Cars
    </form>
    <form>
        Select a topic:
        <select ng-model="myVar">
            <option value="">
            <option value="dogs">Dogs
            <option value="tuts">Tutorials
            <option value="cars">Cars
        </select>
    </form>

    <div ng-switch="myVar">
        <div ng-switch-when="dogs">
            <h1>Dogs</h1>
            <p>Welcome to a world of dogs.</p>
        </div>
        <div ng-switch-when="tuts">
            <h1>Tutorials</h1>
            <p>Learn from examples.</p>
        </div>
        <div ng-switch-when="cars">
            <h1>Cars</h1>
            <p>Read about cars.</p>
        </div>
    </div>

    <!-- start script -->
    <script>
        var app = angular.module("myApp", []);
        app.directive("w3TestDirective", function () {
            return {
                template: "<h1>Made by a directive!</h1>"
            };
        });
        app.controller('myCtrl', function ($scope) {
            $scope.price = 58;
            $scope.cars = {
                car01: {brand: "Ford", model: "Mustang", color: "red"},
                car02: {brand: "Fiat", model: "500", color: "white"},
                car03: {brand: "Volvo", model: "XC90", color: "black"}
            }
            $scope.count = 0;
            $scope.myFunction = function () {
                $scope.count++;
            }
            $scope.myFunc = function (myE) {
                $scope.x1 = myE.clientX;
                $scope.y1 = myE.clientY;
            }
        });
    </script>
    <!-- end script -->

    <hr>
    <form ng-app="app2" name="myForm">
        Email:
        <input type="email" name="myAddress" ng-model="text" placeholder="Enter an email here">
        <span ng-show="myForm.myAddress.$error.email">Not a valid e-mail address</span>
        <h1>Status</h1>
        <p>Valid: {{myForm.myAddress.$valid}} (if true, the value meets all criteria).</p>
        <p>Dirty: {{myForm.myAddress.$dirty}} (if true, the value has been changed).</p>
        <p>Touched: {{myForm.myAddress.$touched}} (if true, the field has been in focus).</p>
    </form>

</div>

</body>
</html>