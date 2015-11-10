describe('Team Controller', function() {

    beforeEach(function() { module('superGol') });

    var rootScope, scope, controller;

    beforeEach(function() {

        inject(function($injector, $controller){
            rootScope = $injector.get('$rootScope');
            scope = rootScope.$new();
            controller = $controller('TeamCtrl', {$scope: scope});
        });
    });

    it('should be able to get the Team in scope correctly', function() {
        expect(scope.team).not.toBeNull();
    });

});