import java.util.Arrays;

public class DuplicateNum {
    public static void main(String[] args) {

        int[] numbers = { 1, 43, 6, 6, 78, 8, 6, 7, 7, 34, 6 };
        Arrays.sort(numbers);
        System.out.print("Duplicates: ");
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                System.out.print(numbers[i] + " ");
                // skip all duplicates of the same number
                while (i < numbers.length - 1 && numbers[i] == numbers[i + 1]) {
                    i++;
                }
            }
        }

    }
}
