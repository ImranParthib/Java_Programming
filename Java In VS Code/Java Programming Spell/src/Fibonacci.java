import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int term1,term2,nextTerm;
        long count;
        Scanner scanner = new Scanner(System.in);
        count = scanner.nextLong();

        term1 = 0;
        term2 = 1;

        System.out.print(term1+" "+term2);

        for(int i = 2;i<count;i++){
            nextTerm =term1 +term2;
            System.out.print(" "+nextTerm);

            term1 =term2;
            term2 = nextTerm;

        }
    }
}