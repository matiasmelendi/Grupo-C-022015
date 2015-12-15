describe("Tourney", function() {

    var tourney;
    var team;

    beforeEach(function() {
        tourney = new Tourney();
        tourney.minNumberOfTeams = 2
        tourney.maxNumberOfTeams = 4;
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

    it("can't add a team when maximum is 4 and 4 teams were already added", function() {
        tourney.addTeam(team);
        tourney.addTeam(team);
        tourney.addTeam(team);
        tourney.addTeam(team);

        expect(tourney.canAddATeam()).toBe(false);
    });

    it("removes a team", function() {
        tourney.addTeam(team);
        expect(tourney.amountOfTeams()).toBe(1);

        tourney.removeTeam(team);
        expect(tourney.amountOfTeams()).toBe(0);
    });

    it("is valid with two teams", function() {
        tourney.addTeam(team);
        tourney.addTeam(team);
        expect(tourney.valid()).toBe(true);
    });

    it("is valid with three teams", function() {
        tourney.addTeam(team);
        tourney.addTeam(team);
        tourney.addTeam(team);
        expect(tourney.valid()).toBe(true);
    });

    it("is valid with four teams", function() {
        tourney.addTeam(team);
        tourney.addTeam(team);
        tourney.addTeam(team);
        tourney.addTeam(team);
        expect(tourney.valid()).toBe(true);
    });

    it("is not valid with one team", function() {
        tourney.addTeam(team);
        expect(tourney.valid()).toBe(false);
    });

    it("is not valid with five teams", function() {
        tourney.addTeam(team);
        tourney.addTeam(team);
        tourney.addTeam(team);
        tourney.addTeam(team);
        tourney.addTeam(team);
        expect(tourney.valid()).toBe(false);
    });

});