// Boss.java
// Boss class derived from Employee

public final class Boss extends Employee {
   private double weeklySalary; 

   // Constructor for class Boss
   public Boss( String first, String last, double s)
   {
      super( first, last );  // call superclass constructor
      setWeeklySalary( s );
   }
   
   // Set the Boss's salary
   public void setWeeklySalary( double s )
      { weeklySalary = ( s > 0 ? s : 0 ); }
   
   // Get the Boss's pay
   public double earnings() { return weeklySalary; }
   
   // Print the Boss's name 
   public String toString() 
   {
      return "Boss: " + super.toString();
   }
}

