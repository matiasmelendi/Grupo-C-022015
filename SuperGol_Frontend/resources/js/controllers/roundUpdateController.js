app.controller('RoundUpdateCtrl', ['$scope', '$timeout', 'UploadService', 'PlayerService', function($scope, $timeout, UploadService, PlayerService) {

    PlayerService.all().then(
        function successCallback(response) {
            $scope.allPlayers = response;
        },
        function errorCallback(response) {
            console.log('Error.');
        }
    );

    $scope.uploadCSV = function(file) {
        UploadService.uploadCSV(file)
            .then(function (response) {
                $timeout(function () {
                    file.result = response.data;
                });
            }, function (response) {
                if(response.status > 0) {
                    console.log(response.status + ': ' + response.data);
                }
            });
    };

}]);