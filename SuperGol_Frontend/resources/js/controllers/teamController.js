app.controller('TeamCtrl', ['$scope', function($scope) {

    $scope.allPlayers = [
        new Player('A', 1),
        new Player('B', 2),
        new Player('C', 3),
        new Player('D', 4),
        new Player('E', 1),
        new Player('F', 2),
        new Player('G', 3),
        new Player('H', 4),
        new Player('I', 2),
        new Player('J', 2),
        new Player('K', 3),
        new Player('L', 4),
        new Player('M', 3),
        new Player('N', 3),
        new Player('O', 2),
        new Player('P', 2),
    ];

    $scope.team = new Team();

    $scope.addPlayer = function(player) {
        if($scope.team.canAddPlayer(player)) {
            $scope.team.addPlayer(player);
            $scope.removeFromAll(player);
        }
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

}]);