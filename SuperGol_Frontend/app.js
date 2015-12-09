var app = angular.module('superGol', ['ngRoute', 'ngCookies', 'ngFileUpload', 'pascalprecht.translate', 'angularUtils.directives.dirPagination', 'auth0', 'angular-storage', 'angular-jwt']);

app.run(function($rootScope) {
    $rootScope.appConfiguration = {
        commonPath: 'http://localhost:8081/SuperGol/rest'
    }
});
