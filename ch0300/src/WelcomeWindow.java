// WelcomeWindow.java
// A first window in Java

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;

public class WelcomeWindow extends JFrame {  
  
   public WelcomeWindow()//constructor
   {
	   JLabel label = new JLabel("Welcome to Java Programming");
	   Container c = getContentPane();
	   c.add(label);
   }
   public static void main(String[] args){
	   WelcomeWindow win = new WelcomeWindow();
	   win.setSize(300,150);
	   win.setLocationRelativeTo(null);
	   win.setVisible(true);
   }
}