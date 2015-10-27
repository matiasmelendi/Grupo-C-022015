require('../resources/js/models/team.js');

describe("A suite", function() {
  it("contains spec with an expectation", function() {
    var team = new Team();
    expect(team).not.toBeNull();
  });
});



