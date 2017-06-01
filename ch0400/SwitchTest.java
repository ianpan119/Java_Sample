// SwitchTest.java
// Drawing shapes
import javax.swing.JOptionPane;

public class SwitchTest {     

   public static void main(String[] args)
   {
      String input;
      int choice; 

      while(true){
	      input = JOptionPane.showInputDialog( 
	                 "Enter 1 to print greetings in Chinese\n" +
	                 "Enter 2 to print greetings in English\n" +
	                 "Enter 3 to print greetings in Japanese\n"+
	                 "Enter 4 to quit");	      
	
	      choice = Integer.parseInt( input );
	      
	      switch( choice ) {
	      	case 1:            
	            JOptionPane.showMessageDialog( null, "歡迎光臨 !" );
	      		break;
	        case 2:
	        	JOptionPane.showMessageDialog( null, "Welcome !" );
	            break;
	        case 3:        	 
	        	JOptionPane.showMessageDialog( null, "ようこそ !" );
	            break;
	        case 4:
	        	System.exit(0);
	        default:
	            JOptionPane.showMessageDialog( null, "Invalid value entered" );
	      } // end switch
	      
      }
   }
   
} // end class SwitchTest

