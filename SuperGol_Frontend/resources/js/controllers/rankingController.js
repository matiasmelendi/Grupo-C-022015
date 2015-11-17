app.controller('RankingCtrl', ['$scope', function($scope) {

    $scope.tourneys = [
        new Tourney().name = "123",
        new Tourney().name = "456",
        new Tourney().name = "789",
        new Tourney().name = "000"
    ];

    $scope.teams = [
        new Team().name = 'ASD',
        new Team().name = 'ZXC',
        new Team().name = 'QWE',
        new Team().name = 'RTY',
        new Team().name = 'FGH',
        new Team().name = 'VBN',
        new Team().name = 'UIO',
        new Team().name = 'JKL'
    ];

}]);