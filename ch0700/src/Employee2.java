// Employee2.java
// Declaration of the Employee class.
public class Employee2 extends Object {
   private String firstName;
   private String lastName;
   private static int count;  // # of objects in memory

   public Employee2( String fName, String lName )
   {
      firstName = fName;
      lastName = lName;

      ++count;  // increment static count of employees
      System.out.println( "Employee object constructor: " +
                          firstName + " " + lastName );
   }

   protected void finalize()
   {
      --count;  // decrement static count of employees
      System.out.println( "Employee object finalizer: " +
                          firstName + " " + lastName +
                          "; count = " + count );
   }

   public String getFirstName() { return firstName; }

   public String getLastName() { return lastName; }

   public static int getCount() { return count; } 
}

