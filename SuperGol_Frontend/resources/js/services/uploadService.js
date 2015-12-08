app.service('UploadService', function( Upload ) {

    /* Service API */
    return {
        uploadCSV: uploadCSV
    };

    function uploadCSV(file) {
        file.upload = Upload.upload({
            url: '/uploadCSV',
            data: {file: file}
        });
        return file.upload;
    };

});