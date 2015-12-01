app.service('RegisterService', function( $http, $q ) {

    /* Service API */
    return {
        login: login,
        register: register
    };

    function login(credentials) {
         return $http({
             method: "post",
             url: "/login",
             data: credentials
         });
    };

    function register(credentials) {
        return $http({
             method: "post",
             url: "/register",
             data: credentials
         });
    };

});