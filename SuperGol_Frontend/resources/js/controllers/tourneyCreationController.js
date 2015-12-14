app.controller('TourneyCreationCtrl', ['$scope', '$location', 'store', 'TeamService', 'TourneyService', function($scope, $location, store, TeamService, TourneyService) {

    $scope.newTourney = new Tourney();

    $scope.minAmountOfTeams = 2;

    TeamService.all().then(
        function successCallback(response) {
            $scope.allTeams = response.data;
            $scope.maxAmountOfTeams = $scope.allTeams.length;
        },
        function errorCallback(response) {

        }
    );

    $scope.createTourney = function () {
        TourneyService.create($scope.newTourney).then(
            function successCallback(response) {
                store.set('atLeastOneTourney', true);
                $location.path('/tourney/modify');
            },
            function errorCallback(response) {

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