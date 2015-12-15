app.controller('RankingCtrl', ['$scope', 'TourneyService', 'TeamService', function($scope, TourneyService, TeamService) {

    TourneyService.all().then(
        function successCallback(response) {
            $scope.tourneys = response.data;
            $scope.selectedTourney = $scope.tourneys[0];
            TourneyService.rankingFor($scope.selectedTourney.id).then(
                function successCallback(response) {
                    $scope.teamsInOrder = response.data;
                },
                function errorCallback(response) {
                    // Error.
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
                $scope.teamsInOrder = response.data;
            },
            function errorCallback(response) {
                // Error.
            }
        );
    };

}]);