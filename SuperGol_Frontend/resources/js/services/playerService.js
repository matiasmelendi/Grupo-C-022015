app.service('Players', function( $http, $q ) {

    /* Service API */
    return {
        all: all
    };

    function all() {
         $http({
             method: "get",
             url: "/players/all",
         })
         .then(
            function(response) {
                return response;
            },
            function(response) {
                console.log("Error calling the Backend...");
            }
         );
    }

});