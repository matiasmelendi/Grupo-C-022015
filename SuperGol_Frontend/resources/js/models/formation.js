function Formation(allowedDefenders, allowedMidfielders, allowedForwards) {

    this.players = new Array();
    this.positions = {}
    this.positions['GOALKEEPER'] = 1;
    this.positions['DEFENDER'] = allowedDefenders;
    this.positions['MIDFIELDER'] = allowedMidfielders;
    this.positions['FORWARD'] = allowedForwards;

}

Formation.prototype = {

    canAddPlayer: function(player) {
        return this.canAddPlayerWithPosition(player.position);
    },

    canAddPlayerWithPosition: function(position) {
        return this.playersOnPosition(position).length < this.allowedPlayersForPosition(position);
    },

    allowedPlayersForPosition: function(position) {
        return this.positions[position];
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
            if(player.position == position) {
                filtered.push(player);
            }
        });
        return filtered;
    },

    goalkeepers: function() {
        return this.playersOnPosition('GOALKEEPER').length;
    },

    fullGoalkeepers: function() {
        return this.fullPosition(this.goalkeepers(), 'GOALKEEPER');
    },

    defenders: function() {
        return this.playersOnPosition('DEFENDER').length;
    },

    fullDefenders: function() {
        return this.fullPosition(this.defenders(), 'DEFENDER');
    },

    midfielders: function() {
        return this.playersOnPosition('MIDFIELDER').length;
    },

    fullMidfielders: function() {
        return this.fullPosition(this.midfielders(), 'MIDFIELDER');
    },

    forwards: function() {
        return this.playersOnPosition('FORWARD').length;
    },

    fullForwards: function() {
        return this.fullPosition(this.forwards(), 'FORWARD');
    },

    fullPosition: function(checkingPosition, position) {
        return checkingPosition == this.allowedPlayersForPosition(position);
    }
};