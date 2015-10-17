app.controller('RankingCtrl', ['$scope', 'Tourney', function($scope, Tourney) {

    $scope.tournies = Tourney.all();

}]);