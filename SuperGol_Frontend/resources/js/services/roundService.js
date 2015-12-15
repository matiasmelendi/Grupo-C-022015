app.service('RoundService', function(GenericService, $rootScope, Upload, store) {

    /* Service API */
    return {
        uploadCSV: uploadCSV,
        uploadPlayerList: uploadPlayerList
    };

    function uploadCSV(id, file) {
        return GenericService.doPut('/rounds/'+id+'/update-from-csv', file, {});
    };

    function uploadPlayerList(id, data) {
        return GenericService.doPost('/tournies/'+id+'/update-from-list', data, {});
    };

});
