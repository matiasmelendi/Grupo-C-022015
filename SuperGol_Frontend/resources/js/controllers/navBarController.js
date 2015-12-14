app.controller('NavBarCtrl', ['$scope', '$rootScope', '$translate', 'auth', 'store', function($scope, $rootScope, $translate, auth, store) {

    $scope.store = store;

    $scope.userIsLogged = function () {
        return null != $scope.store.get('currentUser');
    };

    $scope.userHasTeam = function () {
        var currentUser = $scope.store.get('currentUser');
        if(currentUser) {
            return null != currentUser.team;
        } else {
            return false;
        }
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