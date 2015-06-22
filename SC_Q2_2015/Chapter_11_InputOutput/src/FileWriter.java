import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

/**
 * Created by imusiievych on 6/5/15.
 */
public class FileWriter {

    public static void main(String[] args) {
        Path path = Paths.get("xyz_1.dat");

        System.out.println("The current directory is: " + System.getProperty("user.dir"));

        String myScore = "My score is 1010 and today is " + LocalDateTime.now() + "\n";

        try {
            if (Files.exists(path)){
        Files.write(path, myScore.getBytes(), StandardOpenOption.APPEND);}
            else {
                Files.write(path, myScore.getBytes(), StandardOpenOption.CREATE);
            }
        }

        catch (IOException ioe){
            System.out.println("Can't write to the file " + ioe.getMessage());
        }
    }
}
