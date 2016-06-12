package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Controller {
    private Stage stage;

    public TextFlow showSortiment;
    public Button shoppingCartButton;

    public TextFlow orderListText;
    public Label sumLabel;
    public TextField nameTextField;
    public TextField surnameTextField;
    public TextField streetTextField;
    public TextField houseNumberTextField;
    public TextField areaCodeTextField;
    public TextField cityTextField;
    public Button completeTransaction;


    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void reactToShoppingCartButton(ActionEvent actionEvent){
        try {
            // generate login controller from FXML;
            // Note: Implicitly calls method "initialize" if this has been implemented inside controller
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample2.fxml"));
            Parent view = (Parent) fxmlLoader.load();

            // start next view
            stage.setScene(new Scene(view));
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reactToCompleteTransaction(ActionEvent actionEvent) {
    }

    public void recieveName(ActionEvent actionEvent) {
    }

    public void recieveSurname(ActionEvent actionEvent) {
    }

    public void recieveStreet(ActionEvent actionEvent) {
    }

    public void recieveHouseNumber(ActionEvent actionEvent) {
    }

    public void recieveAreaCode(ActionEvent actionEvent) {
    }

    public void recieveCity(ActionEvent actionEvent) {
    }
}

