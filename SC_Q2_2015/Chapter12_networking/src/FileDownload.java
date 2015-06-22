import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by imusiievych on 6/9/15.
 */
public class FileDownload {

    public static void main(String[] args) {

        if (args.length!= 2){
            System.out.println("Please, enter two command line arguments.");
            System.out.println(
                    "For example: java FileDownload http://myflex.org/yf/nyc.jpg nyc.jpg");
            System.exit(-1);
        }

        URLConnection urlconn = null;
        try {
            URL url = new URL(args[0]);
            urlconn = url.openConnection();
        }
        catch (IOException ioe){
            System.out.println("Make sure that provided url is valid");
        }

        Path path = Paths.get("picture.jpg");

        try(OutputStream whereToWrite = Files.newOutputStream(path);
            InputStream whereWriteFrom = urlconn.getInputStream();){

            int data;

            while ((data=whereWriteFrom.read()) != -1){
                whereToWrite.write(data);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}
