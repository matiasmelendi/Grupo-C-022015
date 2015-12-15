app.controller('TourneyCreationCtrl', ['$scope', '$location', 'store', 'TeamService', 'TourneyService', 'AlertService', function($scope, $location, store, TeamService, TourneyService, AlertService) {

    $scope.newTourney = new Tourney();

    $scope.minAmountOfTeams = 2;

    TeamService.all().then(
        function successCallback(response) {
            $scope.allTeams = response.data;
            $scope.maxAmountOfTeams = $scope.allTeams.length;
        },
        function errorCallback(response) {
            AlertService.warning("We are not being able to retrieve the teams.");
        }
    );

    $scope.createTourney = function () {
        TourneyService.create($scope.newTourney).then(
            function successCallback(response) {
                AlertService.successWithCallback("Your tourney was created!", function() {
                    store.set('atLeastOneTourney', true);
                    $location.path('/tourney/modify');
                });
            },
            function errorCallback(response) {
                AlertService.warning("Your tourney could not be created!");
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