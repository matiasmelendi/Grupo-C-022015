app.service('TourneyService', function( $http, $q ) {

    /* Service API */
    return {
        all: all,
        create: create,
        edit: edit
    };

    function all() {
         return $http({
             method: "get",
             url: "/tourney/all",
         });
    }

    function create(tourney) {
        return $http({
             method: "post",
             url: "/tourney/create",
             data: tourney
        });
    }

    function edit(tourney) {
        return $http({
             method: "post",
             url: "/tourney/edit",
             data: tourney
        });
    }

});