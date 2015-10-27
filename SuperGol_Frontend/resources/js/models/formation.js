function Formation(allowedDefenders, allowedMidfielders, allowedForwards) {

    this.players = [];
    this.positions = new HashTable();
    this.positions.put(new Position(1), 1);
    this.positions.put(new Position(2), allowedDefenders);
    this.positions.put(new Position(3), allowedMidfielders);
    this.positions.put(new Position(4), allowedForwards);

    this.canAddPlayer = function(player) {
        return this.canAddPlayerWithPosition(player.position);
    };

    this.canAddPlayerWithPosition = function(position) {
        return this.playersOnPosition(position).length < this.allowedPlayersForPosition(position);
    };

    this.allowedPlayersForPosition = function(position) {
        return this.positions.get(position);
    };

    this.addPlayer = function(player) {
        this.players.push(player);
    };

    this.removePlayer = function(player) {
        var index = players.indexOf(player);
        if (index > -1) {
            players.splice(index, 1);
        }
    };

    this.playersOnPosition = function(position) {
        var filtered = [];
        this.players.forEach(function(player) {
            if(player.position.equals(position)) {
                filtered.push(player);
            }
        });
        return filtered;
    };

    this.goalkeepers = function() {
        return this.playersOnPosition(new Position(1)).length;
    };

    this.defenders = function() {
        return this.playersOnPosition(new Position(2)).length;
    };

    this.midfielders = function() {
        return this.playersOnPosition(new Position(3)).length;
    };

    this.forwards = function() {
        return this.playersOnPosition(new Position(4)).length;
    };

};