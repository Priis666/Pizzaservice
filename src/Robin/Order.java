package Robin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 01.06.2016.
 */
public class Order {

    private double endPrice;
    private List<Pizza> order;

    private Order() {
        order = new ArrayList<>();
        endPrice = 0;
    }

    /**
     * Use method to add a Pizza to the final order
     *
     * @param pizza the pizza to add
     */
    public void addPizza(Pizza pizza) {
        order.add(pizza);
    }

    /**
     * Use method to delete the given pizza from the order
     *
     * @param pizza the pizza to delete
     * @return true if deleting was successful, false if pizza wasn´t in the list
     */
    public boolean delPizza(Pizza pizza) {
        //TODO
        if(order.equals(pizza)!= true){
            order.remove(pizza);
        }
        return false;
    }

    public double getEndPrice() {
        for (Pizza pizza : order) {
            endPrice = endPrice + pizza.getPrice();
        }
        return endPrice;
    }

    public List<Pizza> getPizzaList(){
        return this.order;
    }

}
