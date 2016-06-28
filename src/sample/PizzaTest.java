package Robin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;

/**
 * Created by Robin on 08.06.2016.
 */
public class PizzaTest {

    @Test
    public void pizzaEqualTest(){
        List<Pizza.Ingredients> sIngredients = new ArrayList<>();
        sIngredients.add(Pizza.Ingredients.BACON);
        sIngredients.add(Pizza.Ingredients.CHEESE);
        Pizza pizza1 = new Pizza("Thunfisch", sIngredients, null);
        Pizza pizza2 = new Pizza("Thunfisch", sIngredients, null);
        assert(pizza1.equals(pizza2));
    }

    @Test
    public void negativePizzaEqualTest(){
        List<Pizza.Ingredients> sIngredients1 = new ArrayList<>();
        sIngredients1.add(Pizza.Ingredients.BACON);
        sIngredients1.add(Pizza.Ingredients.CHEESE);
        List<Pizza.Ingredients> sIngredients2 = new ArrayList<>();
        sIngredients2.add(Pizza.Ingredients.BACON);
        sIngredients2.add(Pizza.Ingredients.PEPPERS);
        Pizza pizza1 = new Pizza("Thunfisch", sIngredients1, null);
        Pizza pizza2 = new Pizza("Thunfisch", sIngredients2, null);
        assertFalse(pizza1.equals(pizza2));
    }

}
