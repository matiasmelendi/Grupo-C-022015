app.service('AlertService', function(SweetAlert) {

    /* Service API */
    return {
        success: success,
        successWithCallback: successWithCallback,
        warning: warning,
        warningWithCallback: warningWithCallback
    };

    function success(message) {
        SweetAlert.swal({
            title: "Awesome!",
            text: message,
            type: "success"
        });
    }

    function successWithCallback(message, callback) {
        SweetAlert.swal({
            title: "Awesome!",
            text: message,
            type: "success"
        }, callback);
    };

    function warning(message) {
        SweetAlert.swal({
            title: "Oh no!",
            text: message,
            type: "warning"
        });
    };

    function warningWithCallback(message, callback) {
        SweetAlert.swal({
            title: "Oh no!",
            text: message,
            type: "warning"
        }, callback);
    };

});