app.service('LogService', function( $rootScope, GenericService ) {

    var userLogged;

    /* Service API */
    return {
        findOrCreate: findOrCreate
    };

    function findOrCreate(email, token) {
        return GenericService.doPostAcceptJson('/users/find-or-create', {
            username: email,
            password: token
        }, {});
    }

});