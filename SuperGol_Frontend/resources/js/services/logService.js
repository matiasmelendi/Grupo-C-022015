app.service('LogService', function( $rootScope, store ) {

    var userLogged;

    /* Service API */
    return {
        logIn: logIn,
        logOff: logOff,
        someoneLogged: someoneLogged
    };

    function someoneLogged() {
        return userLogged;
    }

    function logIn() {
        userLogged = true;
        $rootScope.$broadcast('event', true);
    }


    function logOff() {
        userLogged = false;
        $rootScope.$broadcast('event', true);
    }

});