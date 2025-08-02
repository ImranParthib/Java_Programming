import javax.swing.JOptionPane;

public class GUI {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Enter Your Name");
        JOptionPane.showMessageDialog(null,"Hello " +name);

        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Your Age"));
        JOptionPane.showMessageDialog(null,"I am " +age+"years old");

        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter Your height"));
        JOptionPane.showMessageDialog(null,"My height" +height+"Foot");

        String qualification = JOptionPane.showInputDialog("Enter Your CGPA");
        JOptionPane.showMessageDialog(null,"MY CGPA" +qualification);

        String favourite = JOptionPane.showInputDialog("Enter your Favourite Language");
        JOptionPane.showMessageDialog(null,"My Favorite Language" +favourite);
    }
}
