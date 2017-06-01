// Increment.java
// Preincrementing and postincrementing

public class Increment {
   public static void main( String args[] )
   {
      int c;
   
      c = 5;
      System.out.println( c );   // print 5
      System.out.println( c++ ); // print 5 then postincrement
      System.out.println( c );   // print 6

      System.out.println();      // skip a line

      c = 5;
      System.out.println( c );   // print 5
      System.out.println( ++c ); // preincrement then print 6
      System.out.println( c );   // print 6
   }
}

