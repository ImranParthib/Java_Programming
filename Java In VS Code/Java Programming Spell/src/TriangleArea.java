import javax.swing.event.HyperlinkEvent;
import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {

        double base;
        Scanner scanner = new Scanner(System.in);
        base = scanner.nextDouble();

        double height;
        height = scanner.nextDouble();
        double hypotenuse;

        hypotenuse = Math.sqrt((base*base)+(height*height));
        System.out.println(hypotenuse);
    }
}
