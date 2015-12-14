app.service('RoundService', function(GenericService, $rootScope, Upload, store) {

    /* Service API */
    return {
        uploadCSV: uploadCSV,
        uploadPlayerList: uploadPlayerList
    };

    function uploadCSV(file) {
        return GenericService.doPut('/rounds/update-from-csv', file, {});
    };

    function uploadPlayerList(data) {
        return GenericService.doPost('/rounds/update-from-list', data, {});
    };

});