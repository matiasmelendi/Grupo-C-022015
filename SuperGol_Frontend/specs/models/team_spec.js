describe("Team", function() {

    var team;
    var goalkeeper = new Player('David', 1);

    beforeEach(function() {
        team = new Team();
    });

    it("can be created", function() {
        expect(team).not.toBeNull();
        expect(team).toBeDefined();
    });

    it("should not have name and logo", function() {
        expect(team.name).toEqual('');
        expect(team.logo).toEqual('');
    });

    it("should not have any players when created", function() {
        expect(team.players().length).toBe(0);
    });

    it("can add a goalkeeper when it doesn't have one", function() {
        expect(team.canAddPlayer(goalkeeper)).toBe(true);
    });

    it("adds a goalkeeper when it doesn't have one", function() {
        team.addPlayer(goalkeeper);
        expect(team.players().length).toBe(1);
    });

    it("can't add a goalkeeper when it already has one", function() {
        team.addPlayer(goalkeeper);
        expect(team.canAddPlayer(goalkeeper)).toBe(false);

        // Tries to add again, which is not possible.
        team.addPlayer(goalkeeper);
        expect(team.players().length).toBe(1);
    });

    it("can remove a player", function() {
        team.addPlayer(goalkeeper);
        expect(team.players().length).toBe(1);

        team.removePlayer(goalkeeper);
        expect(team.players().length).toBe(0);
    });

});