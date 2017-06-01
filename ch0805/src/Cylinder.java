// Cylinder.java
// Definition of class Cylinder

public class Cylinder extends Circle {
   protected double height;  // height of Cylinder
   
   // no-argument constructor
   public Cylinder()      
   {
      // implicit call to superclass constructor here
      setHeight( 0 );
   }

   // constructor
   public Cylinder( double h, double r, int a, int b )      
   {
      super( r, a, b );   // call superclass constructor
      setHeight( h );
   }

   // Set height of Cylinder
   public void setHeight( double h )
      { height = ( h >= 0 ? h : 0 ); }
   
   // Get height of Cylinder
   public double getHeight() { return height; }

   // Calculate area of Cylinder (i.e., surface area)
   public double area()
   {
      return 2 * super.area() +
             2 * Math.PI * radius * height;
   }
   
   // Calculate volume of Cylinder
   public double volume() { return super.area() * height; }

   // Convert a Cylinder to a String
   public String toString()
      { return super.toString() + "; Height = " + height; }

   // Return the class name
   public String getName() { return "Cylinder"; }
}

