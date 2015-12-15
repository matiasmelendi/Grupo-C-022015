app.service('TeamService', function(GenericService, Upload) {

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
        return Upload.dataUrl(team.logo, true).then(function (url) {
            team.logo = url;
            return GenericService.doPost('/teams/', team, {});
        });
    }

    function edit(team) {
        return GenericService.doPut('/teams/', team, {});
    }

});