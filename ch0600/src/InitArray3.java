// InitArray3.java
// Initializing multidimensional arrays
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class InitArray3 extends JFrame {
   JTextArea outputArea;
  
   public InitArray3()
   {
      outputArea = new JTextArea();
      Container c = getContentPane();
      c.add( outputArea );

      int array1[][] = { { 1, 2, 3 }, { 4, 5, 6 } };        
      int array2[][] = { { 1, 2 }, { 3 }, { 4, 5, 6 } }; 

      outputArea.setText( "Values in array1 by row are\n" );
      buildOutput( array1 );
   
      outputArea.append( "\nValues in array2 by row are\n" );
      buildOutput( array2 );
   }

   public void buildOutput( int a[][] )
   {
      for ( int i = 0; i < a.length; i++ ) {

         for ( int j = 0; j < a[ i ].length; j++ )  
            outputArea.append( a[ i ][ j ] + "  " );

         outputArea.append( "\n" );
      }
   }
   
   public static void main( String[] args )
   {
      InitArray3 win = new InitArray3();
      win.setSize(300,300);      
      win.setLocationRelativeTo(null); 
      win.setVisible(true);
   }
}

