app.service('TourneyService', function($rootScope, $http, $q) {

    /* Service API */
    return {
        all: all,
        create: create,
        edit: edit
    };

    function all() {
         return $http({
             method: "GET",
             url: $rootScope.appConfiguration.commonPath + "/tournies/all",
         });
    }

    function create(tourney) {
        return $http({
             method: "POST",
             url: $rootScope.appConfiguration.commonPath + "/tournies/",
             data: tourney
        });
    }

    function edit(tourney) {
        return $http({
             method: "PUT",
             url: $rootScope.appConfiguration.commonPath + "/tournies/",
             data: tourney
        });
    }

});