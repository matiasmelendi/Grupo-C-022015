app.controller('TeamModificationCtrl', ['$scope', 'TeamService', 'PlayerService', 'UtilsService', 'store', function($scope, TeamService, PlayerService, UtilsService, store) {

    $scope.allPlayers = [];

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
            console.log('Error.');
        }
    );

    var currentUser = store.get('currentUser');
    $scope.userTeam = currentUser.team;
    $scope.filteredPlayers = filterPlayers();

    $scope.editTeam = function () {
        TeamService.edit($scope.selectedTeam).then(
            function successCallback(response) {
                console.log('Success.');
            },
            function errorCallback(response) {
                console.log('Error.');
            }
        );
    };

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



    function filterPlayers() {
        return UtilsService.filter($scope.allPlayers, $scope.userTeam, function(allPlayer, userPlayer){
            return allPlayer.id == userPlayer.id;
        })
    };

}]);