import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by imusiievych on 6/8/15.
 */
public class GameStateManager {

    public static void main(String[] args) {

        GameState gameState = new GameState("Inna", 48, 12345, 3);

        Path path = Paths.get("gamestate.ser");
        saveGameState(path, gameState);
        System.out.println("The GameStateObject is serialized");

        GameState deserGameState = loadGameState(path);
        System.out.println("Deserialized game state; " + deserGameState);


    }

    private static void saveGameState(Path path, GameState gameState) {

        try (ObjectOutputStream whereToWrite = new ObjectOutputStream(Files.newOutputStream(path, StandardOpenOption.CREATE))){
            whereToWrite.writeObject(gameState);
        }
        catch (IOException ioe){
            System.out.println("Can't serialize file: " + ioe.getMessage());
        }
    }

    private static GameState loadGameState(Path path){

        GameState loadedGameState = null;
        try (ObjectInputStream whereToReadFrom = new ObjectInputStream(Files.newInputStream(path))){

            loadedGameState = (GameState) whereToReadFrom.readObject();

        }
        catch(IOException ioe){
            System.out.println("Can't deserialize file: " + ioe.getMessage());
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Can't find the declaration of GameState: " + cnfe.getMessage());
        }
        return loadedGameState;
    }


}
