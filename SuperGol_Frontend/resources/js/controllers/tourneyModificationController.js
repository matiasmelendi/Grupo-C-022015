app.controller('TourneyModificationCtrl', ['$scope', 'TeamService', 'TourneyService', function($scope, TeamService, TourneyService) {

    $scope.minAmountOfTeams = 2;

    TeamService.all().then(
        function successCallback(response) {
            $scope.allTeams = response.data;
            $scope.maxAmountOfTeams = $scope.allTeams.length;
        },
        function errorCallback(response) {
            // Error.
        }
    );

    TourneyService.all().then(
        function successCallback(response) {
            $scope.tourneys = response.data;
            $scope.selectedTourney = new Tourney().configureFromJson($scope.tourneys[0]);
        },
        function errorCallback(response) {
            // Error.
        }
    );

    $scope.editTourney = function () {
        TourneyService.edit($scope.selectedTourney).then(
            function successCallback(response) {
                $scope.editionSuccess = true;
            },
            function errorCallback(response) {
                // Error.
            }
        );
    };

    $scope.select = function(tourney) {
        $scope.selectedTourney = new Tourney().configureFromJson(tourney);
    };

    $scope.addTeam = function(team) {
        if($scope.selectedTourney.canAddATeam()) {
            $scope.selectedTourney.addTeam(team);
            removeTeam(team);
        }
    };

    $scope.removeTeam = function(team) {
        $scope.selectedTourney.removeTeam(team);
        $scope.allTeams.push(team);
    };

    function removeTeam(team) {
        var index = $scope.allTeams.indexOf(team);
        if (index > -1) {
            $scope.allTeams.splice(index, 1);
        }
    };

}]);