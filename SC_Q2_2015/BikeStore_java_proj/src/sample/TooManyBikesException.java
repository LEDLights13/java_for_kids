package sample;

import javafx.scene.control.TextField;

/**
 * Created by imusiievych on 6/2/15.
 */
public class TooManyBikesException extends Throwable {
    public TooManyBikesException(String s, TextField tfield) {
        super(s);
        tfield.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");

    }
}
