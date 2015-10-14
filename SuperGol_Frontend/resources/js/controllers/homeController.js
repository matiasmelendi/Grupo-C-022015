app.controller('HomeCtrl', ['$scope', '$location', function($scope, $location) {

    $scope.cleanUserData = function () {
        $scope.user = { username: "", password: "" };
    };

    $scope.isSignIn = false;
    $scope.isLogIn = false;

    $scope.showLogIn = function () {
        $scope.cleanUserData();
        $scope.isSignIn = false;
        $scope.isLogIn = true;
    };

    $scope.showSignIn = function () {
        $scope.cleanUserData();
        $scope.isSignIn = true;
        $scope.isLogIn = false;
    };

    $scope.submit = function () {
        $location.path('/userhome');
    };

}]);