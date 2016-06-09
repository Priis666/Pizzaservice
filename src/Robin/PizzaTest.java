package Robin;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Robin on 08.06.2016.
 */
public class PizzaTest {

    @Test
    public void pizzaEqualTest(){
        Pizza pizza1 = new Pizza("Thunfisch", new ArrayList<Pizza.Ingredients>(), new ArrayList<Pizza.Ingredients>());
        Pizza pizza2 = new Pizza("Thunfisch", new ArrayList<Pizza.Ingredients>(), new ArrayList<Pizza.Ingredients>());
        assert(pizza1.equals(pizza2));
    }

}
