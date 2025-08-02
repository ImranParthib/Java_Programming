import java.util.Scanner;

//11.logical Operators
public class LogicalOperators {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Your are playing a game! Press q or Q to Quit");
        String response = scanner.next();
        if(!response.equals("q") && !response.equals("Q")){
            System.out.println("You are still playing the game");

        }
        else{
            System.out.println("You Quit the Game");
        }

    }


}
