// Time.java
// Time class definition
import java.text.DecimalFormat;  // used for number formatting

// This class maintains the time in 24-hour format
public class Time extends Object {
   private int hour;     // 0 - 23
   private int minute;   // 0 - 59
   private int second;   // 0 - 59

   // Time constructor initializes each instance variable
   // to zero. Ensures that Time object starts in a 
   // consistent state.
   public Time() { setTime( 0, 0, 0 ); }

   // Set a new time value using universal time. Perform 
   // validity checks on the data. Set invalid values to zero.
   public void setTime( int h, int m, int s )
   {
      setHour( h );    // set the hour
      setMinute( m );  // set the minute
      setSecond( s );  // set the second
   }

   // set the hour 
   public void setHour( int h ) 
      { hour = ( ( h >= 0 && h < 24 ) ? h : 0 ); }

   // set the minute 
   public void setMinute( int m ) 
      { minute = ( ( m >= 0 && m < 60 ) ? m : 0 ); }

   // set the second 
   public void setSecond( int s ) 
      { second = ( ( s >= 0 && s < 60 ) ? s : 0 ); }

   // get the hour
   public int getHour() { return hour; }

   // get the minute
   public int getMinute() { return minute; }

   // get the second
   public int getSecond() { return second; }

   // Convert to String in standard-time format
   public String toString()
   {
      DecimalFormat twoDigits = new DecimalFormat( "00" );

      return ( ( getHour() == 12 || getHour() == 0 ) ? 
               12 : getHour() % 12 ) + ":" +
             twoDigits.format( getMinute() ) + ":" +
             twoDigits.format( getSecond() ) +
             ( getHour() < 12 ? " AM" : " PM" );
   }
}

