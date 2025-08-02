import java.util.Scanner;

public class Fibonacci2 {
    public static void main(String[] args) {
        int firstNum, secondNum, lastNum;
        firstNum = 0;
        secondNum = 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total Term to Show:");
        int n = scanner.nextInt();

        System.out.println("Fibonacci Sequence:");

        System.out.print(firstNum + ",");
        System.out.print(secondNum);

        lastNum = firstNum + secondNum;
        for (int i = 2; i < n; i++) {
            System.out.print("," + lastNum);
            firstNum = secondNum;
            secondNum = lastNum;
            lastNum = firstNum + lastNum;
        }
        System.out.println();
        System.out.println("Enter NthNum to Show:");
        int nthNum = scanner.nextInt();
        System.out.println("Nth Term of The Fibonacci Series:");

        firstNum = 0;
        secondNum = 1;
        lastNum = firstNum + secondNum;
        for (int i = 3;i<nthNum;i++){
            firstNum = secondNum;
            secondNum = lastNum;
            lastNum = firstNum + lastNum;
        }
        System.out.println(lastNum);
    }
}

