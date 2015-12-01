app.controller('HomeCtrl', ['$scope', '$location', 'RegisterService', function($scope, $location, RegisterService) {

    $scope.user = {
        username: "",
        password: "",
        repassword: ""
    };

    $scope.cleanUserData = function () {
        $scope.user = { username: "", password: "", repassword: "" };
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

    $scope.login = function () {
        RegisterService.login($scope.user).then(
            function successCallback(response) {
                $location.path('/userhome');
            },
            function errorCallback(response) {
                console.log('Error.');
            }
        );
    };

    $scope.register = function () {
        if($scope.user.password.equals($scope.user.repassword)) {
            RegisterService.register($scope.user).then(
                function successCallback(response) {
                    $location.path('/userhome');
                },
                function errorCallback(response) {
                    console.log('Error.');
                }
            );
        } else {
            // Error.
        }
    };

}]);