package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Stage stage;
    public VBox vbox;
    public VBox vbox2;
    public Button shoppingCartButton;
    private Menu menu;

    public Controller() {
        menu = new Menu();
    }

    /**
     * Dynamically inserts checkboxes and comboboxes into HBoxes, amounted to how many sorts of pizza there,
     * which are then inserted into two preset VBoxes
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //Dynamic assembling of hboxes, checkboxes and comboboxes
            ArrayList<Pizza> pizzaMenu = (ArrayList<Pizza>) menu.getMenu();
            pizzaMenu.forEach((pizza) -> System.out.println(pizza.getSort()));
            for (Pizza p : pizzaMenu) {
                CheckBox c = new CheckBox();
                ComboBox<Integer> quantity = new ComboBox<>();

                //insertion of hboxes containing checkboxes and comboboxes
                vbox.getChildren().add(c);
                vbox2.getChildren().add(quantity);
                vbox.setSpacing(16);
                vbox2.setSpacing(7);

                //Checkbox properties
                c.setSelected(false);
                c.setText(p.getSort() + " - " + p.getStandardIngredients().toString().replace("[", "").replace("]", ""));
                //Listener added to checkbox: for disabling and enabling quantity
                c.selectedProperty().addListener((v, oldValue, newValue) -> {
                    quantity.getSelectionModel().selectFirst();
                    for (int i = 0; i < quantity.getValue(); i++) Order.ORDER.delPizza(p);
                    for (int i = 0; i < quantity.getValue(); i++) Order.ORDER.addPizza(p);

                });

                //Combobox properties
                quantity.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                quantity.setMaxWidth(60);
                //Combobox enabled/disabled by binding to selectedProperty of checkbox
                quantity.disableProperty().bind(c.selectedProperty().not());
                //Listener added to combobox: if quantity changed delete previous and set new
                quantity.getSelectionModel().selectedItemProperty()
                        .addListener((v, oldValue, newValue) -> {
                            for (int i = 0; i < quantity.getItems().size(); i++) Order.ORDER.delPizza(p);
                            for (int i = 0; i < quantity.getValue(); i++) Order.ORDER.addPizza(p);
                        });

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Depending on if the user chose their order or not this either displays a pop-up window asking them
     * to give in their order or it brings them to the shopping cart
     *
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void reactToShoppingCartButton(ActionEvent actionEvent) throws IOException {
        if (Order.ORDER.getPizzaList().isEmpty()) {

            Stage stage;
            Parent root;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("sample4.fxml"));
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            //disables stage in background until dismissed
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(shoppingCartButton.getScene().getWindow());
            stage.show();
        }
        else {
            System.out.println(Order.ORDER.getPizzaList());

            Stage stage;
            Parent root;
            stage = (Stage) shoppingCartButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("sample2.fxml"));

            // start next view
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
