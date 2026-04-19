import javax.swing.JOptionPane;
public class DoubleNumbers{
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "";
        
        strNum1 = JOptionPane.showInputDialog(null, 
                    "Please input the first number: ", "Input the first number",
                    JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null, 
                    "Please input the second number: ", "Input the second number",
                    JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        
        strNotification += "Sum: " + (num1 + num2) 
                        + " \nDifference: " + (num1 - num2)
                        + "\nProduct: " + (num1 * num2);

        if (num2 != 0) {
            strNotification += "\nQuotient: " + (num1 / num2);
        } else {
            strNotification += "\nQuotient: Cannot divide by zero!";
        }

        JOptionPane.showMessageDialog(null, strNotification, 
                    "Answer", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}