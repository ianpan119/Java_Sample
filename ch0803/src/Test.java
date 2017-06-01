// Test.java
// Driver for Employee hierarchy
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Test {
   public static void main( String args[] )
   {
      Employee ref;  // superclass reference
      String output = "";

      Boss b = new Boss( "John", "Smith", 800.00 );
      CommissionWorker c =
         new CommissionWorker( "Sue", "Jones",
                               400.0, 3.0, 150);
      PieceWorker p =
         new PieceWorker( "Bob", "Lewis", 2.5, 200 );
      HourlyWorker h =
         new HourlyWorker( "Karen", "Price", 13.75, 40 );

      DecimalFormat precision2 = new DecimalFormat( "0.00" );

      ref = b;  // Employee reference to a Boss 
      output += ref.toString() + " earned $" +
                precision2.format( ref.earnings() ) + "\n" +
                b.toString() + " earned $" +
                precision2.format( b.earnings() ) + "\n";
   
      ref = c;  // Employee reference to a CommissionWorker
      output += ref.toString() + " earned $" +
                precision2.format( ref.earnings() ) + "\n" +
                c.toString() + " earned $" +
                precision2.format( c.earnings() ) + "\n";
   
      ref = p;  // Employee reference to a PieceWorker
      output += ref.toString() + " earned $" +
                precision2.format( ref.earnings() ) + "\n" +
                p.toString() + " earned $" +
                precision2.format( p.earnings() ) + "\n";
   
      ref = h;  // Employee reference to an HourlyWorker
      output += ref.toString() + " earned $" +
                precision2.format( ref.earnings() ) + "\n" +
                h.toString() + " earned $" +
                precision2.format( h.earnings() ) + "\n";
      //printEarnings(b);//額外補充多型
      //printEarnings(c);//額外補充多型
      JOptionPane.showMessageDialog( null, output,
         "Demonstrating Polymorphism",
         JOptionPane.INFORMATION_MESSAGE );
           
      System.exit( 0 );
   }
   //額外補充多型
   public static void printEarnings(Employee emp){
	   System.out.println(emp.toString()+ " earns:" + emp.earnings());
   }
}

