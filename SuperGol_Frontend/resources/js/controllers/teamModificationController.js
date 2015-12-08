app.controller('TeamModificationCtrl', ['$scope', 'TeamService', 'PlayerService', function($scope, TeamService, PlayerService) {

    $scope.selectedTeam = new Team();

    TeamService.all().then(
        function successCallback(response) {
            $scope.allTeams = response;
        },
        function errorCallback(response) {
            console.log('Error.');
        }
    );

    PlayerService.all().then(
        function successCallback(response) {
            $scope.allPlayers = response;
        },
        function errorCallback(response) {
            console.log('Error.');
        }
    );

    $scope.select = function(team) {
        $scope.selectedTeam = team;
        // filterAlreadySelectedPlayers();
    };

    $scope.removePlayer = function(player)  {
        $scope.team.removePlayer(player);
        $scope.allPlayers.push(player);
    };

    $scope.removeFromAll = function (player) {
        var index = $scope.allPlayers.indexOf(player);
        if (index > -1) {
            $scope.allPlayers.splice(index, 1);
        }
    };

    $scope.editTeam = function () {
        $scope.selectedTeam.logo = $scope.teamLogo;
        TeamService.edit($scope.selectedTeam).then(
            function successCallback(response) {
                console.log('Success.');
            },
            function errorCallback(response) {
                console.log('Error.');
            }
        );
    };

}]);