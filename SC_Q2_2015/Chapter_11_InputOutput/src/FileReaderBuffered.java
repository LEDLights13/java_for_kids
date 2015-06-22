import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by imusiievych on 6/5/15.
 */
public class FileReaderBuffered {
    public static void main(String[] args) {
        Path path = Paths.get("abc.dat");

        System.out.println("File absolute path is: " + path.toAbsolutePath());

        try {
            if (Files.exists(path)){
                System.out.println(Files.size(path));

                BufferedReader buff = Files.newBufferedReader(path, StandardCharsets.US_ASCII);

                String currentLine;

                while((currentLine = buff.readLine()) != null) {
                    System.out.println("Current line is: " + currentLine);
                }
            }

        }
        catch (IOException ioe){
            System.out.println("Can't read file: " + ioe.getMessage());

        }

        System.out.println("Your default character encoding is " + Charset.defaultCharset());
    }






}
