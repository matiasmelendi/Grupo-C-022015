function Tourney() {

    this.name = "";
    this.minimumAmountOfTeams = "";
    this.maximumAmountOfTeams = "";
    this.teams = [];

    this.addTeam = function(team) {
        this.teams.push(team);
    }

    this.removeTeam = function(team) {
        var index = teams.indexOf(team);
        if (index > -1) {
            teams.splice(index, 1);
        }
    };

}