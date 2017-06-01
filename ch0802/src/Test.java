// Test.java
// Demonstrate when superclass and subclass
// constructors and finalizers are called.
public class Test {
   public static void main( String args[] )
   {
      Circle circle1, circle2;

      circle1 = new Circle( 4.5, 72, 29 );
      circle2 = new Circle( 10, 5, 5 );

      circle1 = null;  // mark for garbage collection
      circle2 = null;  // mark for garbage collection
      
      System.out.println("Before System.gc()-->circle1=" + circle1);
      System.out.println("Before System.gc()-->circle2=" + circle2);

      System.gc();     // call the garbage collector 
   }
}

