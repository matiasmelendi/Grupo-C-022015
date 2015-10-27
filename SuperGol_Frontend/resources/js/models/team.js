function Team() {

    this.name = '';
    this.logo = '';
    this.formation = new Formation(3, 4, 3);

};

Team.prototype = {

    canAddPlayer: function(player) {
        return this.formation.canAddPlayer(player);
    },

    addPlayer: function(player) {
        if (this.canAddPlayer(player))
            this.formation.addPlayer(player);
    },

    removePlayer: function(player) {
        this.formation.removePlayer(player);
    },

    goalkeepers: function() {
        return this.formation.goalkeepers();
    },

    defenders: function() {
        return this.formation.defenders();
    },

    midfielders: function() {
        return this.formation.midfielders();
    },

    forwards: function() {
        return this.formation.forwards();
    },

    players: function() {
        return this.formation.players;
    }

};