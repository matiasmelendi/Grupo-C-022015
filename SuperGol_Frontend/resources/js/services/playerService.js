app.service('PlayerService', function( $http, $q ) {

    /* Service API */
    return {
        all: all,
        create: create
    };

    function all() {
         return $http({
             method: "get",
             url: "/players/all",
         });
    }

    function create(player) {
        return $http({
            method: "post",
            url: "/players/create",
            data: player
        });
    }

});