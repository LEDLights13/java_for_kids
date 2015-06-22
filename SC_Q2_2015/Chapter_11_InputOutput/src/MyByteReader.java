import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by imusiievych on 6/4/15.
 */
public class MyByteReader {

    public static void main(String[] args) throws IOException {

        String myText = new String(Files.readAllBytes(Paths.get("abc.dat")));

        List<String> myFileLines = Files.readAllLines(Paths.get("abc.dat"));

/*        try (FileInputStream myFile = new FileInputStream("abc.dat")){

            BufferedInputStream buff = new BufferedInputStream(myFile);
            int byteValue;

            while((byteValue = myFile.read()) != -1){
                System.out.print(byteValue + " ");
            }
        }
        catch (IOException ioe){
            System.out.println("Could bot rear fileL " + ioe.getMessage());

        }*/
        System.out.println();
        System.out.println(myText);

        for (String line: myFileLines){
            System.out.println();
        }
    }
}
