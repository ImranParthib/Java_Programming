/* 19.ArrayList = a resizable array.
                 Elements can be added and removed after compilation
                 phase store reference data types*/

import java.util.ArrayList;

public class FoodList {
    public static void main(String[] args) {

        ArrayList<String> food = new ArrayList<>();
        food.add("pizza");
        food.add("Hamburger");
        food.add("hotdog");


        food.set(0,"Sushi");
        food.remove(2);
        food.clear();

        for (int i = 0; i < food.size(); i++) {
            System.out.println(food.get(i));
        }
// ####Enhanced For Loop
        for (String foods : food) {
            System.out.println(foods);
        }

    }
}
