import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by imusiievych on 6/8/15.
 */
public class ScoreManager {

    public static void main(String[] args) throws IOException {

        List<Score> scores = new ArrayList<>();
        Path path = Paths.get("scores.ser");

        if(Files.exists(path)){
            scores = loadScores(path);
        }
        else{
            scores = new ArrayList<>();
        }

        Random numberGener = new Random();
        Score myScore = new Score("Inna", numberGener.nextInt(50000), LocalDateTime.now());

        scores.add(myScore);

        System.out.println("All scores:");
        scores.forEach(s ->System.out.println(s));

        saveScores(path, scores);

        System.out.println("Sorted scores (highest on top):");
        Comparator<Score> byScoreDescending =
                Collections.reverseOrder(Comparator.comparing(s -> s.score));

        scores.stream()
                .sorted(byScoreDescending)
                .forEach(s -> System.out.println(s));

        List<Score> scores_2 = loadScores(path);
        System.out.println("Trying to iterate through scores 2");
        scores.forEach(s -> System.out.println(s));
    }

    public static void saveScores(Path path, List<Score> scores) {


        try {
            if (Files.exists(path)) {
                ObjectOutputStream whereToWrite = new ObjectOutputStream(Files.newOutputStream(path, StandardOpenOption.APPEND));
                whereToWrite.writeObject(scores);
            } else {
                ObjectOutputStream whereToWrite = new ObjectOutputStream(Files.newOutputStream(path, StandardOpenOption.CREATE));
                whereToWrite.writeObject(scores);
            }
        } catch (IOException ioe) {
            System.out.println("Can't serialize scores: " + ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    public static List<Score> loadScores(Path path){

        List<Score> loadedScores = null;
        try(ObjectInputStream loadedScoresFile = new ObjectInputStream(Files.newInputStream(path))){

            loadedScores = (List<Score>) loadedScoresFile.readObject();

        }
        catch (IOException ioe){
            System.out.println("Can't deserialize object");
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Can't find the declaration of Score: " + cnfe.getMessage());
        }
        return loadedScores;
    }
}
