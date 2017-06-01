// ContinueTest.java
// Using the continue statement in a for structure
import javax.swing.JOptionPane;

public class ContinueTest {
   public static void main( String args[] )
   {
      String output = "";

      for ( int count = 1; count <= 10; count++ ) {
         if ( count == 5 )
            continue;  // skip remaining code in loop
                       // only if count == 5

         output += count + " ";
      }

      output += "\nUsed continue to skip printing 5";

      JOptionPane.showMessageDialog( null, output );
      System.exit( 0 );
   }
}

