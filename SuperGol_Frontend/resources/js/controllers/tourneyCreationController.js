app.controller('TourneyCreationCtrl', ['$scope', 'TeamService', 'TourneyService', function($scope, TeamService, TourneyService) {

    $scope.newTourney = new Tourney();

    TeamService.all().then(
        function successCallback(response) {
            $scope.allTeams = response;
        },
        function errorCallback(response) {
            console.log('Error.');
        }
    );

    $scope.createTourney = function () {
        TourneyService.create($scope.newTourney).then(
            function successCallback(response) {
                console.log('Success.');
            },
            function errorCallback(response) {
                console.log('Error.');
            }
        );
    };

    $scope.addTeam = function(team) {
        if($scope.tourney.canAddATeam()) {
            $scope.tourney.addTeam(team);
            removeTeam(team);
        }
    };

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