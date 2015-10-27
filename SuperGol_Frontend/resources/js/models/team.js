function HashTable() {
    this.hashes = {};
};

HashTable.prototype = {
    constructor: HashTable,

    put: function( key, value ) {
        this.hashes[JSON.stringify(key)] = value;
    },

    get: function(key) {
        return this.hashes[JSON.stringify(key)];
    }
};

/************************************************************************/

function Position(number) {

    this.number = number;

    this.equals = function(anotherPosition) {
        return number == anotherPosition;
    };

};

Position.prototype.equals = function(anotherPosition) {
    return this.number == anotherPosition.number;
};

/************************************************************************/

function Player(name, positionNumber) {

    this.name = name;
    this.position = new Position(positionNumber);

};

/************************************************************************/

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

/************************************************************************/

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