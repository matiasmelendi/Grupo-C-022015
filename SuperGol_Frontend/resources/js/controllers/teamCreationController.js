app.controller('TeamCreationCtrl', ['$scope', 'TeamService', 'PlayerService', function($scope, TeamService, PlayerService) {

    $scope.newTeam = new Team();

    PlayerService.all().then(
        function successCallback(response) {
            $scope.allPlayers = response;
        },
        function errorCallback(response) {
            console.log('Error.');
        }
    );

    $scope.addPlayer = function(player) {
        if($scope.newTeam.canAddPlayer(player)) {
            $scope.newTeam.addPlayer(player);
            $scope.removeFromAll(player);
        }
    };

    $scope.removePlayer = function(player)  {
        $scope.newTeam.removePlayer(player);
        $scope.allPlayers.push(player);
    };

    $scope.removeFromAll = function (player) {
        var index = $scope.allPlayers.indexOf(player);
        if (index > -1) {
            $scope.allPlayers.splice(index, 1);
        }
    };

    $scope.createTeam = function () {
        TeamService.create($scope.newTeam).then(
            function successCallback(response) {
                console.log('Success.');
            },
            function errorCallback(response) {
                console.log('Error.');
            }
        );
    };

}]);