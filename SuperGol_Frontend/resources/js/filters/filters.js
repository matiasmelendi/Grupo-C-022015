app.filter('shortName', function() {

    return function(position) {
        var mapping = {
            'GOALKEEPER': 'GK',
            'DEFENDER': 'DF',
            'MIDFIELDER': 'MF',
            'FORWARD': 'FW'
        };
        return mapping[position];
    }

});