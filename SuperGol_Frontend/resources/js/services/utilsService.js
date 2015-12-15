app.service('UtilsService', function( $rootScope, GenericService ) {

    /* Service API */
    return {
        filter: filter
    };

    function filter(listA, listB, equivalence) {
        var onlyInA = listA.filter(function (current_a){
           return listB.filter(function (current_b){
               return equivalence(current_b, current_a);
           }).length == 0
        });

        var onlyInB = listB.filter(function (current_b){
           return listA.filter(function (current_a){
               return equivalence(current_b, current_a);
           }).length == 0
        });

        return onlyInA.concat(onlyInB);
    }

});