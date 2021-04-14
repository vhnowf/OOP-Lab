import javax.swing.JOptionPane;
public class ex6 {
    public static void main(String[] args){
        String stra,strb,strc;
        String stra_1,stra_2;
        String strb_1,strb_2;
        String strNotification;
        String menu;
        menu = "1. Linear equation with one variable \n";
        menu += "2. Linear equation with two variables \n";
        menu += "3. Quadratic equation \n";
        menu += "4. Exit \n";
        menu += "Please choose one of functions:";
        String strchoice = JOptionPane.showInputDialog(null,menu, "Menu", JOptionPane.INFORMATION_MESSAGE);
        double choice = Double.parseDouble(strchoice);
        while(choice !=4){
        if(choice == 1){
        stra = JOptionPane.showInputDialog(null, "Please input the first coefficient (a): ", "Given number", JOptionPane.INFORMATION_MESSAGE);
        strb = JOptionPane.showInputDialog(null, "Please input the second coefficient (b): ", "Given number", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(stra);
        double b = Double.parseDouble(strb);
        double x;
        if (a == 0){
            strNotification = "Warning: a=0. Please enter again!";
        } else{
            x = -b/a;
            strNotification = "Root of linear equation with one variable is: "  + x ;
        }
        } else if (choice == 2){
            stra_1 = JOptionPane.showInputDialog(null, "Please input the first coefficient (a11): ", "Input given number", JOptionPane.INFORMATION_MESSAGE);
            stra_2 = JOptionPane.showInputDialog(null, "Please input the second coefficient (a12): ", "Input given number", JOptionPane.INFORMATION_MESSAGE);
            stra = JOptionPane.showInputDialog(null, "Please input the fitth coefficient (b1): ", "Input given number", JOptionPane.INFORMATION_MESSAGE);
            strb_1 = JOptionPane.showInputDialog(null, "Please input the third coefficient (a21): ", "Input given number", JOptionPane.INFORMATION_MESSAGE);
            strb_2 = JOptionPane.showInputDialog(null, "Please input the fourth coefficient (a22): ", "Input given number", JOptionPane.INFORMATION_MESSAGE);
            strb = JOptionPane.showInputDialog(null, "Please input the sixth coefficient (b2): ", "Input given number", JOptionPane.INFORMATION_MESSAGE);
            double a = Double.parseDouble(stra_1);
            double b = Double.parseDouble(stra_2);
            double c = Double.parseDouble(strb_1);
            double d = Double.parseDouble(strb_2);
            double e = Double.parseDouble(stra);
            double f = Double.parseDouble(strb);
            double D, D_1, D_2;
            D =  a*d - c*b;
            D_1 = e*d - f*b;
            D_2 = a*f - c*e;
            double x_1, x_2;
            if(D != 0){
                x_1 = (D_1)/D;
                x_2 = (D_2)/D;
                strNotification = "The system has a unique solution is (x1,x2) = (" + x_1 + ", "+ x_2 +")"  ;
            }else if (D_1 == 0 && D_2 == 0){
                strNotification = "The system has infinitely many solutions";
            } else {
                strNotification = "The system has no solution.";
            }
        } else{
            stra = JOptionPane.showInputDialog(null, "Please input the first coefficient: ", "Input given number", JOptionPane.INFORMATION_MESSAGE);
            strb = JOptionPane.showInputDialog(null, "Please input the second coefficient: ", "Input given number", JOptionPane.INFORMATION_MESSAGE);
            strc = JOptionPane.showInputDialog(null, "Please input the third coefficient: ", "Input given number", JOptionPane.INFORMATION_MESSAGE);
            double a = Double.parseDouble(stra);
            double b = Double.parseDouble(strb);
            double c = Double.parseDouble(strc);
            double delta = b*b - 4*a*c;
            double x_1, x_2;
            if(delta > 0){
                x_1 = (double)((-b+Math.sqrt(delta))/(2*a));
                x_2 = (double)((-b-Math.sqrt(delta))/(2*a));
                strNotification = "The equation has two distinct roots: " + x_1 + " and" + x_2;
            }else if (delta == 0){
                x_1 = -b/(2*a);
                strNotification = "The equation has double roots: " + -b/(2*a);
            }else{
                strNotification = "The equation has no solution.";
            }
        }
    
        JOptionPane.showMessageDialog(null,strNotification,"Show result",JOptionPane.INFORMATION_MESSAGE);
        strchoice = JOptionPane.showInputDialog(null,menu, "Menu", JOptionPane.INFORMATION_MESSAGE);
        choice = Double.parseDouble(strchoice);
        
    }
    System.exit(0);
}
    
}
