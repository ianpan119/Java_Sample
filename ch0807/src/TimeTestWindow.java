// TimeTestWindow.java
// Demonstrating the Time class set and get methods
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimeTestWindow extends JFrame {
   private Time t;
   private JLabel hourLabel, minuteLabel, secondLabel;
   private JTextField hourField, minuteField,
                      secondField, display;

   public TimeTestWindow()
   {
      super( "Inner Class Demonstration" );

      t = new Time();

      Container c = getContentPane();

      c.setLayout( new FlowLayout() );
      hourLabel = new JLabel( "Set Hour" );
      hourField = new JTextField( 10 );
      hourField.addActionListener( 
         new ActionListener() {  // anonymous inner class
            public void actionPerformed( ActionEvent e )
            {
               t.setHour(
                  Integer.parseInt( e.getActionCommand() ) );
               hourField.setText( "" );
               displayTime();
            }
         }
      );
      c.add( hourLabel );
      c.add( hourField );

      minuteLabel = new JLabel( "Set minute" );
      minuteField = new JTextField( 10 );
      minuteField.addActionListener( 
         new ActionListener() {  // anonymous inner class
            public void actionPerformed( ActionEvent e )
            {
               t.setMinute(
                  Integer.parseInt( e.getActionCommand() ) );
               minuteField.setText( "" );
               displayTime();
            }
         }
      );
      c.add( minuteLabel );
      c.add( minuteField );

      secondLabel = new JLabel( "Set Second" );
      secondField = new JTextField( 10 );
      secondField.addActionListener( 
         new ActionListener() {  // anonymous inner class
            public void actionPerformed( ActionEvent e )
            {
               t.setSecond(
                  Integer.parseInt( e.getActionCommand() ) );
               secondField.setText( "" );
               displayTime();
            }
         }
      );
      c.add( secondLabel );
      c.add( secondField );

      display = new JTextField( 30 );
      display.setEditable( false );
      c.add( display );
   }

   public void displayTime()
   {
      display.setText( "The time is: " + t );
   }

   public static void main( String args[] )
   {
      TimeTestWindow window = new TimeTestWindow();

      window.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.exit( 0 );
            }
         }
      );

      window.setSize( 400, 120 );
      window.setVisible(true);
   }
}

