app.controller('RankingCtrl', ['$scope', 'Tourney', function($scope, Tourney) {

    /* $scope.tournies = Tourney.all(); */

    $scope.tournies = [
        { name: 'T1' },
        { name: 'T2' },
        { name: 'T3' },
        { name: 'T4' },
        { name: 'T5' },
        { name: 'T6' },
    ];


}]);