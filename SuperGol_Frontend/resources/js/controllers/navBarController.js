app.controller('NavBarCtrl', function($scope, $translate) {

    $scope.changeLanguage = function (langKey) {
        $translate.use(langKey);
    };

});