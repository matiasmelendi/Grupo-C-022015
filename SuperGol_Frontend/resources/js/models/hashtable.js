function HashTable() {

    this.hashes = {};

};

HashTable.prototype = {

    put: function( key, value ) {
        this.hashes[JSON.stringify(key)] = value;
    },

    get: function(key) {
        return this.hashes[JSON.stringify(key)];
    }

};