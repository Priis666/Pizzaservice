package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;

public class Controller2 implements Initializable {
    public AnchorPane mainPane;
    public TextField nameTextField;
    public TextField surnameTextField;
    public TextField streetTextField;
    public TextField houseNumberTextField;
    public TextField areaCodeTextField;
    public TextField cityTextField;
    public Button completeTransactionButton;
    public Label sumLabel;
    public Label labelMenu;
    public Label lblausgabe;
    public Button backToMenuButton;
    public ListView orderList;

    /**
     * Projects the order in a ListView and total sum in label
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Displays total sum of the order made
        sumLabel.setText("Summe: " + (Order.ORDER.getEndPrice()) + " €");
        lblausgabe.setText(Order.ORDER.getPizzaList().toString()
                .replace("[", "")
                .replace("]", "")
                .replace("{sort=", "")
                .replace("}", "")
                .replace("standardIngredients=", " Zutaten = ")
                .replace("additionalIngredients=", "")
                .replace("',", "' - ")
                .replace(", ,", " - ")
                .replace("=6.0,", " = 6.00 \n"));
        Map<String, Integer> sortedMap = sortByPizzaSort(Order.ORDER.getPizzaList());
        List<Pair<String, Integer>> pairs = Util.getPairs(sortedMap);
        for (Pair pair : pairs) {

            orderList.getItems().add(Util.buildAppropriateString(pair));
        }

    }


    /**
     * Depending on if the user wrote their address this either sends them to the last view
     * or a pop shows up to alert that not all information has been inserted
     *
     * @param actionEvent
     * @throws IOException
     */
    public void reactToCompleteTransactionButton(ActionEvent actionEvent) throws IOException {
        try {
            //Opens pop-up window if any textfield isn't filled with information
            if ((nameTextField.getText().isEmpty())
                    || (surnameTextField.getText().isEmpty())
                    || (streetTextField.getText().isEmpty())
                    || (houseNumberTextField.getText().isEmpty())
                    || (areaCodeTextField.getText().isEmpty())
                    || (cityTextField.getText().isEmpty())) {
                Stage stage;
                Parent root;
                stage = new Stage();
                root = FXMLLoader.load(getClass().getResource("sample4.fxml"));
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                //disables stage in background until dismissed
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(completeTransactionButton.getScene().getWindow());
                stage.show();
            }
            //Opens "Thank you" screen
            else {
                Customer.CUSTOMER.setCustomer(nameTextField.getText(),
                        surnameTextField.getText(),
                        streetTextField.getText(),
                        Integer.parseInt(String.valueOf(houseNumberTextField.getText())),
                        Integer.parseInt((String.valueOf((areaCodeTextField.getText())))),
                        cityTextField.getText());

                Order.ORDER.setPriceZero();
                Stage stage;
                Parent root;
                stage = (Stage) backToMenuButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("sample3.fxml"));

                // start next view
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Goes back to main menu
     * while doing that the previous order and sum are erased to reset the order
     *
     * @param actionEvent
     * @throws IOException
     */
    public void reactToBackToMenuButton(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage;
            Parent root;
            stage = (Stage) backToMenuButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));

            // start next view
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Clears previous order
        Order.ORDER.getPizzaList().clear();
        //sets total sum to 0
        Order.ORDER.setPriceZero();
    }

    private Map<String, Integer> sortByPizzaSort(List<Pizza> order) {
        Map<String, Integer> map = new HashMap<>();
        for (Pizza pizza : order) {
            String sort = pizza.getSort();
            Integer val = map.putIfAbsent(sort, 1);
            if (val != null)
                map.put(sort, ++val);
        }
        return map;
    }


    }
