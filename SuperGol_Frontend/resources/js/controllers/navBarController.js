app.controller('NavBarCtrl', ['$scope', '$rootScope', '$translate', 'auth', 'store', 'LogService', function($scope, $rootScope, $translate, auth, store, LogService) {

    $scope.userLogged = LogService.someoneLogged();

    $rootScope.$on('event', function() {
        $scope.userLogged = LogService.someoneLogged();
    });

    $scope.changeLanguage = function (langKey) {
        $translate.use(langKey);
    };

    $scope.logOff = function () {
        auth.signout();
        store.remove('profile');
        store.remove('token');
        LogService.logOff();
    };

}]);