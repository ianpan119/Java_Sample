// Circle.java
// Definition of class Circle
public class Circle extends Point {  // inherits from Point
   protected double radius;

   // no-argument constructor
   public Circle()
   {
      // implicit call to superclass constructor here
      radius = 0;        
      System.out.println( "Circle constructor: " + this );
   }

   // Constructor
   public Circle( double r, int a, int b )
   {
      super( a, b );  // call the superclass constructor
      radius = r;  
      System.out.println( "Circle constructor: " + this );
   }

   // finalizer
   protected void finalize() 
   {
      System.out.println( "Circle finalizer: " + this );
      super.finalize();  // call superclass finalize method
   }

   // convert the Circle to a String
   public String toString()
   {
      return "Center = " + super.toString() +
             "; Radius = " + radius;
   }
}

