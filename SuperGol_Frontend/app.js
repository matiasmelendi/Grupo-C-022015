(function() {

    var app = angular.module('superGol', ['ngRoute']);

    app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/home.html'
            })
            .otherwise({
                redirectTo: 'views/home.html'
            });
    }]);

});