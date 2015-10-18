app.service('Teams', function( $http, $q ) {

    /* Service API */
    return {
        all: all,
        ranking: ranking
    };

    function all() {
         $http({
             method: "get",
             url: "/teams/all",
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

    function ranking() {
         $http({
             method: "get",
             url: "/teams/ranking",
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