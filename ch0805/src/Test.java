// Test.java
// Driver for point, circle, cylinder hierarchy
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Test {
   public static void main( String args[] )
   {
      Point point = new Point( 7, 11 );          
      Circle circle = new Circle( 3.5, 22, 8 );  
      Cylinder cylinder = new Cylinder( 10, 3.3, 10, 10 ); 

      Shape arrayOfShapes[];

      arrayOfShapes = new Shape[ 3 ];

      // aim arrayOfShapes[0] at subclass Point object
      arrayOfShapes[ 0 ] = point;

      // aim arrayOfShapes[1] at subclass Circle object
      arrayOfShapes[ 1 ] = circle;

      // aim arrayOfShapes[2] at subclass Cylinder object
      arrayOfShapes[ 2 ] = cylinder;  

      String output =
         point.getName() + ": " + point.toString() + "\n" +
         circle.getName() + ": " + circle.toString() + "\n" +
         cylinder.getName() + ": " + cylinder.toString();
   
      DecimalFormat precision2 = new DecimalFormat( "0.00" );

      // Loop through arrayOfShapes and print the name,
      // area, and volume of each object.
      for ( int i = 0; i < arrayOfShapes.length; i++ ) {
         output += "\n\n" +
            arrayOfShapes[ i ].getName() + ": " +
            arrayOfShapes[ i ].toString() +
            "\nArea = " +
            precision2.format( arrayOfShapes[ i ].area() ) +
            "\nVolume = " +
            precision2.format( arrayOfShapes[ i ].volume() );
      }

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating Polymorphism",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }
}

