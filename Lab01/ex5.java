import javax.swing.JOptionPane;
public class ex5 {
    
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "";
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);
        if (num2 == 0){
            strNotification = "Number 2 mustn't be 0";
            JOptionPane.showMessageDialog(null,strNotification,"Show result",JOptionPane.INFORMATION_MESSAGE);
        } else{
        double sum = num1 + num2;
        double diff = num1 - num2;
        double prod = num1 * num2;
        double quoti = num1 / num2;
        strNotification += "Sum of " + num1 + " and " + num2 + " : " + sum + "\n";
        strNotification += "Difference of " + num1 + " and " + num2  + " : " + diff + "\n";
        strNotification += "Product of "  + num1 + " and " + num2 + " : "+ prod + "\n";
        strNotification += "Quotient of " + num1 + " and " + num2 + " : "+ + quoti + "\n";
        JOptionPane.showMessageDialog(null,strNotification,"Show result",JOptionPane.INFORMATION_MESSAGE);
        }
        System.exit(0);
    }
}
