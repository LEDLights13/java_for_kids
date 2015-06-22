import java.io.Serializable;

/**
 * Created by imusiievych on 6/8/15.
 */
public class GameState implements Serializable{

    String playerName;
    int level;
    int scores;
    int remainingLives;

    GameState (String playerName, int level, int scores, int remainingLives){
        this.playerName = playerName;
        this.level = level;
        this.scores = scores;
        this.remainingLives = remainingLives;
    }

    public String toString(){
        return "Player Name: " + playerName + ", level: " + level + ", score: " + scores + ", remaining lives: " + remainingLives;
    }

}
