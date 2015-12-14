app.controller('LogInCtrl', ['$scope', '$location', '$cookies', 'RegisterService', 'TourneyService', 'auth', 'store', '$location', 'LogService', function($scope, $location, $cookies, RegisterService, TourneyService, auth, store, $location, LogService) {

    $scope.login = function () {
        auth.signin({}, function (profile, token) {
            store.set('profile', profile);
            store.set('token', token);
            LogService.findOrCreate(profile.email, token).then(
                function success(response) {
                     store.set('currentUser', new User().configureFromJson(response.data));
                     saveAmountOfTourneys();
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

    function saveAmountOfTourneys(){
        TourneyService.all().then(
            function successCallback(response) {
                 $scope.tourneys = response.data;
                 store.set('atLeastOneTourney', $scope.tourneys.length > 0);
            },
            function errorCallback(response) {}
        );
    };

}]);