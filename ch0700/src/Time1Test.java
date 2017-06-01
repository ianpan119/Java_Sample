// Time1Test.java
// Class TimeTest to exercise class Time1
import javax.swing.JOptionPane;

public class Time1Test {
   public static void main( String args[] )
   {
      Time1 t = new Time1();  // calls Time1 constructor
      String output;

      output = "The initial universal time is: " +
               t.toUniversalString() +
               "\nThe initial standard time is: " +
               t.toString() +
               "\nImplicit toString() call: " + t;

      t.setTime( 13, 27, 6 ); 
      output += "\n\nUniversal time after setTime is: " + 
                t.toUniversalString() +
                "\nStandard time after setTime is: " +
                t.toString();

      t.setTime( 99, 99, 99 );  // all invalid values
      output += "\n\nAfter attempting invalid settings: " + 
                "\nUniversal time: " + t.toUniversalString() +
                "\nStandard time: " + t.toString();

      JOptionPane.showMessageDialog( null, output,
         "Testing Class Time1",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }
}

