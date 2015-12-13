app.service('LogService', function( $rootScope, GenericService ) {

    var userLogged;

    /* Service API */
    return {
        findOrCreate: findOrCreate
    };

    function findOrCreate(email, token) {
        return GenericService.doPost('/users/find-or-create', {
            username: "",
            password: ""
        }, {});
    }

});