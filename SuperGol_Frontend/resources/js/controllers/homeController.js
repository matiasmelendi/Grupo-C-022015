app.controller('HomeCtrl', ['$scope', 'auth', 'store', function($scope, auth, store) {

    var profile = auth.profile;
    $scope.name = profile.name;

}]);