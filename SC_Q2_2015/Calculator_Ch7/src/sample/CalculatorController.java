package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField calc_input;
    String enteredDigits = "";
    String prevValue = "";


    public void digitClickedHandler(ActionEvent evt){


        Button clickedButton = (Button) evt.getTarget();
        String clickedBtnlabel = clickedButton.getText();

        enteredDigits = enteredDigits + clickedBtnlabel;

        calc_input.appendText(clickedBtnlabel);

//        String v2 = calc_input.getText();

//        System.out.println("This is digit " + clickedBtnlabel);
//        System.out.println("This is entered digits from digits method " + enteredDigits);


    }

    public void operationClickHandler(ActionEvent evt){

        String v1 ="";
        Integer result = 0;
        Integer v1_int = 0;
        System.out.println("Operation Clicked");
        String next_value = enteredDigits;

        enteredDigits = "";
        String entered = calc_input.getText();
        String vFirst = entered.substring(1, entered.length());
        calc_input.clear();
        Button clickedButton = (Button) evt.getTarget();
        String clickedBtnlabel = clickedButton.getText();

        String operation = clickedBtnlabel;
        calc_input.appendText(operation);
        calc_input.clear();





//        Integer indexOfEnd = entered.indexOf(operation)-next_value.length()-1;
//        if( indexOfEnd >= 1){
//            v1 = entered.substring(0,indexOfEnd);
//            v1_int = Integer.parseInt(v1);
//            result = v1_int + Integer.parseInt(next_value);

 //       }
 //       else {v1 = next_value;}




//        System.out.println("Operation clicked is " + clickedBtnlabel);
//        System.out.println("calc_input in Op method is " + entered);
        System.out.println("vFirst in Op method is " + vFirst);
        System.out.println("next number is " + next_value);
        System.out.println("operation is: " + operation);


    }



}
