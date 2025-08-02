import java.util.Scanner;

public class Shoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int totalshoes;
        for (int i = 0; i <= t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if(m>n){
                totalshoes = n;
                System.out.println(totalshoes);
            }
            else{
                totalshoes = (n * 2) - m;
                System.out.println(totalshoes);
            }
        }

    }
}
