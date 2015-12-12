function Tourney() {

    this.id = 0;
    this.name = "";
    this.minNumberOfTeams = "";
    this.maxNumberOfTeams = "";
    this.teams = [];

}

Tourney.prototype = {

    canAddATeam: function() {
        return this.amountOfTeams() < this.maxNumberOfTeams;
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
    },

    valid: function() {
        var validMinAmountOfTeams = this.amountOfTeams() >= this.minNumberOfTeams;
        var validMaxAmountOfTeams = this.amountOfTeams() <= this.maxNumberOfTeams;
        return validMinAmountOfTeams && validMaxAmountOfTeams;
    },

    configureFromJson: function(jsonTourney) {
        this.id = jsonTourney.id;
        this.name = jsonTourney.name;
        this.minNumberOfTeams = jsonTourney.minNumberOfTeams;
        this.maxNumberOfTeams = jsonTourney.maxNumberOfTeams;
        this.teams = jsonTourney.teams;
        return this;
    }

};