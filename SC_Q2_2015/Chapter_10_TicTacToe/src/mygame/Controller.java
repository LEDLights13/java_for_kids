package mygame;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    @FXML
    Button b1;
    @FXML
    Button b2;
    @FXML
    Button b3;
    @FXML
    Button b4;
    @FXML
    Button b5;
    @FXML
    Button b6;
    @FXML
    Button b7;
    @FXML
    Button b8;
    @FXML
    Button b9;

    @FXML
    GridPane gameBoard;



    private Boolean isFirstPlayer = true;

    public void clickedBtnHandler(ActionEvent evt) {

        Button clickedBtn = (Button) evt.getTarget();
        String btnContent = clickedBtn.getText();

        if ("".equals(btnContent) && isFirstPlayer && !find3InARow()) {

            clickedBtn.setText("x");
            isFirstPlayer = false;
            find3InARow();
        }

        if (find3InARow() == false){
            goComputer();
            find3InARow();
        }
    }

    public boolean find3InARow() {
        //Row 1
        if ("" != b1.getText() && b1.getText() == b2.getText() && b2.getText() == b3.getText()) {
            highlightWinningCombination(b1, b2, b3);
            return true;
        }
        //Row 2
        if ("" != b4.getText() && b4.getText() == b5.getText() && b5.getText() == b6.getText()) {
            highlightWinningCombination(b4, b5, b6);
            return true;
        }
        //Row3
        if ("" != b7.getText() && b7.getText() == b8.getText() && b8.getText() == b9.getText()) {
            highlightWinningCombination(b7, b8, b9);
            return true;
        }
        //Column 1
        if ("" != b1.getText() && b1.getText() == b4.getText() && b4.getText() == b7.getText()) {
            highlightWinningCombination(b1, b4, b7);
            return true;
        }
        //Column 2
        if ("" != b2.getText() && b2.getText() == b5.getText() && b5.getText() == b8.getText()) {
            highlightWinningCombination(b2, b5, b8);
            return true;
        }
        //Column 3
        if ("" != b3.getText() && b3.getText() == b6.getText() && b6.getText() == b9.getText()) {
            highlightWinningCombination(b3, b6, b9);
            return true;
        }
        //Diagonal up
        if ("" != b3.getText() && b3.getText() == b5.getText() && b5.getText() == b7.getText()) {
            highlightWinningCombination(b3, b5, b7);
            return true;
        }

        //Diagonal down
        if ("" != b1.getText() && b1.getText() == b5.getText() && b5.getText() == b9.getText()) {
            highlightWinningCombination(b1, b5, b9);
            return true;
        }
        return false;
    }

    public void highlightWinningCombination(Button btn1, Button btn2, Button btn3) {

        btn1.getStyleClass().add("winning-square");
        btn2.getStyleClass().add("winning-square");
        btn3.getStyleClass().add("winning-square");

//        applyFadetransition(btn1);
//        applyFadetransition(btn2);
//        applyFadetransition(btn3);

    }

    public void applyFadetransition(Button winningButton) {

        FadeTransition ft = new FadeTransition(Duration.millis(1000), winningButton);

        ft.setFromValue(1.0);
        ft.setToValue(0.2);
        ft.setCycleCount(10);
        ft.setAutoReverse(true);
        ft.play();
    }

    @FXML
    public void playNewGame(ActionEvent evt) {

        MenuItem clickedMenu = (MenuItem) evt.getTarget();
        String menuLabel = clickedMenu.getText();

        ArrayList<Button> buttons = new ArrayList<Button>(
                Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9)
        );
        if ("Play".equals(menuLabel)) {
            for (Button button : buttons) {
                clearBoard(button);
            }
        }
    }


    public void clearBoard(Button btn) {
        btn.setText("");
        btn.getStyleClass().remove("winning-square");
    }

    public void goComputer() {

        //find if there any two buttons with "O"s
        //row1
        if ("o" == b1.getText() && b1.getText() == b2.getText() && "" == b3.getText()) {
            b3.setText("o");
        }
        if ("o" == b2.getText() && b2.getText() == b3.getText() && "" == b1.getText()) {
            b1.setText("o");
        }
        if ("o" == b3.getText() && b3.getText() == b1.getText() && "" == b2.getText()) {
            b2.setText("o");
        }

        //row2
        if ("o" == b4.getText() && b4.getText() == b5.getText() && "" == b6.getText()) {
            b6.setText("o");
        }
        if ("o" == b5.getText() && b5.getText() == b6.getText() && "" == b4.getText()) {
            b4.setText("o");
        }
        if ("o" == b6.getText() && b6.getText() == b4.getText() && "" == b5.getText()) {
            b5.setText("o");
        }

        //row3
        if ("o" == b7.getText() && b7.getText() == b8.getText() && "" == b9.getText()) {
            b9.setText("o");
        }
        if ("o" == b8.getText() && b8.getText() == b9.getText() && "" == b7.getText()) {
            b7.setText("o");
        }
        if ("o" == b9.getText() && b9.getText() == b7.getText() && "" == b8.getText()) {
            b8.setText("o");
        }

        //column1
        if ("o" == b1.getText() && b1.getText() == b4.getText() && "" == b7.getText()) {
            b7.setText("o");
        }
        if ("o" == b4.getText() && b4.getText() == b7.getText() && "" == b1.getText()) {
            b1.setText("o");
        }
        if ("o" == b7.getText() && b7.getText() == b1.getText() && "" == b4.getText()) {
            b4.setText("o");
        }

        //column2
        if ("o" == b2.getText() && b2.getText() == b5.getText() && "" == b8.getText()) {
            b8.setText("o");
        }
        if ("o" == b5.getText() && b5.getText() == b8.getText() && "" == b2.getText()) {
            b2.setText("o");
        }
        if ("o" == b8.getText() && b8.getText() == b2.getText() && "" == b5.getText()) {
            b5.setText("o");
        }

        //column3
        if ("o" == b3.getText() && b3.getText() == b6.getText() && "" == b9.getText()) {
            b9.setText("o");
        }
        if ("o" == b6.getText() && b6.getText() == b9.getText() && "" == b3.getText()) {
            b3.setText("o");
        }
        if ("o" == b9.getText() && b9.getText() == b3.getText() && "" == b6.getText()) {
            b6.setText("o");
        }

        //diagonal up
        if ("o" == b7.getText() && b7.getText() == b5.getText() && "" == b3.getText()) {
            b3.setText("o");
        }
        if ("o" == b5.getText() && b5.getText() == b3.getText() && "" == b7.getText()) {
            b7.setText("o");
        }
        if ("o" == b3.getText() && b3.getText() == b7.getText() && "" == b5.getText()) {
            b5.setText("o");
        }

        //diagonal down
        if ("o" == b1.getText() && b1.getText() == b5.getText() && "" == b9.getText()) {
            b9.setText("o");
        }
        if ("o" == b5.getText() && b5.getText() == b9.getText() && "" == b1.getText()) {
            b1.setText("o");
        }
        if ("o" == b9.getText() && b9.getText() == b1.getText() && "" == b5.getText()) {
            b5.setText("o");
        }

        ArrayList<Button> buttons = new ArrayList<Button>(
                Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9)
        );
        for (int i = 0; i < buttons.size(); i++) {

            //Place a "O" next to another "O"
            if (buttons.get(i).getText() == "o") {
                if (i < 3 && buttons.get(i + 3).getText() == "") {
                    buttons.get(i + 3).setText("o");
                    System.out.println("inside first for");
                    break;

                } else if (i < 6 && i >= 3 && buttons.get(i + 3).getText() == "") {
                    buttons.get(i + 3).setText("o");
                    System.out.println("inside first elseif");
                    break;

                } else if (i < 9 && i >= 6 && buttons.get(i - 3).getText() == "") {
                    buttons.get(i - 3).setText("o");
                    System.out.println("inside second elseif");
                    break;

                }
            }
            //If no "O" are found try to place an "O" in the middle of the board,otherwise place "O" in the first blank button
            else if(buttons.get(4).getText() == ""){
                buttons.get(4).setText("o");
                break;

            }
            else if (buttons.get(i).getText() == ""){
                    buttons.get(i).setText("o");
                    break;
            }
        }
        isFirstPlayer = true;
    }

}










