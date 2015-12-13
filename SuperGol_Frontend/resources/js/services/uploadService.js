app.service('UploadService', function($rootScope, Upload, store) {

    /* Service API */
    return {
        uploadCSV: uploadCSV
    };

    function uploadCSV(file) {
        file.upload = Upload.upload({
            url: $rootScope.appConfiguration.commonPath + '/uploadCSV',
            data: {file: file},
            headers: {
                'SG-Username': store.get('profile').email,
                'SG-Password': store.get('token')
            }
        });
        return file.upload;
    };

});