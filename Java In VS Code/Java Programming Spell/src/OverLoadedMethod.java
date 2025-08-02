/*23.Overloaded method = methods that share the same name but hace different parameters
method + parameters = method signature*/
public class OverLoadedMethod {
    static int sum(int a, int b, int c) {

        return a + b + c;

    }

    static int sum(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    public static void main(String[] args) {
        int a, b, c, d;
        a = 2;
        b = 4;
        c = 67;
        d = 56;
        int result1 = sum(a, b, c);
        int result2 = sum(a, b, c, d);
        System.out.println(result1);
        System.out.println(result2);
    }
}
