import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by imusiievych on 6/4/15.
 */
public class MyByteWriter {

    public static void main(String[] args) {

        int somedata[] = {11,12,123,143};

        try (FileOutputStream myOutFile = new FileOutputStream("xyz.dat")){
            int arrayLength = somedata.length;

            for (int i = 0; i < arrayLength; i ++){

                myOutFile.write(somedata[i]);
            }
        } catch (IOException ioe){
            System.out.println("Could not write into the file " + ioe.getMessage());
        }

    }
}
