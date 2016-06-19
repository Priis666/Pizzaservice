package Robin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 01.06.2016.
 */
public class Menu {

    private List<Pizza> menu;

    public Menu(){
        menu = new ArrayList<>();
        initMenu();
    }

    /**
     * initalizes the menu with content read from csv named "Menu.csv"
     */
    private void initMenu(){
        File csvFile = new File("src/Robin/Menu.csv");
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] csvContent = line.split(cvsSplitBy);

                List<Pizza.Ingredients> ingredients = new ArrayList<>();
                fillStandardIngredients(ingredients, csvContent);
                Pizza pizza = new Pizza(csvContent[0],ingredients, null );
                menu.add(pizza);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Pizza> getMenu() {
        return menu;
    }

    private void fillStandardIngredients(List<Pizza.Ingredients> list, String[] csvContent){
        for(int i = 1; i<csvContent.length - 1; i++){
            String content = csvContent[i].toLowerCase();
            switch(content){
                case "cheese": list.add(Pizza.Ingredients.CHEESE);
                    break;
                case "salami": list.add(Pizza.Ingredients.SALAMI);
                    break;
                case "onions": list.add(Pizza.Ingredients.ONIONS);
                    break;
                case "garlic": list.add(Pizza.Ingredients.GARLIC);
                    break;
                case "ham": list.add(Pizza.Ingredients.HAM);
                    break;
                case "bacon": list.add(Pizza.Ingredients.BACON);
                    break;
                case "pineapple": list.add(Pizza.Ingredients.PINEAPPLE);
                    break;
                case "mushrooms": list.add(Pizza.Ingredients.MUSHROOMS);
                    break;
                case "olives": list.add(Pizza.Ingredients.OLIVES);
                    break;
                case "peppers": list.add(Pizza.Ingredients.PEPPERS);
                    break;
                case "tuna": list.add(Pizza.Ingredients.TUNA);
                    break;
                case "tomato": list.add(Pizza.Ingredients.TOMATO);
                    break;
                case "chilipeppers": list.add(Pizza.Ingredients.CHILIPEPPERS);
                    break;

            }
        }

    }
}

