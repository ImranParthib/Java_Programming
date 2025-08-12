public class Swap {

    private static int swapValue(int a, int b, int c) {

        if (c == 1) {
            int d = a;
            a = b;
            b = d;
            return a;
        } else {
            int d = a;
            a = b;
            b = d;
            return b;
        }

    }

    public static void main(String[] args) {
        System.out.println("Swap Variables");

        int a = 10, b = 20;

        int swapedA = swapValue(a, b, 1);
        int swapedB = swapValue(a, b, 2);
        System.out.println("a:" + swapedA + " b:" + swapedB);

    }
}

/*
 * Rating: 6/10
 * just for curiosity done this way!
 */