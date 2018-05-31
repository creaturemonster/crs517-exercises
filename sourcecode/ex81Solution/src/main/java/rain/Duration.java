package rain;

import javax.persistence.Embeddable;


/*
 *   TODO 
 *   
 *   Annotate this class as an Embeddable value object
 * 
 * 
 */


@Embeddable
public class Duration {

   
    /**
     *  The number of hours
     */
    protected int hours;

    /**
     *  The number of minutes
     */
    protected int minutes;


    /**
     *  The number of seconds
     */
    protected int seconds;

    /**
     *  Creates a Duration object with 0 hours, minutes and seconds.
     */
    public Duration() {
        this(0, 0, 0);
    }

    /**
     *  Creates a Duration object with given parameter values
     */
    public Duration(int theHours, int theMinutes, int theSeconds) {
        hours = theHours;
        minutes = theMinutes;
        seconds = theSeconds;
    }

    /**
     *  Creates a Duration object with given parameter values
     */
    public Duration(int totalSeconds) {
        hours = totalSeconds / 3600;
        int rem = totalSeconds - (hours * 3600);
        minutes = rem / 60;
        seconds = rem % 60;
    }

    /**
     *  Returns the hours portion of the duration
     */
    public int getHours() {
        return hours;
    }

    /**
     *  Returns the minutes portion of the duration
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     *  Returns the seconds portion of the duration.
     */
    public int getSeconds() {
        return seconds;
    }


    /**
     *  Sets the hours portion of the duration
     */
    public void setHours(int theHours) {
        hours=theHours;
    }

    /**
     *  Sets the minutes portion of the duration
     */
    public void setMinutes(int theMinutes) {
        minutes=theMinutes;
    }

    /**
     *  Sets the seconds portion of the duration
     */
    public void setSeconds(int theSeconds) {
        seconds=theSeconds;
    }

    /**
     *  Returns the total seconds
     */
    public int getTotalSeconds() {
        return seconds + (60 * (minutes + (60 * hours)));
    }

    /**
     *  Returns a new duration object that is the sum of the
     *  supplied Duration object and current object
     */
    public Duration add(Duration aDuration) {
        int total = getTotalSeconds() + aDuration.getTotalSeconds();
        return new Duration(total);
    }

    /**
     *  Returns a new duration object that is the difference of the
     *  supplied Duration and current object.  The difference returned is
     *  the absolute difference, so the duration will always be positive.
     */
    public Duration subtract(Duration aDuration) {
        int diff = getTotalSeconds() - aDuration.getTotalSeconds();
        int total = Math.abs(diff);

        return new Duration(total);
    }
    
    /**
     *  Returns a string representation of the Duration object:
     *
     *  Format
     *    hh:mm:ss
     *
     */
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

}
