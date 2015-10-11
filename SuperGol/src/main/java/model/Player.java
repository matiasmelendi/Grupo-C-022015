package model;

public class Player {

    private String name;
    private Position position;
    private Team team;
    private Boolean isCaptain;

    /**
     * Class' constructor.
     *
     * @param name     Name of the model.Player.
     * @param position model.Position of the model.Player.
     * @param team     model.Team of the model.Player.
     */
    public Player(String name, Position position, Team team) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.isCaptain = Boolean.FALSE;
    }

    /**
     * Returns the name of the model.Player.
     *
     * @return Name of the model.Player.
     */
    public String name() {
        return this.name;
    }

    /**
     * Makes this player become a Captain.
     */
    public void becomeCaptain() {
        this.isCaptain = Boolean.TRUE;
    }

    /**
     * Makes this player a normal model.Player.
     */
    public void unassignCaptain() {
        this.isCaptain = Boolean.FALSE;
    }

    /**
     * Returns if this player is Captain.
     *
     * @return If this player is Captain.
     */
    public Boolean isCaptain() {
        return this.isCaptain;
    }

    /**
     * Change the position of this player.
     *
     * @param position The new position.
     */
    public void changePosition(Position position) {
        this.position = position;
    }

    /**
     * Returns the model.Player's position.
     *
     * @return This player position.
     */
    public Position position() {
        return this.position;
    }

    /**
     * Returns the model.Player's team.
     *
     * @return This player team.
     */
    public Team team() {
        return this.team;
    }

    @Override
    public boolean equals(Object _anotherPlayer){
        Player anotherPlayer = (Player) _anotherPlayer;

        return this.name().equals(anotherPlayer.name()) &&
               this.position().equals(anotherPlayer.position()) &&
               this.team().equals(anotherPlayer.team()) &&
               this.isCaptain().equals(anotherPlayer.isCaptain());
    }
}