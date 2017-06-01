// Point.java
// Definition of class Point

public class Point extends Shape {
   protected int x, y; // coordinates of the Point

   // no-argument constructor
   public Point() { setPoint( 0, 0 ); }

   // constructor
   public Point( int a, int b ) { setPoint( a, b ); }

   // Set x and y coordinates of Point
   public void setPoint( int a, int b )
   {
      x = a;
      y = b;
   }

   // get x coordinate
   public int getX() { return x; }

   // get y coordinate
   public int getY() { return y; }

   // convert the point into a String representation
   public String toString() 
      { return "[" + x + ", " + y + "]"; }

   // return the class name 
   public String getName() { return "Point"; }
}

