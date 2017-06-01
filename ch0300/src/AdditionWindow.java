// AdditionWindow.java
// Adding two floating-point numbers
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;       

public class AdditionWindow extends JFrame {
   double sum;  // sum of the values entered by the user
   public AdditionWindow() //constructor
   {
      String firstNumber,   // first string entered by user
             secondNumber;  // second string entered by user
      double number1,       // first number to add
             number2;       // second number to add

      // read in first number from user
      firstNumber =
         JOptionPane.showInputDialog(
            "Enter first floating-point value" );

      // read in second number from user
      secondNumber =
         JOptionPane.showInputDialog(
            "Enter second floating-point value" );

      // convert numbers from type String to type double
      number1 = Double.parseDouble( firstNumber ); 
      number2 = Double.parseDouble( secondNumber );

      // add the numbers
      sum = number1 + number2;      
      
      displaySum();
   }
   
   public void displaySum(){
	   Container c = getContentPane();
	   JLabel label = new JLabel("The sum is " + sum, SwingConstants.CENTER);
	   label.setFont(new Font("²Ó©úÅé",Font.BOLD, 22));
	   c.add(label);	   
   }

   public static void main( String[] args )
   {
      AdditionWindow win = new AdditionWindow();
      win.setSize(300,150);
      win.setLocationRelativeTo(null);
      win.setVisible(true);
   }
}

