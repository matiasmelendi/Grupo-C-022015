app.service('GenericService', function($rootScope, $http, $q, store) {

    /* Service API */
    return {
        doGet: doGet,
        doPost: doPost,
        doPostAcceptJson: doPostAcceptJson,
        doPut: doPut
    };

    function completePath(path) {
        return $rootScope.appConfiguration.commonPath + path;
    }

    function extendHeaders(common, added) {
        for(header in added){
            common[header] = added[header];
        }
        return common;
    }

    function execute(method, path, headers, data, params) {
        return $http({
            method: method,
            url: completePath(path),
            headers: extendHeaders({
                'USERNAME': store.get('profile').email
            }, headers),
            data: data,
            params, params
        });
    }

    function doGet(path, data, params) {
         return execute('GET', path, {}, data, params);
    }

    function doPostAcceptJson(path, data, params) {
         return execute('POST', path, {
             'Accept': 'application/json',
             'Content-Type': 'application/json'
         }, data, params);
    }

    function doPost(path, data, params) {
         return execute('POST', path, {
             'Accept': 'application/x-www-form-urlencoded',
             'Content-Type': 'application/json'
         }, data, params);
    }

    function doPut(path, data, params) {
         return execute('PUT', path, {
            'Accept': 'application/x-www-form-urlencoded',
            'Content-Type': 'application/json'
         }, data, params);
    }

});