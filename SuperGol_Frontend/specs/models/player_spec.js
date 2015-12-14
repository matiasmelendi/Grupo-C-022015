describe("Player", function() {

  it("should be created with name and position", function() {
    var player = new Player("Pepe Pompim", 'GOALKEEPER');

    expect(player).toBeDefined();
    expect(player.name).toEqual("Pepe Pompim");
    expect(player.position).toEqual('GOALKEEPER');
  });

});