app.service('UploadService', function($rootScope, Upload) {

    /* Service API */
    return {
        uploadCSV: uploadCSV
    };

    function uploadCSV(file) {
        file.upload = Upload.upload({
            url: $rootScope.appConfiguration.commonPath + '/uploadCSV',
            data: {file: file}
        });
        return file.upload;
    };

});