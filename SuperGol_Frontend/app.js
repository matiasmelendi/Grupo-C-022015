var app = angular.module('superGol', ['ngRoute', 'ngCookies', 'ngMessages', 'ngFileUpload', 'pascalprecht.translate', 'angularUtils.directives.dirPagination', 'auth0', 'angular-storage', 'angular-jwt', 'oitozero.ngSweetAlert']);

app.run(function($rootScope) {
    $rootScope.appConfiguration = {
        commonPath: 'http://localhost:8081/SuperGol/rest'
    }
});
