function Position(number) {

    this.number = number;

};

Position.prototype = {

    equals: function(anotherPosition) {
        return this.number == anotherPosition.number;
    }

};