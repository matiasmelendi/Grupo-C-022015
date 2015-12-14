app.controller('TourneyModificationCtrl', ['$scope', '$rootScope', 'TeamService', 'TourneyService', 'SweetAlert', function($scope, $rootScope, TeamService, TourneyService, SweetAlert) {

    function getAllTourneys() {
        TourneyService.all().then(
            function successCallback(response) {
                $scope.tourneys = response.data;
                $scope.selectedTourney = new Tourney().configureFromJson($scope.tourneys[0]);
            },
            function errorCallback(response) {
                SweetAlert.swal({
                    title: "We have some problems! Sorry!",
                    text: "We are not being able to retrieve the tourneys.",
                    type: "warning"
                });
            }
        );
    };

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

    getAllTourneys();

    $scope.editTourney = function () {
        TourneyService.edit($scope.selectedTourney).then(
            function successCallback(response) {
                SweetAlert.swal({
                    title: "Nice!",
                    text: "Your tourney was edited!",
                    type: "success"
                });
                getAllTourneys();
            },
            function errorCallback(response) {
                SweetAlert.swal({
                    title: "We have some problems! Sorry!",
                    text: "We are not being able to save your changes in the Tourney.",
                    type: "warning"
                });
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