// Point.java
// Definition of class Point
public class Point extends Object {
   protected int x, y; // coordinates of the Point

   // no-argument constructor
   public Point() 
   { 
      x = 0;
      y = 0;
      System.out.println( "Point constructor: " + this );
   }

   // constructor
   public Point( int a, int b ) 
   { 
      x = a;
      y = b;
      System.out.println( "Point constructor: " + this );
   }

   // finalizer
   protected void finalize() 
   {
      System.out.println( "Point finalizer: " + this );
   }

   // convert the point into a String representation
   public String toString() 
      { return "[" + x + ", " + y + "]"; }
}

