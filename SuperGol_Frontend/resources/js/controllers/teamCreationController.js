app.controller('TeamCreationCtrl', ['$scope', 'TeamService', 'PlayerService', 'store', 'SweetAlert', function($scope, TeamService, PlayerService, store, SweetAlert) {

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
            SweetAlert.swal({
                title: "We have some problems! Sorry!",
                text: "We are not being able to retrieve the players.",
                type: "warning"
            });
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
                SweetAlert.swal({
                    title: "Nice!",
                    text: "Your team was created!",
                    type: "success"
                }, function() {
                    var currentUser = store.get('currentUser');
                    currentUser.team = $scope.newTeam;
                    store.put('currentUser', currentUser);
                    $location.path('/team/modify');
                });
            },
            function errorCallback(response) {
                SweetAlert.swal({
                    title: "Oh no!",
                    text: "Your team could not be created!",
                    type: "warning"
                });
            }
        );
    };

}]);