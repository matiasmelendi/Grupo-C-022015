app.config(['$routeProvider', function($routeProvider){
    $routeProvider
        .when('/', {
            templateUrl : 'views/home.html'
        })
        .when("/userhome", {
            templateUrl: "views/userhome.html",
        })
        .when("/league/create", {
            templateUrl: "views/leagueCreate.html",
        })
        .when("/league/modify", {
            templateUrl: "views/leagueModify.html",
        })
        .when("/team/create", {
            templateUrl: "views/teamCreate.html",
        })
        .when("/team/modify", {
            templateUrl: "views/teamModify.html",
        })
        .when("/round/update", {
            templateUrl: "views/roundUpdate.html",
        })
        .when("/ranking", {
            templateUrl: "views/ranking.html",
        })
        .otherwise({
            redirectTo : 'views/home.html'
        });
}]);
