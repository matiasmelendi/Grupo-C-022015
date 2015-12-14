app.controller('RankingCtrl', ['$scope', 'TourneyService', 'TeamService', 'SweetAlert', function($scope, TourneyService, TeamService, SweetAlert) {

    TourneyService.all().then(
        function successCallback(response) {
            $scope.tourneys = response.data;
            $scope.selectedTourney = $scope.tourneys[0];
            TourneyService.rankingFor($scope.selectedTourney.id).then(
                function successCallback(response) {
                    $scope.scores = response.data;
                },
                function errorCallback(response) {
                    SweetAlert.swal({
                        title: "We have some problems! Sorry!",
                        text: "We are not being able to retrieve the tourneys.",
                        type: "warning"
                    });
                }
            );
        },
        function errorCallback(response) {
            // Error.
        }
    );

    $scope.select = function(tourney) {
        $scope.selectedTourney = tourney;
        TourneyService.rankingFor($scope.selectedTourney.id).then(
            function successCallback(response) {
                $scope.scores = response.data;
            },
            function errorCallback(response) {
                SweetAlert.swal({
                    title: "We have some problems! Sorry!",
                    text: "We are not being able to retrieve the ranking of the selected tourney.",
                    type: "warning"
                });
            }
        );
    };

}]);