app.service('PlayerService', function($rootScope, $http, $q) {

    /* Service API */
    return {
        all: all
    };

    function all() {
         return $http({
             method: "GET",
             url: $rootScope.appConfiguration.commonPath + "/players/all"
         });
    }

});