app.service('TeamService', function( $http, $q ) {

    /* Service API */
    return {
        all: all,
        rankingFor: rankingFor,
        create: create
    };

    function all() {
         return $http({
             method: "get",
             url: "/teams/all",
         });
    }

    function rankingFor(tourneyID) {
         return $http({
             method: "get",
             url: "/teams/ranking",
             params: {
                tourneyID: tourneyID
             }
         });
    }

    function create(team) {
        return $http({
            method: "post",
            url: "/teams/create",
            data: team
        });
    }

});