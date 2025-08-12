import java.util.Objects;

/**
 * Utility class to swap two integers and return them as a pair.
 */
public class ValueSwaper {

    /**
     * Returns a new Pair with the values of a and b swapped.
     * Original inputs are not modified.
     *
     * @param a first integer
     * @param b second integer
     * @return Pair containing swapped values (a becomes b, b becomes a)
     */
    public static Pair swapValues(int a, int b) {
        return new Pair(b, a);
    }

    public static void main(String[] args) {
        int a = 10, b = 20;

        System.out.println(String.format("Before Swap: a=%d and b=%d", a, b));
        Pair swapped = swapValues(a, b);
        System.out.println(String.format("After Swap: a=%d and b=%d", swapped.first(), swapped.second()));
    }
}

/**
 * Immutable pair class to hold two integer values.
 */
final class Pair {
    private final int first;
    private final int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int first() {
        return first;
    }

    public int second() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Pair))
            return false;
        Pair pair = (Pair) o;
        return first == pair.first && second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}


//Just for exploration purpose!