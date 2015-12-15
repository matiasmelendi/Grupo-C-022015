app.controller('RankingCtrl', ['$scope', 'TourneyService', 'TeamService', 'AlertService', function($scope, TourneyService, TeamService, AlertService) {

    TourneyService.all().then(
        function successCallback(response) {
            $scope.tourneys = response.data;
            $scope.selectedTourney = $scope.tourneys[0];
            TourneyService.rankingFor($scope.selectedTourney.id).then(
                function successCallback(response) {
                    $scope.scores = response.data;
                },
                function errorCallback(response) {
                    AlertService.warning("We are not being able to retrieve the ranking of the selected tourney.");
                }
            );
        },
        function errorCallback(response) {
            AlertService.warning("We are not being able to retrieve the tourneys.");
        }
    );

    $scope.select = function(tourney) {
        $scope.selectedTourney = tourney;
        TourneyService.rankingFor($scope.selectedTourney.id).then(
            function successCallback(response) {
                $scope.scores = response.data;
            },
            function errorCallback(response) {
                AlertService.warning("We are not being able to retrieve the ranking of the selected tourney.");
            }
        );
    };

}]);