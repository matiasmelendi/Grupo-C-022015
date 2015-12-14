function User() {

    this.id = 0;
    this.password = "";
    this.scores = [];
    this.team = null;
    this.username = "";

}

User.prototype = {

    configureFromJson: function(jsonUser) {
        this.id = jsonUser.id;
        this.password = jsonUser.password;
        this.scores = jsonUser.scores;
        if(jsonUser.team) {
            this.team = new Team().configureFromJson(jsonUser.team);
        }
        this.username = jsonUser.username;
        return this;
    }

};