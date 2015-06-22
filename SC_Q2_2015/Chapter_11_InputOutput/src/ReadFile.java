import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by imusiievych on 6/5/15.
 */
public class ReadFile {

    public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("Please, provide the correct number of arguments. For example: ");
            System.out.println("java ReadFile abcCopy.dat abc.dat");
        }

        Path destinationPath = Paths.get(args[1]);
        Path sourcePath = Paths.get(args[]);

        try{
            Files.copy(sourcePath, destinationPath);
            System.out.println("File was successfully copied!");

        }
        catch (IOException ioe){
            System.out.println("Can't copy the file " + ioe.getMessage());
        }


    }


}
