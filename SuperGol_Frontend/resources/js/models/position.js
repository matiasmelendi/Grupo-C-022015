function Position(number) {

    this.number = number;

    this.equals = function(anotherPosition) {
        return number == anotherPosition;
    };

};

Position.prototype.equals = function(anotherPosition) {
    return this.number == anotherPosition.number;
};