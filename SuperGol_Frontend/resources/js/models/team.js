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

    fullGoalkeepers: function() {
        return this.formation.fullGoalkeepers();
    },

    defenders: function() {
        return this.formation.defenders();
    },

    fullDefenders: function() {
        return this.formation.fullDefenders();
    },

    midfielders: function() {
        return this.formation.midfielders();
    },

    fullMidfielders: function() {
        return this.formation.fullMidfielders();
    },

    forwards: function() {
        return this.formation.forwards();
    },

    fullForwards: function() {
        return this.formation.fullForwards();
    },

    players: function() {
        return this.formation.players;
    }

};