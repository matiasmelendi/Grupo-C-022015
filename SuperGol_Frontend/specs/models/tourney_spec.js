describe("Tourney", function() {

    var tourney;
    var team;

    beforeEach(function() {
        tourney = new Tourney();
        tourney.maximumAmountOfTeams = 1;
        team = new Team();
    });

    it("can be created", function() {
        expect(tourney).not.toBeNull();
        expect(tourney).toBeDefined();
    });

    it("can add a team", function() {
        expect(tourney.canAddATeam()).toBe(true);
    });

    it("adds a team", function() {
        tourney.addTeam(team);
        expect(tourney.amountOfTeams()).toBe(1);
    });

    it("can't add a team when maximum is 1 and a team was already added", function() {
        tourney.addTeam(team);
        expect(tourney.canAddATeam()).toBe(false);
    });

    it("removes a team", function() {
        tourney.addTeam(team);
        expect(tourney.amountOfTeams()).toBe(1);

        tourney.removeTeam(team);
        expect(tourney.amountOfTeams()).toBe(0);
    });

});