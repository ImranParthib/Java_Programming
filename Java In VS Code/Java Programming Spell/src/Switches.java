import java.util.Scanner;

public class Switches {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n =7;
        while(n-->0){
            String day;
            day = sc.nextLine();

            switch(day){
                case "Saturday":
                    System.out.println("This is Saturday");
                    break;
                case "Sunday":
                    System.out.println("This is Sunday");
                    break;
                case "Monday":
                    System.out.println("This is Monday");
                    break;
                case "Tuesday":
                    System.out.println("This is Tuesday");
                    break;
                case "Wednesday":
                    System.out.println("This is Wednesday");
                    break;
                case "Thursday":
                    System.out.println("This is Thursday");
                    break;
                case "Friday":
                    System.out.println("This is Friday");
                    break;
                default:
                    System.out.println("Enter Valid Day");
            }
        }
    }
}
