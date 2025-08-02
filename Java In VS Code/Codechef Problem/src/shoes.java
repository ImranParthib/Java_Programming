import java.util.Scanner;

public class Shoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i <= t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            if (m > n) {
                int totalshoes = n;
                System.out.println(totalshoes);
            } 
            else {
                int totalshoes = (n * 2) - m;
                System.out.println(totalshoes);

            }

        }

    }
}
