// MethodOverload.java
// Using overloaded methods
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MethodOverload extends JFrame {
   JTextArea outputArea;

   public MethodOverload()
   {
      outputArea = new JTextArea( 2, 20 );
      Container c = getContentPane();
      c.add( outputArea );

      outputArea.setText(
         "The square of integer 7 is " + square( 7 ) +
         "\nThe square of double 7.5 is " + square( 7.5 ) );
   }
   
   public int square( int x )
   {
      return x * x;
   }
   
   public double square( double y )
   {
      return y * y;
   }
   
   public static void main( String[] args )
   {
	  MethodOverload win = new MethodOverload();
      win.setSize(300,200);
      win.setLocationRelativeTo(null);
      win.setVisible(true);
   }
}

