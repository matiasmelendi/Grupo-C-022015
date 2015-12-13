app.service('PlayerService', function(GenericService) {

    /* Service API */
    return {
        all: all
    };

    function all() {
         return GenericService.doGet('/players/all', {}, {});
    }

});