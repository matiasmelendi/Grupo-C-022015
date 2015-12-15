app.controller('TeamModificationCtrl', ['$scope', 'TeamService', 'PlayerService', 'store', 'AlertService', function($scope, TeamService, PlayerService, store, AlertService) {

    var currentUser = store.get('currentUser');
    $scope.userTeam = currentUser.team;
    // Filter

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
            AlertService.warning("We are not being able to retrieve the players.");
        }
    );

    $scope.addPlayer = function(player) {
        if($scope.userTeam.canAddPlayer(player)) {
            $scope.userTeam.addPlayer(player);
            $scope.removeFromAll(player);
        }
    };

    $scope.removePlayer = function(player)  {
        $scope.userTeam.removePlayer(player);
        $scope.allPlayers.push(player);
    };

    $scope.removeFromAll = function (player) {
        var index = $scope.allPlayers.indexOf(player);
        if (index > -1) {
            $scope.allPlayers.splice(index, 1);
        }
    };

    $scope.editTeam = function () {
        TeamService.edit($scope.selectedTeam).then(
            function successCallback(response) {
                AlertService.success("Your team was edited!");
            },
            function errorCallback(response) {
                AlertService.warning("Your team could not be edited!");
            }
        );
    };

}]);