function Team() {

    this.name = '';
    this.logo = '';
    this.formation = new Formation(3, 4, 3);

    this.canAddPlayer = function(player) {
        return this.formation.canAddPlayer(player);
    };

    this.addPlayer = function(player) {
        this.formation.addPlayer(player);
    };

    this.removePlayer = function(player) {
        this.formation.removePlayer(player);
    };

    this.goalkeepers = function() {
        return this.formation.goalkeepers();
    };

    this.defenders = function() {
        return this.formation.defenders();
    };

    this.midfielders = function() {
        return this.formation.midfielders();
    };

    this.forwards = function() {
        return this.formation.forwards();
    };

    this.players = function() {
        return this.formation.players;
    };

};