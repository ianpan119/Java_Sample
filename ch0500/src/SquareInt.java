// SquareInt.java
// A programmer-defined square method
import javax.swing.*;

public class SquareInt extends JFrame {
   public SquareInt()
   { 
      String output = "";

      JTextArea outputArea = new JTextArea( 10, 20 );

      int result;

      for ( int x = 1; x <= 10; x++ ) {
         result = square( x );
         output += "The square of " + x +
                   " is " + result + "\n";
      }

      outputArea.setText( output );
      getContentPane().add(outputArea);      
   }
   
   // square method definition 
   public int square( int y )
   {
      return y * y;
   }
   
   public static void main( String[] args )
   {
      SquareInt win = new SquareInt();
      win.setSize(200,300);
      win.setLocationRelativeTo(null);
      win.setVisible(true);
   }
  
}

