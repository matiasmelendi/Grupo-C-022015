app.service('Helpers', function() {

    /* Service API */
    return {
        moveFromTo: moveFromTo
    };

    function moveFromTo(item, listFrom, listTo) {
        listTo.push(item);
        removeFrom(item, listFrom)
    }

    function removeFrom(item, list) {
        var index = list.indexOf(item);
        if (index > -1) {
            list.splice(index, 1);
        }
    }

});