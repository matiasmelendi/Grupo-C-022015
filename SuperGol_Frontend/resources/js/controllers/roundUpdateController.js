app.controller('RoundUpdateCtrl', ['$scope', '$timeout', '$location', 'RoundService', 'PlayerService', 'SweetAlert', function($scope, $timeout, $location, RoundService, PlayerService, SweetAlert) {

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
            SweetAlert.swal({
                title: "We have some problems! Sorry!",
                text: "We are not being able to retrieve the players.",
                type: "warning"
            });
        }
    );

    $scope.submit = function() {
        if($scope.manualMode) {
            console.log($scope.playerGoals);
            RoundService.uploadPlayerList($scope.playerGoals)
            .then(function successCallback(response) {
                SweetAlert.swal({
                    title: "Nice!",
                    text: "Your tourney was created!",
                    type: "success"
                }, function() {
                    $location.path('/ranking');
                });
            }, function errorCallback(response) {
                SweetAlert.swal({
                    title: "We have some problems! Sorry!",
                    text: "We are not being able to update the CVS.",
                    type: "warning"
                });
            });
        } else {
            RoundService.uploadCSV($scope.csv)
            .then(function (response) {
                $timeout(function () {
                    file.result = response.data;
                });
            }, function (response) {
                SweetAlert.swal({
                    title: "We have some problems! Sorry!",
                    text: "We are not being able to update the CVS.",
                    type: "warning"
                });
            });
        }
    }

}]);