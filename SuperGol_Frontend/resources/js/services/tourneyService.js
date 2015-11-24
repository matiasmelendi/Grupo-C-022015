app.service('TourneyService', function( $http, $q ) {

    /* Service API */
    return {
        all: all,
        getById: getById,
        create: create
    };

    function all() {
         return $http({
             method: "get",
             url: "/tournies/all",
         });
    }

    function getById(id) {
         return $http({
             method: "get",
             url: "/tournies",
             params: {
                id: id
             }
         });
    }

    function create(tourney) {
        return $http({
             method: "post",
             url: "/tournies/create",
             data: tourney
        });
    }

});