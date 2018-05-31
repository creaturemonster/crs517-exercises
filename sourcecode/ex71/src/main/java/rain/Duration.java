package rain;


/*
 * 
 * TODO
 * 
 * Annotate the class as a persistant type
 * 
 * 
 */


public class Duration {

    /**
     *  The identifier of this Duration object
     */
	
	/*
	 * 
	 * TODO
	 * 
	 * Annotate this field as the primary key field
	 * 
	 * Mark the generation strategy as auto
	 * 
	 */
	
    protected int id;
   
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
     *  Returns the id
     */
    public int getId() {
        return id;
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
     *  Sets the Id
     */
    public void setId(int theId) {
        id=theId;
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
