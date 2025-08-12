import java.util.ArrayList;
import java.util.Arrays;

public class DuplicateNumbers {

    public static ArrayList<Integer> duplicateNumbers(ArrayList<Integer> num) {
        ArrayList<Integer> dupNum = new ArrayList<>();
        for (int i = 0; i < num.size(); i++) {
            for (int j = i + 1; j < num.size(); j++) {
                if (num.get(i).equals(num.get(j)) && !dupNum.contains(num.get(i))) {
                    dupNum.add(num.get(i));
                }
            }
        }
        return dupNum;
    }

    public static void main(String[] args) {
        System.out.println("Here is the duplicate numbers");

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 43, 6, 6, 78, 8, 8, 34, 6));

        ArrayList<Integer> result = duplicateNumbers(numbers);
        System.out.println("Duplicate Numbers: " + result);
    }
}
