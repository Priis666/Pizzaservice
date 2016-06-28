package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;


public class Controller3 implements Initializable {
    public Label customerDataLabel;
    public Label orderLabel;
    public Label sumLabel;

    /**
     * Projects the order, final sum and inserted address of the user on "Thank you!"-view
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //Displays customer's information inserted in shopping cart
            customerDataLabel.setText(Customer.CUSTOMER.getName() + " " + Customer.CUSTOMER.getSurname() + "\n" +
                    Customer.CUSTOMER.getStreet() + " " + Customer.CUSTOMER.getHousenumber() + "\n" +
                    Customer.CUSTOMER.getAreacode() + " " + Customer.CUSTOMER.getCity());

            //Displays customer's order (pizza and price)
            orderLabel.setText(Order.ORDER.getPizzaList().toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace("{sort=", " ")
                    .replace("}", "")
                    .replace("standardIngredients=", "")
                    .replace("additionalIngredients=", "")
                    .replace("',", "' - ")
                    .replace(", ,", " - ")
                    .replace("price", "Preis: ")
                    .replace("=6.0,", " 6.00 €\n")
                    .replace("=6.0", " 6.00 €\n"));

            //Displays total sum
            sumLabel.setText("Summe: " + ((Order.ORDER.getEndPrice())) + " €");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
