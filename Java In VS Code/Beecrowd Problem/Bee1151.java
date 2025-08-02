import java.util.Scanner;
public class Bee1151 {
    public static void main(String[] args) {
        int firstTerm, secondTerm, lastTerm, totalTerm;

        Scanner scanner = new Scanner(System.in);
        totalTerm = scanner.nextInt();

        firstTerm = 0;
        secondTerm = 1;
        System.out.print(firstTerm + " " + secondTerm);
        lastTerm = firstTerm + secondTerm;
        for (int i = 2; i < totalTerm; i++) {
            System.out.print(" " + lastTerm);
            firstTerm = secondTerm;
            secondTerm = lastTerm;
            lastTerm = firstTerm + secondTerm;
        }
        System.out.println();
         scanner.close();

    }
}
