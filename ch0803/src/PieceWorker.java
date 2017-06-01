// PieceWorker.java
// PieceWorker class derived from Employee

public final class PieceWorker extends Employee {
   private double wagePerPiece; // wage per piece output
   private int quantity;        // output for week

   // Constructor for class PieceWorker
   public PieceWorker( String first, String last,
                       double w, int q )
   {
      super( first, last );  // call superclass constructor
      setWage( w );
      setQuantity( q );
   }
   
   // Set the wage
   public void setWage( double w ) 
      { wagePerPiece = ( w > 0 ? w : 0 ); }
   
   // Set the number of items output
   public void setQuantity( int q ) 
      { quantity = ( q > 0 ? q : 0 ); }
   
   // Determine the PieceWorker's earnings
   public double earnings()
      { return quantity * wagePerPiece; }
   
   public String toString()
   {
      return "Piece worker: " + super.toString();
   }  
}

