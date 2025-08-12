import java.util.Arrays;

public class SwapValue {

    private static int[] swapMethod(int a, int b) {
        int c = a;
        a = b;
        b = c;
        return new int[] { a, b };
    }

    public static void main(String[] args) {
        int a = 10, b = 20;
        int[] result = swapMethod(a, b);
        // System.out.println(Arrays.toString(result));
        System.out.println("Before Swap " + "a:" + a + " and " + "b:" + b);
        System.out.println("After Swap " + "a:" + result[0] + " and " + "b:" + result[1]);
    }
}

// Overall, this is a 9/10 for learning and clarity