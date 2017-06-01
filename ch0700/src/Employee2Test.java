// Employee2Test.java
// Test Employee class with static class variable,
// static class method, and dynamic memory.
import javax.swing.*;

public class Employee2Test {
   public static void main( String args[] )
   {
      String output;

      output = "Employees before instantiation: " +
               Employee2.getCount();

      Employee2 e1 = new Employee2( "Susan", "Baker" );
      Employee2 e2 = new Employee2( "Bob", "Jones" );
   
      output += "\n\nEmployees after instantiation: " +
                "\nvia e1.getCount(): " + e1.getCount() +
                "\nvia e2.getCount(): " + e2.getCount() +
                "\nvia Employee2.getCount(): " +
                Employee2.getCount();
   
      output += "\n\nEmployee 1: " + e1.getFirstName() +
                " " + e1.getLastName() +
                "\nEmployee 2: " + e2.getFirstName() +
                " " + e2.getLastName();

      // mark objects referred to by e1 and e2
      // for garbage collection
      e1 = null;  
      e2 = null;

      System.gc(); // suggest that garbage collector be called

      output += "\n\nEmployees after System.gc(): " +
                Employee2.getCount();

      JOptionPane.showMessageDialog( null, output,
         "Static Members and Garbage Collection",
         JOptionPane.INFORMATION_MESSAGE );
      System.exit( 0 );
   }
}

