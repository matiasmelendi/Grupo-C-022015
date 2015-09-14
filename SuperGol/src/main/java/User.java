
public class User {

    private String username;
    private String password;
    private Team team;
    private Integer score;

    public User(String username, String password, Team aTeam){
        this.username = username;
        this.password = password;
        this.team = aTeam;
        this.score = 0;
    }

    public String username(){
        return this.username;
    }

    public Boolean hasPassword(){
        return !this.password.isEmpty();
    }

    public Team team(){
        return this.team;
    }

    public Integer score(){
        return this.score;
    }

    public void updateScore(Integer newScore){
        this.score = newScore;
    }
}
