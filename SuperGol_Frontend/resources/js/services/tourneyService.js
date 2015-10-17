app.service('Tourney', function( $http, $q ) {

    /* Service API */
    return {
        all: all
        getById: getById
    };

    function all() {
         $http({
             method: "get",
             url: "/tournies/all",
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

    function getById(id) {
         $http({
             method: "get",
             url: "/tournies",
             params: {
                id: id
             }
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