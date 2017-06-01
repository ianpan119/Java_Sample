// DoWhileTest.java
// Using the do/while repetition structure

public class DoWhileTest {
   public static void main(String[] args)
   {
      int counter = 1, total = 0;

      do {
         total += counter;
         System.out.println("count=" + counter + ";\ttotal=" + total);
         ++counter;
      } while ( counter <= 10 );
   }
}

