import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by imusiievych on 6/9/15.
 *
 * Steps:
 *      0. Check the number of arguments
 *      1. URL instance
 *      2. Open connection for this url
 *      3. Write path to the local file
 *      4. Declare output stream
 *      5. Declare input stream
 *      6. Read byte form output and write it to the input
 *
 */
public class FileDownload {

    public static void main(String[] args) {

        if (args.length != 2){
            System.out.println("Wrong written command");
            System.out.println("Example: java FileDownload  " +
                    "http://freedownloads.last.fm/download/609315349/Lady%2BKillers%2B%2528feat.%2BHoodie%2BAllen%2529.mp3 " +
                    "test_song_1.mp3");
        }

        Path path = Paths.get(args[1]);
        URLConnection urlconn = null;
        try {

            URL url = new URL(args[0]);
            urlconn = url.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ioe){
            System.out.println("Can't connect" + ioe.getMessage());
        }

        try(OutputStream ouputTo = Files.newOutputStream(path);
            InputStream inputFrom = urlconn.getInputStream();){
            System.out.println("Downloading...");

            int data;
            while((data=inputFrom.read()) != -1){
                ouputTo.write(data);
            }
            System.out.println("Downloading is finished.");

        } catch (IOException ioe){
            System.out.println("Can't find a file" + ioe.getMessage());
        }


    }
}
