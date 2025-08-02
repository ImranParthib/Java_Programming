//20. 2D ArrayList
import java.lang.reflect.Array;
import java.util.*;
public class Food2DList {
    public static void main(String[] args) {


        ArrayList<ArrayList<String>> groceryList = new ArrayList<>();

        ArrayList<String> bakeryList = new ArrayList<>();
        bakeryList.add("Pasta");
        bakeryList.add("Garlic Bread");
        bakeryList.add("Donuts");

        ArrayList<String> produceList = new ArrayList<>();
        produceList.add("tomatoes");
        produceList.add("zucchini");
        produceList.add("peppers");

        ArrayList<String> drinksList = new ArrayList<>();
        drinksList.add("Soda");
        drinksList.add("Coffee");

        groceryList.add(bakeryList);
        groceryList.add(produceList);
        groceryList.add(drinksList);

        System.out.println(drinksList);


        System.out.println(bakeryList);

        for(String foods : bakeryList ){
            System.out.println(foods);
        }
        System.out.println(bakeryList.get(0));
        System.out.println(bakeryList.size());

        System.out.println(groceryList);


//        Let's check some thinking in code

        String[] item = new String[3];

      for(int i = 0; i < item.length; i++){
          item[i]=groceryList.get(0).get(i);
      }
      for(String items : item){
          System.out.println(items);
      }
//      Hurray This is working



    }
}
