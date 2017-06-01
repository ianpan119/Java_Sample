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
   private JButton exitButton;

   public TimeTestWindow()
   {
      super( "Inner Class Demonstration" );

      t = new Time();

      Container c = getContentPane();

      // create an instance of the inner class
      ActionEventHandler handler = new ActionEventHandler();

      c.setLayout( new FlowLayout() );
      hourLabel = new JLabel( "Set Hour" );
      hourField = new JTextField( 10 );
      hourField.addActionListener( handler );
      c.add( hourLabel );
      c.add( hourField );

      minuteLabel = new JLabel( "Set minute" );
      minuteField = new JTextField( 10 );
      minuteField.addActionListener( handler );
      c.add( minuteLabel );
      c.add( minuteField );

      secondLabel = new JLabel( "Set Second" );
      secondField = new JTextField( 10 );
      secondField.addActionListener( handler );
      c.add( secondLabel );
      c.add( secondField );

      display = new JTextField( 30 );
      display.setEditable( false );
      c.add( display );

      exitButton = new JButton( "Exit" );
      exitButton.addActionListener( handler );
      c.add( exitButton );
   }

   public void displayTime()
   {
      display.setText( "The time is: " + t );
   }

   public static void main( String args[] )
   {
      TimeTestWindow window = new TimeTestWindow();

      window.setSize( 400, 140 );
      window.setVisible(true);
   }

   // INNER CLASS DEFINITION FOR EVENT HANDLING
   private class ActionEventHandler implements ActionListener {
      public void actionPerformed( ActionEvent e )
      {
         if ( e.getSource() == exitButton )
            System.exit( 0 );   // terminate the application
         else if ( e.getSource() == hourField ) {
            t.setHour(
               Integer.parseInt( e.getActionCommand() ) );
            hourField.setText( "" );
         }
         else if ( e.getSource() == minuteField ) {
            t.setMinute(
               Integer.parseInt( e.getActionCommand() ) );
            minuteField.setText( "" );
         }
         else if ( e.getSource() == secondField ) {
            t.setSecond(
               Integer.parseInt( e.getActionCommand() ) );
            secondField.setText( "" );
         }

         displayTime();
      }
   }
}

