app.controller('TourneyModificationCtrl', ['$scope', '$rootScope', 'TeamService', 'TourneyService', 'UtilsService', function($scope, $rootScope, TeamService, TourneyService, UtilsService) {

    $scope.minAmountOfTeams = 2;
    $scope.allTeams = [];

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
            $scope.filteredTeams = filterTeams();
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
        $scope.filteredTeams = filterTeams();
    };

    $scope.addTeam = function(team) {
        if($scope.selectedTourney.canAddATeam()) {
            $scope.selectedTourney.addTeam(team);
            removeTeam(team);
        }
    };

    $scope.removeTeam = function(team) {
        $scope.selectedTourney.removeTeam(team);
        $scope.filteredTeams.push(team);
    };

    function removeTeam(team) {
        var index = $scope.filteredTeams.indexOf(team);
        if (index > -1) {
            $scope.filteredTeams.splice(index, 1);
        }
    };

    function filterTeams() {
        return UtilsService.filter($scope.allTeams, $scope.selectedTourney.teams, function(allTeam, selectedTeam) {
            return allTeam.id == selectedTeam.id;
        });
    };

}]);