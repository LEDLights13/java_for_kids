import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by imusiievych on 6/8/15.
 */
public class network {

    public static void main(String[] args) throws IOException {

        URL url = null;
        URLConnection urlconn = null;

        try{
            url = new URL("http://google.com");
            urlconn = url.openConnection();
        } catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
        try( InputStreamReader inStream =
                     new InputStreamReader(urlconn.getInputStream(), "UTF8");
             BufferedReader buff = new BufferedReader(inStream);){

            String currentLine;
            while((currentLine = buff.readLine()) != null){
                System.out.println(currentLine);

            }
        }catch(MalformedURLException murle){
            System.out.println("Check the spelling of the url: " + murle.getMessage());
        }
        catch(IOException ioex){
            System.out.println("Can't read from inet: " + ioex.getMessage());
        }
    }
}
