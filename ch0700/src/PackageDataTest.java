// PackageDataTest.java
// Classes in the same package (i.e., the same directory)
// can use package access data of other classes in the
// same package.
import javax.swing.JOptionPane;

public class PackageDataTest {
   public static void main( String args[] )
   {
      PackageData d = new PackageData();
      String output;

      output = "After instantiation:\n" + d.toString();

      d.x = 77;          // changing package access data
      d.s = "Good bye";  // changing package access data

      output += "\nAfter changing values:\n" + d.toString();
      JOptionPane.showMessageDialog( null, output,
         "Demonstrating Package Access",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }
}

class PackageData {
   int x;     // package access instance variable
   String s;  // package access instance variable

   // constructor
   public PackageData() 
   { 
      x = 0; 
      s = "Hello";
   }               

   public String toString() 
   {
      return "x: " + x + "    s: " + s;
   }
}
