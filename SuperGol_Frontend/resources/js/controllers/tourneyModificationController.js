app.controller('TourneyModificationCtrl', ['$scope', 'TeamService', 'TourneyService', function($scope, TeamService, TourneyService) {

    TourneyService.all().then(
        function successCallback(response) {
            $scope.tourneys = response;
        },
        function errorCallback(response) {
            console.log('Error.');
        }
    );

    TeamService.all().then(
        function successCallback(response) {
            $scope.allTeams = response;
        },
        function errorCallback(response) {
            console.log('Error.');
        }
    );

    $scope.editTourney = function () {
        TourneyService.edit($scope.selectedTourney).then(
            function successCallback(response) {
                console.log('Success.');
            },
            function errorCallback(response) {
                console.log('Error.');
            }
        );
    };

    $scope.select = function(team) {
        $scope.selectedTourney = team;
        // filterAlreadySelectedTeams();
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