describe("Hashtable", function() {

    var hashtable;
    var key = {
        a: 1
    };

    beforeEach(function() {
        hashtable = new HashTable();
    });

    it("should be created empty", function() {
        expect(hashtable.size()).toBe(0);
    });

    it("can add an element", function() {
        hashtable.put(key, 1)
        expect(hashtable.size()).toBe(1);
    });

    it("can get an element", function() {
        hashtable.put(key, 5)
        expect(hashtable.get(key)).toBe(5);
    });

});