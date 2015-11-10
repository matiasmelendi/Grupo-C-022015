describe("Formation", function() {

    var formation;
    var goalkeeper = new Player('David', 1);

    beforeEach(function() {
        formation = new Formation(3, 4, 3);
    });

    it("should have no players when created", function() {
        expect(formation.goalkeepers()).toBe(0);
        expect(formation.defenders()).toBe(0);
        expect(formation.midfielders()).toBe(0);
        expect(formation.forwards()).toBe(0);
    });

    it("should allow to add a goalkeeper, 3 defenders, 4 midfielders and 3 forwards when created", function() {
        var goalkeeperPosition = new Position(1);
        var defenderPosition = new Position(2);
        var midfielderPosition = new Position(3);
        var forwardPosition = new Position(4);

        expect(formation.allowedPlayersForPosition(goalkeeperPosition)).toBe(1);
        expect(formation.allowedPlayersForPosition(defenderPosition)).toBe(3);
        expect(formation.allowedPlayersForPosition(midfielderPosition)).toBe(4);
        expect(formation.allowedPlayersForPosition(forwardPosition)).toBe(3);
    });

    it("can add a Goalkeeper when it doesn't have one", function() {
        expect(formation.canAddPlayer(goalkeeper)).toBe(true);
    });

    it("adds a Goalkeeper when it doesn't have one", function() {
        formation.addPlayer(goalkeeper);

        expect(formation.goalkeepers()).toBe(1);
    });

    it("can't add a Goalkeeper when it already has one", function() {
        formation.addPlayer(goalkeeper);

        expect(formation.canAddPlayer(goalkeeper)).toBe(false);
    });

    it("removes a player", function() {
        formation.addPlayer(goalkeeper);
        expect(formation.goalkeepers()).toBe(1);

        formation.removePlayer(goalkeeper);
        expect(formation.goalkeepers()).toBe(0);
    });

});