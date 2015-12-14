app.service('UploadService', function(GenericService, $rootScope, Upload, store) {

    /* Service API */
    return {
        uploadCSV: uploadCSV
    };

    function uploadCSV(file) {
        return GenericService.doPut('/rounds/update-from-csv', file, {});
    };

});