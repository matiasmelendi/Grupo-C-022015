app.controller('TourneyCreationCtrl', ['$scope', '$location', 'store', 'TeamService', 'TourneyService', 'SweetAlert', function($scope, $location, store, TeamService, TourneyService, SweetAlert) {

    $scope.newTourney = new Tourney();

    $scope.minAmountOfTeams = 2;

    TeamService.all().then(
        function successCallback(response) {
            $scope.allTeams = response.data;
            $scope.maxAmountOfTeams = $scope.allTeams.length;
        },
        function errorCallback(response) {
            SweetAlert.swal({
                title: "We have some problems! Sorry!",
                text: "We are not being able to retrieve the teams.",
                type: "warning"
            });
        }
    );

    $scope.createTourney = function () {
        TourneyService.create($scope.newTourney).then(
            function successCallback(response) {
                SweetAlert.swal({
                    title: "Nice!",
                    text: "Your tourney was created!",
                    type: "success"
                }, function() {
                    store.set('atLeastOneTourney', true);
                    $location.path('/tourney/modify');
                });
            },
            function errorCallback(response) {
                SweetAlert.swal({
                    title: "Oh no!",
                    text: "Your tourney could not be created!",
                    type: "warning"
                });
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