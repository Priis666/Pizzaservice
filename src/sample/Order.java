package sample;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 01.06.2016.
 */
public class Order {
    public static Order ORDER = new Order();

    private float endPrice;
    private List<Pizza> order;

    //prevent instantiation
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
        if (order.contains(pizza)) {
            order.remove(pizza);
        }
        return false;
    }

    public float getEndPrice() {

        for (Pizza pizza : order) {
            endPrice = (float) (endPrice + pizza.getPrice());
        }
        return endPrice;
    }

    public List<Pizza> getPizzaList() {
        return order;
    }
    public void setPriceZero()
    {
        endPrice=0;
    }





}
