app.service('TeamService', function($rootScope, $http, $q) {

    /* Service API */
    return {
        all: all,
        rankingFor: rankingFor,
        create: create,
        edit: edit
    };

    function all() {
         return $http({
             method: "get",
             url: $rootScope.appConfiguration.commonPath + "/teams/all",
         });
    }

    function rankingFor(tourneyID) {
         return $http({
             method: "get",
             url: $rootScope.appConfiguration.commonPath + "/teams/ranking",
             params: {
                tourneyID: tourneyID
             }
         });
    }

    function create(team) {
        return $http({
            method: "post",
            url: $rootScope.appConfiguration.commonPath + "/teams/create",
            data: team
        });
    }

    function edit(team) {
        return $http({
            method: "post",
            url: $rootScope.appConfiguration.commonPath + "/teams/edit",
            data: team
        });
    }

});