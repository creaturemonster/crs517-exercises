package rain;

/**
 *  This class describes a duration of time.  It contains
 *  the hour, minutes and seconds.
 *
 *  <pre>
 *    Usage Example:
 *
 *      Duration lunchDuration = new Duration(1, 0, 0); // 1 hr, 0 mins, 0 secs
 *      System.out.println(lunchDuration);
 *
 *      Duration breakDuration = new Duration(0, 15, 30); // 0 hrs, 15 mins, 30 secs
 *      System.out.println(breakDuration);
 *
 *      Duration labDuration = new Duration(2700); // 2700 seconds = 45 minutes
 *      System.out.println(labDuration);
 *
 *  </pre>
 *
 *  @author 517 Development Team
 */
public class Duration implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

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
	 *
	 *  Note:  This is NOT the total seconds.
	 *
	 *  @see #getTotalSeconds()
	 */
	public int getSeconds() {
		return seconds;
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
