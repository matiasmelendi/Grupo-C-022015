app.service('TeamService', function(GenericService) {

    /* Service API */
    return {
        all: all,
        create: create,
        edit: edit
    };

    function all() {
         return GenericService.doGet('/teams/all', {}, {});
    }

    function create(team) {
        return GenericService.doPost('/teams/', team, {});
    }

    function edit(team) {
        return GenericService.doPut('/teams/', team, {});
    }

});