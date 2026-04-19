package hust.soict.hedspi.lab01;
import javax.swing.JOptionPane;
public class LinearEquation{
    public static void main(String[] args){
        String strNum1, strNum2;
        String result = "";
        
        strNum1 = JOptionPane.showInputDialog(null, 
                    "Please input the first number: ", "Input the first number",
                    JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null, 
                    "Please input the second number: ", "Input the second number",
                    JOptionPane.INFORMATION_MESSAGE);

        double a = Double.parseDouble(strNum1);
        double b = Double.parseDouble(strNum2);

        result += "Equation: " + a + "x + " + b + " = 0";

        if (a == 0) {
            if (b == 0) {
                result = "The equation has infinitely many solutions.";
            } else {
                result = "The equation has no solution.";
            }
        } else {
            double x = -b / a;
            result += "\nThe equation has one solution: x = " + x;
        }

        JOptionPane.showMessageDialog(null, result, 
                    "Answer", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}