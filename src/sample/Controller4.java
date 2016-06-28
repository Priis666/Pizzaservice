package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller4 implements Initializable {
    public Label errorLabel;
    public Button backToOriginalStage;

    /**
     * Label in pop-up asks the person to correct error shown
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //Checks if any orders have been made -> error for menu screen
            if (Order.ORDER.getPizzaList().isEmpty()) {
                errorLabel.setText("Es wurde keine Bestellung ausgewählt! \nBitte versuchen Sie es erneut");}
            //Error for not inserting whole address
            else {
                errorLabel.setText("Vollständige Adresse wurde nicht angegeben! \nBitte versuchen Sie es erneut");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Pop-up box dismisses itself and lets the user use previous view freely
     *
     * @param actionEvent
     * @throws IOException
     */
    public void reactToBackToCartButton(ActionEvent actionEvent) throws IOException {
        Stage stage;
        stage = (Stage) backToOriginalStage.getScene().getWindow();
        stage.close();
    }
}

