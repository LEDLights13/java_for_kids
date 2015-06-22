import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by imusiievych on 6/8/15.
 */
public class Score implements Serializable {

    String name;
    int score;
    LocalDateTime date;

    Score (String name, int score, LocalDateTime date){

        this.name = name;
        this.score = score;
        this.date = date;
    }

    public String toString(){
        return name + " scored " + score + " on " + date;
    }

}
