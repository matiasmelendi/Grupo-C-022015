function Formation(allowedDefenders, allowedMidfielders, allowedForwards) {

    this.players = new Array();
    this.positions = new HashTable();
    this.positions.put(new Position('GOALKEEPER'), 1);
    this.positions.put(new Position('DEFENDER'), allowedDefenders);
    this.positions.put(new Position('MIDFIELDER'), allowedMidfielders);
    this.positions.put(new Position('FORWARD'), allowedForwards);

}

Formation.prototype = {

    canAddPlayer: function(player) {
        return this.canAddPlayerWithPosition(player.position);
    },

    canAddPlayerWithPosition: function(position) {
        return this.playersOnPosition(position).length < this.allowedPlayersForPosition(position);
    },

    allowedPlayersForPosition: function(position) {
        return this.positions.get(position);
    },

    addPlayer: function(player) {
        this.players.push(player);
    },

    removePlayer: function(player) {
        var index = this.players.indexOf(player);
        if (index > -1) {
            this.players.splice(index, 1);
        }
    },

    playersOnPosition: function(position) {
        var filtered = [];
        this.players.forEach(function(player) {
            if(player.position.equals(position)) {
                filtered.push(player);
            }
        });
        return filtered;
    },

    goalkeepers: function() {
        return this.playersOnPosition(new Position('GOALKEEPER')).length;
    },

    fullGoalkeepers: function() {
        return this.fullPosition(this.goalkeepers(), new Position('GOALKEEPER'));
    },

    defenders: function() {
        return this.playersOnPosition(new Position('DEFENDER')).length;
    },

    fullDefenders: function() {
        return this.fullPosition(this.defenders(), new Position('DEFENDER'));
    },

    midfielders: function() {
        return this.playersOnPosition( new Position('MIDFIELDER')).length;
    },

    fullMidfielders: function() {
        return this.fullPosition(this.midfielders(),  new Position('MIDFIELDER'));
    },

    forwards: function() {
        return this.playersOnPosition(new Position('FORWARD')).length;
    },

    fullForwards: function() {
        return this.fullPosition(this.forwards(), new Position('FORWARD'));
    },

    fullPosition: function(checkingPosition, position) {
        return checkingPosition == this.allowedPlayersForPosition(position);
    }
};