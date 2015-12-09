app.service('TourneyService', function($rootScope, $http, $q) {

    /* Service API */
    return {
        all: all,
        create: create,
        edit: edit
    };

    function all() {
         return $http({
             method: "get",
             url: $rootScope.appConfiguration.commonPath + "/tourney/all",
         });
    }

    function create(tourney) {
        return $http({
             method: "post",
             url: $rootScope.appConfiguration.commonPath + "/tourney/create",
             data: tourney
        });
    }

    function edit(tourney) {
        return $http({
             method: "post",
             url: $rootScope.appConfiguration.commonPath + "/tourney/edit",
             data: tourney
        });
    }

});