package Robin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Robin on 01.06.2016.
 */
public class Pizza {
    private static final double PRICE = 6.00;
    private static final double INGPRICE = 1.50;

    private String sort;
    private List<Ingredients> standardIngredients;
    private List<Ingredients> additionalIngredients;
    private double price;

    /**
     * Constructor for Pizza; sort and sIngredients have to be filled; aIngredients may be an empty List or null;
     *
     * @param sort Pizza´s sort
     * @param sIngredients Pizza´s standardingredients, gets filled at startup
     * @param aIngredients additional Ingredients depending on User´s choice
     */
    public Pizza(String sort, List<Ingredients> sIngredients, List<Ingredients> aIngredients) {
        this.sort = sort;
        this.standardIngredients = sIngredients;

        if(aIngredients == null){
            this.additionalIngredients = new ArrayList<>();
        }else{
            this.additionalIngredients = aIngredients;
        }
        this.price = computePizzaPrice();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pizza pizza = (Pizza) o;

        if (Double.compare(pizza.price, price) != 0) return false;
        if (!sort.equals(pizza.sort)) return false;
        if (!equalLists(standardIngredients,pizza.standardIngredients)) return false;
        return equalLists(additionalIngredients, pizza.additionalIngredients);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = sort.hashCode();
        result = 31 * result + standardIngredients.hashCode();
        result = 31 * result + additionalIngredients.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "sort='" + sort + '\'' +
                ", standardIngredients=" + standardIngredients +
                ", additionalIngredients=" + additionalIngredients +
                ", price=" + price +
                '}';
    }

    /**
     * custom method to compare two lists - used to compare the additionalIngredients
     * @param one list nr.1
     * @param two list nr.2
     * @return true if they are equal
     */
    private  boolean equalLists(List<Ingredients> one, List<Ingredients> two){
        if (one == null && two == null){
            return true;
        }

        if((one == null && two != null)
                || one != null && two == null
                || one.size() != two.size()){
            return false;
        }
        Collections.sort(one);
        Collections.sort(two);
        return one.equals(two);
    }

    public String getSort() {
        return sort;
    }
    public double getPrice(){ return price;}


    private double computePizzaPrice(){
        double additionalPrice = 0;
        if(additionalIngredients.size() != 0){
            additionalPrice = additionalIngredients.size() * INGPRICE;
        }
        return PRICE + additionalPrice;
    }

    public enum Ingredients {
        CHEESE ("Kaese"),
        SALAMI ("Salami"),
        ONIONS ("Zwiebeln"),
        GARLIC("Knoblauch"),
        HAM("Schinken"),
        BACON("Speck"),
        PINEAPPLE("Ananas"),
        MUSHROOMS("Pilze"),
        OLIVES("Oliven"),
        PEPPERS("Paprika"),
        TUNA("Thunfisch"),
        TOMATO("Tomaten"),
        CHILIPEPPERS("Peperoni");

        private final String name;

        private Ingredients(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return otherName != null && name.equals(otherName);
        }

        public String toString() {
            return this.name;
        }
    }
}