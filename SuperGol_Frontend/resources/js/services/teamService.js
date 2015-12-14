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
        return GenericService.doPost('/teams/create', team, {});
    }

    function edit(team) {
        return GenericService.doPost('/teams/edit', team, {});
    }

});