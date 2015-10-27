app.controller('TeamCtrl', ['$scope', 'Helpers', function($scope, Helpers) {

    /* TODO: Remove when Services are implemented. */
    $scope.allPlayers = [
        new Player('A', 1),
        new Player('B', 2),
        new Player('C', 3),
        new Player('D', 4),
        new Player('E', 1),
        new Player('F', 2),
        new Player('G', 3),
        new Player('H', 4),
    ];

    $scope.team = new Team();

    $scope.selectedGoalkeepers = $scope.team.goalkeepers();
    $scope.selectedDefenders = $scope.team.defenders();
    $scope.selectedMidfielders = $scope.team.midfielders();
    $scope.selectedForwards = $scope.team.forwards();

    /* TODO: Fix. Can't find the reason of why this doesn't work. */
    $scope.addPlayer = function(player) {
        $scope.team.addPlayer(player);
    };

    $scope.removePlayer = function(player)  {
        $scope.team.removePlayer(player);
    };

}]);