function Formation(allowedDefenders, allowedMidfielders, allowedForwards) {

    this.players = new Array();
    this.positions = new HashTable();
    this.positions.put(new Position(1), 1);
    this.positions.put(new Position(2), allowedDefenders);
    this.positions.put(new Position(3), allowedMidfielders);
    this.positions.put(new Position(4), allowedForwards);

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
        return this.playersOnPosition(new Position(1)).length;
    },

    defenders: function() {
        return this.playersOnPosition(new Position(2)).length;
    },

    midfielders: function() {
        return this.playersOnPosition(new Position(3)).length;
    },

    forwards: function() {
        return this.playersOnPosition(new Position(4)).length;
    }
};