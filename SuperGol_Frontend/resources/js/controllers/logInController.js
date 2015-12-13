app.controller('LogInCtrl', ['$scope', '$location', '$cookies', 'RegisterService', 'auth', 'store', '$location', 'LogService', function($scope, $location, $cookies, RegisterService, auth, store, $location, LogService) {

    $scope.login = function () {
        auth.signin({}, function (profile, token) {
            store.set('profile', profile);
            store.set('token', token);
            LogService.findOrCreate(profile.email, token).then(
                function success(response) {
                     store.set('currentUser', new User().configureFromJson(response.data));
                     console.log(response.data);
                     $location.path('/userhome');
                },
                function error(response) {
                    console.log('Couldnt log');
                }
            );
        }, function () {
            // Error.
        });
    };

}]);