/*
12.While Loops
Execute a block of code as long as it's condition remains true
*/

import java.util.Scanner;

public class WhileLoops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";

        while (name.isBlank()) {
            System.out.println("Enter your Name");
            name = scanner.nextLine();
        }
        System.out.println("Hello " + name);
    }
}
