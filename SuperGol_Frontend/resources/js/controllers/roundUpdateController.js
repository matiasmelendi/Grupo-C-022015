app.controller('RoundUpdateCtrl', ['$scope', '$timeout', '$location', 'RoundService', 'PlayerService', 'AlertService', 'TourneyService', function($scope, $timeout, $location, RoundService, PlayerService, AlertService, TourneyService) {

    $scope.useManualMode = function() {
        $scope.manualMode = true;
        $scope.automaticMode = false;
    }

    $scope.useAutomaticMode = function() {
        $scope.manualMode = false;
        $scope.automaticMode = true;
    }

    PlayerService.all().then(
        function successCallback(response) {
            $scope.allPlayers = response.data;
            $scope.playerGoals = [];
            $scope.allPlayers.forEach(function(player){
                $scope.playerGoals.push({
                    player: player,
                    goals: 0
                });
            });
        },
        function errorCallback(response) {
            AlertService.warning("We are not being able to retrieve the players.");
        }
    );

    TourneyService.all().then(
        function successCallback(response) {
            $scope.tourneys = response.data;
            $scope.selectedTourney = $scope.tourneys[0];
        },
        function errorCallback(response) {
            AlertService.warning("We are not being able to retrieve the tourneys.");
        }
    );

    $scope.select = function(tourney) {
        $scope.selectedTourney = tourney;
    };

    $scope.submit = function() {

        if($scope.manualMode) {
            var request = [];
            $scope.playerGoals.forEach(function(score){
              request.push([score.player, score.goals]);
            });
            RoundService.uploadPlayerList($scope.selectedTourney.id, request)
            .then(function successCallback(response) {
                AlertService.successWithCallback("The round was updated!", function() {
                    $location.path('/ranking');
                });
            }, function errorCallback(response) {
                AlertService.warning("We are not being able to update manually.");
            });
        } else {
            RoundService.uploadCSV($scope.selectedTourney.id, $scope.csv)
            .then(function (response) {
                $timeout(function () {
                    AlertService.successWithCallback("The round was updated!", function() {
                        $location.path('/ranking');
                    });
                });
            }, function (response) {
                AlertService.warning("We are not being able to update the CVS.");
            });
        }
    }

}]);
