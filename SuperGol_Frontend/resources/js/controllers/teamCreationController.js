app.controller('TeamCreationCtrl', ['$scope', 'TeamService', 'PlayerService', function($scope, TeamService, PlayerService) {

    $scope.newTeam = new Team();

    PlayerService.all().then(
        function successCallback(response) {
            var jsonPlayers = response.data;
            var allPlayers = [];
            for(var i = 0; i < jsonPlayers.length; i++) {
                var currentPlayer = jsonPlayers[i];
                var newPlayer = new Player(currentPlayer.name, currentPlayer.position);
                allPlayers.push(newPlayer);
            }
            $scope.allPlayers = allPlayers;
        },
        function errorCallback(response) {
            console.log(response);
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
                $scope.newTeam = new Team();
            },
            function errorCallback(response) {
                console.log(response);
            }
        );
    };

}]);