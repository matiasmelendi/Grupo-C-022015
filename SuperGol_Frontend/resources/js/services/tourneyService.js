app.service('TourneyService', function(GenericService) {

    /* Service API */
    return {
        all: all,
        create: create,
        edit: edit
    };

    function all() {
         return GenericService.doGet('/tournies/all', {}, {});
    }

    function create(tourney) {
        return GenericService.doPost('/tournies/', tourney, {});
    }

    function edit(tourney) {
        return GenericService.doPut('/tournies/', data, {});
    }

});