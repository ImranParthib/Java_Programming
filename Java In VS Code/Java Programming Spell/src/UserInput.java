import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Name Here:");
        String name = scanner.nextLine();
        System.out.println("Enter the age here :");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("My Favourite Food");
        String food = scanner.nextLine();
        System.out.println("My name is " + name);
        System.out.println("I have used my " + age + " years of Life");
        System.out.println("My favourite food is " +food);
    }
}
