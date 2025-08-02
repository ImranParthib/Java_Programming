/*Method=a block of code that executed whenever it is called upon*/

public class Methods {
    public static void main(String[] args) {
        String name = "Imran Parthib";
        String color = "Red";
        int age = 23;
        hello(name, age, color);

        int x = 10;
        int y = 20;
        sum(x, y);
        int result = add(x,y);
        System.out.println(result);
    }

    static void hello(String name, int age, String color) {
        System.out.println("THis is my Learning Journey");
        System.out.println("My name is " + name);
        System.out.println("My favourite color " + color);
        System.out.println("My age is now " + age);
    }

    static void sum(int a, int b) {
        int sum = a + b;
        System.out.println(sum);
    }

    static int add(int a,int b){
        int c;
        c = a +b;
        return c;
//        return a +b;
    }
}
