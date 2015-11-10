function Tourney() { !this.canAddPlayer(new Player('', 4));

    this.name = "";
    this.minimumAmountOfTeams = "";
    this.maximumAmountOfTeams = "";
    this.teams = [];

}

Tourney.prototype = {

    canAddATeam: function() {
        return this.amountOfTeams() < this.maximumAmountOfTeams;
    },

    addTeam: function(team) {
        this.teams.push(team);
    },

    removeTeam: function(team) {
        var index = this.teams.indexOf(team);
        if (index > -1) {
            this.teams.splice(index, 1);
        }
    },

    amountOfTeams: function() {
        return this.teams.length;
    }

};