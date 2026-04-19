package hust.soict.hedspi.lab01;
import javax.swing.JOptionPane;

public class QuadraticEquation {
    public static void main(String[] args) {

        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));

        String result = "";

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    result = "The equation has infinitely many solutions.";
                } else {
                    result = "The equation has no solution.";
                }
            } else {
                double x = -c / b;
                result = "Linear equation solution: x = " + x;
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = "Two distinct solutions:\n"
                       + "x1 = " + x1 + "\n"
                       + "x2 = " + x2;
            } else if (delta == 0) {
                double x = -b / (2 * a);
                result = "Double root: x = " + x;
            } else {
                result = "The equation has no real solution.";
            }
        }

        JOptionPane.showMessageDialog(null, result,
                "Result", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}