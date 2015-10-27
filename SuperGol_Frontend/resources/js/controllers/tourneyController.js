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

    $scope.tourney = new Tourney();

    $scope.addTeam = function(team) {
        $scope.tourney.addTeam(team);
        removeTeam(team);
    };

    /* TODO: Fix. Can't find the reason of why this doesn't work. */
    $scope.removeTeam = function(team) {
        $scope.tourney.removeTeam(team);
        $scope.allTeams.push(team);
    };

    function removeTeam(team) {
        var index = $scope.allTeams.indexOf(team);
        if (index > -1) {
            $scope.allTeams.splice(index, 1);
        }
    };

}]);