app.controller('TourneyCtrl', ['$scope', 'Helpers', function($scope, Helpers) {

    /* TODO: Remove when Services are implemented. */
    $scope.allTeams = [
        { name: 'A' },
        { name: 'B' },
        { name: 'C' },
        { name: 'D' },
        { name: 'E' },
        { name: 'F' },
        { name: 'G' },
        { name: 'H' },
        { name: 'I' },
        { name: 'J' },
        { name: 'K' },
    ];

    $scope.selectedTeams = [];

    $scope.addToSelected = function (team) {
        Helpers.moveFromTo(team, $scope.allTeams, $scope.selectedTeams);
    }

    $scope.removeFromSelected = function (team) {
        Helpers.moveFromTo(team, $scope.selectedTeams, $scope.allTeams);
    }

}]);