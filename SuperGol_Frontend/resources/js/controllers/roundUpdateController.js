app.controller('RoundUpdateCtrl', ['$scope', '$timeout', '$location', 'RoundService', 'PlayerService', function($scope, $timeout, $location, RoundService, PlayerService) {

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

        }
    );

    $scope.submit = function() {
        if($scope.manualMode) {
            console.log($scope.playerGoals);
            RoundService.uploadPlayerList($scope.playerGoals)
            .then(function successCallback(response) {
                $location.path('/ranking');
            }, function errorCallback(response) {

            });
        } else {
            RoundService.uploadCSV($scope.csv)
            .then(function (response) {
                $timeout(function () {
                    file.result = response.data;
                });
            }, function (response) {
                if(response.status > 0) {
                    console.log(response.status + ': ' + response.data);
                }
            });
        }
    }

}]);