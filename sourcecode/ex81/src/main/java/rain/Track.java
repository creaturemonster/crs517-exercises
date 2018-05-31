package rain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


/*
 * 
 * TODO
 * 
 * Annotate this class as an Entity
 * 
 * 
 */


public class Track {

    /*
     * The id of this track
     */
    
	
	/*
	 * 
	 * TODO 
	 * 
	 * Mark this field as the primary key field
	 * 
	 * Have the key generation strategy set to auto
	 * 
	 */
	
	
	int id;


    /*
     * The title of the track
     */
    String title;

    /*
     * The composer of the track
     */
 
    String composer;

    /*
     * The duration of the track
     */
    
    
    /*
     * 
     * TODO 
     * 
     * Annotate this field and an embedded relationship
     * 
     */
    
    
    Duration duration;
    
    public Track() {
        super();
    }

    /*
     * Creates a track with the given parameters
     */
    public Track(String theTitle, String theComposer, Duration theDuration) {
        super();
        title = theTitle;
        composer = theComposer;
        duration = theDuration;
    }

    /*
     * Returns the track's id
     */
    public int getId() {
        return id;
    }


    /*
     * Returns the track's title
     */
    public String getTitle() {
        return title;
    }

    /*
     * Returns the track's composer
     */
    public String getComposer() {
        return composer;
    }
    
    /*
     * Returns the track's duration
     */
    public Duration getDuration() {
        return duration;
    }
    
    /*
     * Sets the the track's id
     */
    public void setId(int theId) {
        id = theId;
    }


    /*
     * Sets the the track's title
     */
    public void setTitle(String theTitle) {
        title = theTitle;
    }

    /*
     * Sets the the track's composer
     */
    public void setComposer(String theComposer) {
        composer = theComposer;
    }

    /*
     * Sets the the track's duration
     */
    public void setDuration(Duration theDuration) {
        duration = theDuration;
    }
    
    public String toString() {
        return title + " - " + duration + " ("+ composer +")";
    }
}


