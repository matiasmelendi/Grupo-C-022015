describe("Team", function() {

  it("could be created", function() {
    var team = new Team();

    expect(team).not.toBeNull();
    expect(team).toBeDefined();
  });

  it("should not have name and logo", function() {
    var team = new Team();

    expect(team.name).toEqual('');
    expect(team.logo).toEqual('');
  });

});