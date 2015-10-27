require('../resources/js/models/team.js');

describe("Team tests :", function() {

  it("a Team can be created", function() {
    var team = new Team();
    expect(team).not.toBeNull();
  });

});