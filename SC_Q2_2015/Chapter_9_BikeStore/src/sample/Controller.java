package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private ComboBox<String> combo;

    @FXML
    private TextField quantity;

    @FXML
    private Label conf_message;

    @FXML
    void initialize() {
        combo.getItems().clear();
        combo.getItems().addAll("Kawasaki Ninja 300", "BMW S1000RR HP4", "Victory Judge", "Harley-Davidson Seventy-Two");
        combo.setValue("BMW S1000RR HP4");
    }

    public void validateOrder(ActionEvent evt) {
        String selectedModel = combo.getSelectionModel().getSelectedItem();
        String selectedQuantity = quantity.getText();

        try {
            Integer quantity_1 = Integer.parseInt(selectedQuantity);
            System.out.println(quantity);

            try {
                validateOrder_2(selectedModel, quantity_1);
                quantity.setStyle("-fx-border-color: green ; -fx-border-width: 1px ;");
                conf_message.setText("Your order is complete.");
            }
            catch(TooManyBikesException bikesException){
                conf_message.setText(bikesException.getMessage());
            }

        } catch (NumberFormatException exc) {
            System.out.println("Integers only as a quantity, please");
            quantity.clear();
            quantity.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            conf_message.setText("Integers only as a quantity, please");
        }
    }

    void validateOrder_2(String bikeModel, int quantity_2) throws TooManyBikesException {
        if ((bikeModel.contains("Kawasaki") && quantity_2 <=5) || (bikeModel.contains("BMW") && quantity_2 <=7)
                || (bikeModel.contains("David") && quantity_2 <=3) || (bikeModel.contains("Victory") && quantity_2 <=10))
        {
            conf_message.setText("Your order is complete.");

            System.out.println("Your order is successfully accepted.");
        }
        else{
        throw new TooManyBikesException("Can not ship " + quantity_2 + " bikes of the model \n" + bikeModel + "\nin one shipment", quantity);}

    }
}


