<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app="myApp">
<head>
    <title>Angular REST</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
    <script src="<c:url value='/resources/js/app.js' />"></script>
    <script src="<c:url value='/resources/js/service/player_service.js' />"></script>
    <script src="<c:url value='/resources/js/controller/player_controller.js' />"></script>

    <style>
        .firstName.ng-valid {
            background-color: lightgreen;
        }

        .firstName.ng-dirty.ng-invalid-required {
            background-color: red;
        }

        .firstName.ng-dirty.ng-invalid-minlength {
            background-color: yellow;
        }

    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body ng-app="myApp" class="ng-cloak">

<div class="generic-container" ng-controller="PlayerController as ctrl">

    <div class="panel panel-default">

        <div class="panel-heading"><span class="lead">Player Registration Form </span></div>
        <div style="margin: 20px" class="formcontainer">
            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">

                <input type="hidden" ng-model="ctrl.player.id"/>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="uname">Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.player.firstName" id="uname" name="uname"
                                   class="firstName form-control input-sm" placeholder="Enter your name" required
                                   ng-minlength="3"/>
                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="lastName">Last name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.player.lastName" id="lastName"
                                   class="form-control input-sm"
                                   placeholder="Enter your lastName"/>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="number">Number</label>
                        <div class="col-md-7">
                            <input type="number" ng-model="ctrl.player.number" id="number"
                                   class="form-control input-sm"
                                   placeholder="Enter number"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <input type="submit" value="{{!ctrl.player.id ? 'Add Player' : 'Update Player'}}"
                               class="btn btn-primary btn-sm"
                               ng-disabled="myForm.$invalid">
                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm"
                                ng-disabled="myForm.$pristine">
                            Reset Form
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Players </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th width="20%">ID</th>
                    <th width="20%">Name</th>
                    <th width="20%">lastName</th>
                    <th width="20%">Number</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in ctrl.players | orderBy:'id'">
                    <td><span ng-bind="u.id"></span></td>
                    <td><span ng-bind="u.firstName"></span></td>
                    <td><span ng-bind="u.lastName"></span></td>
                    <td><span ng-bind="u.number"></span></td>
                    <td>
                        <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">
                            Edit
                        </button>
                        <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">
                            Remove
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>