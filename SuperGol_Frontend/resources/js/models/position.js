function Position(name) {

    this.name = name;

};

Position.prototype = {

    equals: function(anotherPosition) {
        return this.name == anotherPosition.name;
    }

};