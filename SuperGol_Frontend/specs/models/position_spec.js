describe("Position", function() {

    it("can be created with a number", function() {
        var position = new Position(1);

        expect(position).toBeDefined();
        expect(position).not.toBeNull();
    });

    it("is equals to another position with the same number", function() {
        var aPosition = new Position(1);
        var anotherPosition = new Position(1);

        expect(aPosition.equals(anotherPosition)).toBe(true);
    });

    it("is not equals to another position with the same number", function() {
        var aPosition = new Position(1);
        var anotherPosition = new Position(2);

        expect(aPosition.equals(anotherPosition)).toBe(false);
    });

});