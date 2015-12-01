app.controller('RoundUpdateCtrl', ['$scope', 'PlayerService', function($scope, PlayerService) {

    PlayerService.all().then(
        function successCallback(response) {
            $scope.allPlayers = response;
        },
        function errorCallback(response) {
            console.log('Error.');
        }
    );

}]);