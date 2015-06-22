package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BikeStore extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("bikeStore.fxml"));
        primaryStage.setTitle("Bike Store");
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        scene.getStylesheets().add("sample/bikeCssFile.css");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
