// ForCounter.java
// Counter-controlled repetition with the for structure

public class ForCounter {
   public static void main(String[] args )
   {
	  int total = 0;
      // Initialization, repetition condition and incrementing
      // are all included in the for structure header. 
      for ( int counter = 1; counter <= 10; counter++ ){ 
         total += counter;
         System.out.println("count=" + counter + ";\ttotal=" + total);
      }
   }
}

