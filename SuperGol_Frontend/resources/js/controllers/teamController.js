app.controller('TeamCtrl', ['$scope', 'Helpers', function($scope, Helpers) {

    $scope.team = {
        name: '',
        logo: '',
        players: []
    }

    /* TODO: Remove when Services are implemented. */
    $scope.allPlayers = [
        { name: 'A', position: 'GK' },
        { name: 'B', position: 'GK' },
        { name: 'C', position: 'GK' },
        { name: 'D', position: 'DF' },
        { name: 'E', position: 'DF' },
        { name: 'F', position: 'DF' },
        { name: 'G', position: 'DF' },
        { name: 'H', position: 'DF' },
        { name: 'I', position: 'MF' },
        { name: 'J', position: 'MF' },
        { name: 'K', position: 'MF' },
        { name: 'L', position: 'MF' },
        { name: 'M', position: 'MF' },
        { name: 'N', position: 'MF' },
        { name: 'O', position: 'MF' },
        { name: 'P', position: 'MF' },
        { name: 'Q', position: 'FW' },
        { name: 'R', position: 'FW' },
        { name: 'S', position: 'FW' },
        { name: 'T', position: 'FW' },
        { name: 'U', position: 'FW' },

    ];

    $scope.selectedPlayers = [];

    /* TODO: Refactor. */
    $scope.selectedGoalkeepers = 0;
    $scope.fullGoalkeepers = false;
    $scope.selectedDefenders = 0;
    $scope.fullDefenders = false;
    $scope.selectedMidfielders = 0;
    $scope.fullMidfielders = false;
    $scope.selectedForwards = 0;
    $scope.fullForwards = false;

    $scope.addToSelected = function (player) {
        if(player.position == 'GK') {
            $scope.selectedGoalkeepers++;
            if($scope.selectedGoalkeepers == 1) {
                $scope.fullGoalkeepers = true;
            }
        }
        if(player.position == 'DF') {
            $scope.selectedDefenders++;
            if($scope.selectedDefenders == 3) {
                $scope.fullDefenders = true;
            }
        }
        if(player.position == 'MF') {
            $scope.selectedMidfielders++;
            if($scope.selectedMidfielders == 4) {
                $scope.fullMidfielders = true;
            }
        }
        if(player.position == 'FW') {
            $scope.selectedForwards++;
            if($scope.selectedForwards == 3) {
                $scope.fullForwards = true;
            }
        }
        Helpers.moveFromTo(player, $scope.allPlayers, $scope.selectedPlayers);
    };

    $scope.removeFromSelected = function (player) {
        if(player.position == 'GK') {
            $scope.selectedGoalkeepers--;
            if($scope.selectedGoalkeepers < 1) {
                $scope.fullGoalkeepers = false;
            }
        }
        if(player.position == 'DF') {
            $scope.selectedDefenders--;
            if($scope.selectedDefenders < 3) {
                $scope.fullDefenders = false;
            }
        }
        if(player.position == 'MF') {
            $scope.selectedMidfielders--;
            if($scope.selectedMidfielders < 4) {
                $scope.fullMidfielders = false;
            }
        }
        if(player.position == 'FW') {
            $scope.selectedForwards--;
            if($scope.selectedForwards < 3) {
                $scope.fullForwards = false;
            }
        }
        Helpers.moveFromTo(player, $scope.selectedPlayers, $scope.allPlayers);
    };
    /* END TODO: Refactor. */

}]);