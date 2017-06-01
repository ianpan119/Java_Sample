// Circle.java
// Definition of class Circle

public class Circle extends Point {  // inherits from Point
   protected double radius;

   // no-argument constructor
   public Circle()
   {
      // implicit call to superclass constructor here
      setRadius( 0 );  
   }

   // Constructor
   public Circle( double r, int a, int b )
   {
      super( a, b );  // call the superclass constructor
      setRadius( r );  
   }

   // Set radius of Circle
   public void setRadius( double r )
      { radius = ( r >= 0 ? r : 0 ); }

   // Get radius of Circle
   public double getRadius() { return radius; }

   // Calculate area of Circle
   public double area() { return Math.PI * radius * radius; }

   // convert the Circle to a String
   public String toString()
      { return "Center = " + super.toString() + 
               "; Radius = " + radius; }

   // return the class name
   public String getName() { return "Circle"; }
}

