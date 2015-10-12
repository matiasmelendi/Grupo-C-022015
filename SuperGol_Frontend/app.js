var app = angular.module('superGol', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider){
    $routeProvider
        .when('/', {
            templateUrl : 'views/home.html'
        })
        .when("/userhome", {
            templateUrl: "views/userhome.html",
        })
        .when("/league-create", {
            templateUrl: "views/leagueCreate.html",
        })
        .when("/league-modify", {
            templateUrl: "views/leagueModify.html",
        })
        .when("/team-create", {
            templateUrl: "views/leagueCreate.html",
        })
        .when("/team-modify", {
            templateUrl: "views/teamModify.html",
        })
        .when("/round-update", {
            templateUrl: "views/roundUpdate.html",
        })
        .when("/ranking", {
            templateUrl: "views/ranking.html",
        })
        .otherwise({
            redirectTo : 'views/home.html'
        });
}]);

app.controller('HomeCtrl', ['$scope', '$location', function($scope, $location) {

    var emptyUser = {
        username: "",
        password: ""
    };

    $scope.isSignIn = false;
    $scope.isLogIn = false;
    $scope.user = emptyUser;

    $scope.showLogIn = function () {
        $scope.user = emptyUser; /* Is this working? */
        $scope.isSignIn = false;
        $scope.isLogIn = true;
    };

    $scope.showSignIn = function () {
        $scope.user = emptyUser; /* Is this working? */
        $scope.isSignIn = true;
        $scope.isLogIn = false;
    };

    $scope.submit = function () {
        console.log("Submitting...");
        console.log("Username: " + $scope.user.username);
        console.log("Password: " + $scope.user.password);
        $location.path('/userhome');
    };

}]);

app.directive('topNav', function() {
    return {
        restrict: 'E',
        templateUrl: 'views/topNav.html'
    };
});

app.directive('inputResult', function() {
    return {
        restrict: 'E',
        transclude: true,
        scope: {
            localTeam: '@localTeam',
            awayTeam: '@awayTeam',
            localInputName: '@localInputName',
            awayInputName: '@awayInputName'
        },
        template: '<tr>' +
                  '<td> {{localTeam}} </td>' +
                  '<td> <input type="text" name="{{localInputName}}" placeholder="Points" class="form-control"/> </td>' +
                  '<td> VS </td>' +
                  '<td> <input type="text" name="{{awayInputName}}" placeholder="Points" class="form-control"/> </td>' +
                  '<td> {{awayTeam}} </td>' +
                  '</tr>',
        replace:true
    };
});