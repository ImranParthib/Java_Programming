public class Swap {

    public static int[] swap(int a, int b) {
        int c = a;
        a = b;
        b = c;
        return new int[] { a, b };
    }

    public static void main(String[] args) {
        int a = 10, b = 20;
        int[] result = swap(a, b);
        System.out.println("Value of a = " + result[0]);
        System.out.println("Value of b = " + result[1]);

    }
}

/*
 * public class Swap {
 * 
 * static class IntWrapper {
 * int value;
 * IntWrapper(int value) {
 * this.value = value;
 * }
 * }
 * 
 * private static void swap(IntWrapper a, IntWrapper b) {
 * int c = a.value;
 * a.value = b.value;
 * b.value = c;
 * }
 * 
 * public static void main(String[] args) {
 * IntWrapper a = new IntWrapper(10);
 * IntWrapper b = new IntWrapper(20);
 * swap(a, b);
 * System.out.println("a = " + a.value);
 * System.out.println("b = " + b.value);
 * }
 * }
 * 
 */