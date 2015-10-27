function Tourney() {

    this.name = "";
    this.minimumAmountOfTeams = "";
    this.maximumAmountOfTeams = "";
    this.teams = [];

}

Tourney.prototype = {

    addTeam: function(team) {
        this.teams.push(team);
    },

    removeTeam: function(team) {
        var index = teams.indexOf(team);
        if (index > -1) {
            teams.splice(index, 1);
        }
    }

};