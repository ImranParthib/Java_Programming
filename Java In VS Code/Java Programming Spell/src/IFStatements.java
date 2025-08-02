import java.util.Scanner;

//9.if statements
public class IFStatements {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        if (age >= 18) {
            System.out.println("You are an Adult");
        }
        else if (age <=17 && age >= 13) {
            System.out.println("You are a Teenager");
        }
        else {
            System.out.println("You are an child");
        }
    }
}
