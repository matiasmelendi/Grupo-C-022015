app.controller('RoundUpdateCtrl', ['$scope', '$timeout', '$location', 'RoundService', 'PlayerService', 'AlertService', function($scope, $timeout, $location, RoundService, PlayerService, AlertService) {

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

    $scope.submit = function() {
        if($scope.manualMode) {
            console.log($scope.playerGoals);
            RoundService.uploadPlayerList($scope.playerGoals)
            .then(function successCallback(response) {
                AlertService.successWithCallback("The round was updated!", function() {
                    $location.path('/ranking');
                });
            }, function errorCallback(response) {
                AlertService.warning("We are not being able to update the CVS.");
            });
        } else {
            RoundService.uploadCSV($scope.csv)
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