/*23.for-each
traversing techniques to iterate through the element in array/collection less steps,
        more readable less flexible*/

import java.util.ArrayList;

public class ForEach {
    public static void main(String[] args) {

        String[] animals = {"Cats","Dog","Elephant"};

        for(String i : animals){
            System.out.println(i);
        }

        ArrayList<String> animalList = new ArrayList<>();

        animalList.add("Cats");
        animalList.add("DOG");
        animalList.add("Elephant");

        for(String j : animalList){
            System.out.println(j);
        }
    }
}
