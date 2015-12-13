app.controller('NavBarCtrl', ['$scope', '$rootScope', '$translate', 'auth', 'store', function($scope, $rootScope, $translate, auth, store) {

    $scope.store = store;

    $scope.userIsLogged = function () {
        return $scope.store.get('currentUser') != null;
    };

    $scope.userHasTeam = function () {
        return $scope.store.get('currentUser').hasATeam();
    };

    $scope.changeLanguage = function (langKey) {
        $translate.use(langKey);
    };

    $scope.logOff = function () {
        auth.signout();
        store.remove('profile');
        store.remove('token');
        store.remove('currentUser');
    };

}]);