// Average1.java
// Class average program with counter-controlled repetition
import javax.swing.JOptionPane;

public class Average1 {
   public static void main( String args[] ) 
   {
      int total,          // sum of grades
          gradeCounter,   // number of grades entered
          gradeValue,     // grade value
          average;        // average of all grades
      String grade;       // grade typed by user
   
      // Initialization Phase
      total = 0;          // clear total
      gradeCounter = 1;   // prepare to loop
   
      // Processing Phase
      while ( gradeCounter <= 10 ) {  // loop 10 times

         // prompt for input and read grade from user
         grade = JOptionPane.showInputDialog(
                    "Enter integer grade: " );

         // convert grade from a String to an integer
         gradeValue = Integer.parseInt( grade );

         // add gradeValue to total
         total = total + gradeValue;  

         // add 1 to gradeCounter
         gradeCounter = gradeCounter + 1;
      }
   
      // Termination Phase
      average = total / 10;  // perform integer division

      // display average of exam grades
      JOptionPane.showMessageDialog(
         null, "Class average is " + average, "Class Average",
         JOptionPane.INFORMATION_MESSAGE );

       System.exit( 0 );      // terminate the program
   }
}

