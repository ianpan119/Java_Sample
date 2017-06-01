// Time1_2Test.java
// Class Time1_2Test to use imported class Time1_2
import javax.swing.JOptionPane;
import tw.org.iii.ch07.Time1_2;  // import Time1_2 class

public class Time1_2Test {
   public static void main( String args[] )
   {   
      Time1_2 t = new Time1_2();

      t.setTime( 13, 27, 06 );
      String output = 
         "Universal time is: " + t.toUniversalString() +
         "\nStandard time is: " + t.toString();

      JOptionPane.showMessageDialog( null, output,
         "Packaging Class Time1 for Reuse",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }
}

