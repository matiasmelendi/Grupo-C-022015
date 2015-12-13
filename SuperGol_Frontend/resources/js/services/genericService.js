app.service('GenericService', function($rootScope, $http, $q, store) {

    /* Service API */
    return {
        doGet: doGet,
        doPost: doPost,
        doPut: doPut
    };

    function completePath(path) {
        return $rootScope.appConfiguration.commonPath + path;
    }

    function execute(method, path, headers, data, params) {
        return $http({
            method: method,
            url: completePath(path),
            headers: headers,
            data: data,
            params, params
        });
    }

    function doGet(path, data, params) {
         return execute('GET', path, {}, data, params);
    }

    function doPost(path, data, params) {
         return execute('POST', path, {
             'Accept': 'application/json',
             'Content-Type': 'application/json'
         }, data, params);
    }

    function doPut(path, data, params) {
         return execute('PUT', path, {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
         }, data, params);
    }

});