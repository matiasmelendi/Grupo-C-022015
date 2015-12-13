app.service('TeamService', function(GenericService) {

    /* Service API */
    return {
        all: all,
        rankingFor: rankingFor,
        create: create,
        edit: edit
    };

    function all() {
         return GenericService.doGet('/teams/all', {}, {});
    }

    function rankingFor(tourneyID) {
         return GenericService.doGet('/teams/ranking', {}, {
            tourneyID: tourneyID
         });
    }

    function create(team) {
        return GenericService.doPost('/teams/create', team, {});
    }

    function edit(team) {
        return GenericService.doPost('/teams/edit', team, {});
    }

});