/*
16.2D Arrays
an arrays of arrays
*/
public class Arrays2D {
    public static void main(String[] args) {

       /*
       String[][] cars = new String[3][3];
        cars[0][0] = "Camaro";
        cars[0][1] = "Corvette";
        cars[0][2] = "Tesla";
        cars[1][0] = "Camaro";
        cars[1][1] = "Corvette";
        cars[1][2] = "Tesla";
        cars[2][0] = "Camaro";
        cars[2][1] = "Corvette";
        cars[2][2] = "Tesla";
        */

        String[][] cars = {
                {"Camaro", "Corvette", "Tesla"},
                {"Mustang", "Ranger", "F-150"},
                {"Ferrari", "Lambo", "Tesla"}
        };

        System.out.println(cars.length);

        for (String[] row : cars) {
            System.out.println();
            for (String car : row) {
                System.out.print(car+" ");
            }
        }


    }
}
