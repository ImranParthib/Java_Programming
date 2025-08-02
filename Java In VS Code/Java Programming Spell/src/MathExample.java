import java.util.Scanner;

public class MathExample {
    public static void main(String[] args) {
        double height, base, hypotenuse;
        System.out.println("Enter Height of the Triangle =>");
        Scanner scanner = new Scanner(System.in);
        height = scanner.nextDouble();
        System.out.println("Enter Base of the Triangle =>");
        base = scanner.nextDouble();

        hypotenuse = Math.sqrt((height * height) + (base * base));
        System.out.println("The hypotenuse is: " + hypotenuse);
        scanner.close();
    }
}
