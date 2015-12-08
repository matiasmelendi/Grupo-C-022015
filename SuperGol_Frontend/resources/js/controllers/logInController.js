app.controller('LogInCtrl', ['$scope', '$location', '$cookies', 'RegisterService', 'auth', 'store', '$location', 'LogService', function($scope, $location, $cookies, RegisterService, auth, store, $location, LogService) {

    $scope.login = function () {
        auth.signin({}, function (profile, token) {
            store.set('profile', profile);
            store.set('token', token);
            LogService.logIn();
            $location.path('/userhome');
        }, function () {
            // Error.
        });
    };

}]);