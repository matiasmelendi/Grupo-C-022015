app.controller('TourneyCreationCtrl', ['$scope', 'TeamService', 'TourneyService', function($scope, TeamService, TourneyService) {

    $scope.newTourney = new Tourney();

    $scope.minAmountOfTeams = 2;

    TeamService.all().then(
        function successCallback(response) {
            $scope.allTeams = response.data;
            $scope.maxAmountOfTeams = $scope.allTeams.length;
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
        if($scope.newTourney.canAddATeam()) {
            $scope.newTourney.addTeam(team);
            removeTeam(team);
        }
    };

    $scope.removeTeam = function(team) {
        $scope.newTourney.removeTeam(team);
        $scope.allTeams.push(team);
    };

    function removeTeam(team) {
        var index = $scope.allTeams.indexOf(team);
        if (index > -1) {
            $scope.allTeams.splice(index, 1);
        }
    };

}]);