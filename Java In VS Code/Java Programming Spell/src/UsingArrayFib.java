import java.util.Scanner;

public class UsingArrayFib {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to choose an option
        System.out.println("Choose an option:");
        System.out.println("1. Display Fibonacci sequence up to the nth term");
        System.out.println("2. Display the value at a specific index in the Fibonacci sequence");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                // Prompt the user to enter the number of terms
                System.out.print("Enter the number of terms: ");
                int nthTerm = scanner.nextInt();
                displayFibonacciSequence(nthTerm);
                break;
            case 2:
                // Prompt the user to enter the index
                System.out.print("Enter the index to display value from Fibonacci sequence: ");
                int index = scanner.nextInt();
                int value = getFibonacciValueAtIndex(index);
                System.out.println("Value at index " + index + " in the Fibonacci sequence is: " + value);
                break;
            default:
                System.out.println("Invalid option.");
        }

        scanner.close();
    }

    // Method to display Fibonacci sequence up to nth term
    public static void displayFibonacciSequence(int nthTerm) {
        int[] fibonacciSequence = new int[nthTerm];
        fibonacciSequence[0] = 0;
        fibonacciSequence[1] = 1;
        System.out.print("Fibonacci Sequence: " + fibonacciSequence[0] + ", " + fibonacciSequence[1]);
        for (int i = 2; i < nthTerm; i++) {
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
            System.out.print(", " + fibonacciSequence[i]);
        }
        System.out.println();
    }

    // Method to get the value at a specific index in the Fibonacci sequence
    public static int getFibonacciValueAtIndex(int index) {
        if (index <= 1) {
            return index;
        }
        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 2; i <= index; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
