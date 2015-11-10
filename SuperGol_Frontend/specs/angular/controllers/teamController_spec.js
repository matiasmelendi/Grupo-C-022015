describe('Team Controller', function() {

    var rootScope, scope, controller;

    beforeEach(function() {
        module('superGol');
        inject(function($injector, $controller){
            rootScope = $injector.get('$rootScope');
            scope = rootScope.$new();
            controller = $controller('TeamCtrl', {$scope: scope});
        });
    });

    it('should be able to get the Team in scope correctly', function() {
        expect(scope.team).not.toBeNull();
    });

    it('should be able to select a Player from Available List to Selected List', function() {
        var selectedPlayer = scope.allPlayers[0];
        var initialSelectedPlayersSize = scope.allPlayers.length;

        scope.addPlayer(selectedPlayer);

        expect(scope.team.players().length).toBe(1);
        expect(scope.allPlayers.length).toBe(initialSelectedPlayersSize - 1);
    });

});