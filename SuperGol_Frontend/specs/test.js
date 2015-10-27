require('../resources/js/models/team.js');

describe("Team tests :", function() {

  it("could be created", function(Team) {
    var team = new Team();

    expect(team).not.toBeNull();
    expect(team).toBeDefined();
  });

  it("should not have name and logo", function(Team) {
    var team = new Team();

    expect(team.name).toEqual('');
    expect(team.logo).toEqual('');
  });


});