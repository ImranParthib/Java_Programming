import java.util.Scanner;
//14.Nested Loop
//loop inside a loop
public class NestedLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows;
        System.out.println("Enter the number of rows");
        rows = scanner.nextInt();
        int columns;
        System.out.println("Enter the number of columns");
        columns = scanner.nextInt();
        String symbol;
        System.out.println("Enter the symbol");
        symbol = scanner.next();

        for(int i = 1; i<=rows; i++){
            System.out.println();
            System.out.println();
            for (int j = 1; j <= columns; j++){
                System.out.print(symbol);
            }
        }
    }
}
