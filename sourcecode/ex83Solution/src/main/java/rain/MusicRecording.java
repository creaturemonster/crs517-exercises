package rain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class MusicRecording extends Recording {

	private static final long serialVersionUID = 1L;

    /*
     * The name of the artist who made this recording
     */
    protected String artist;

    /*
     * The name of the publisher or record label
     */
    protected String publisher;

    
    

	/*
	 * 
	 * TODO
	 * 
	 * Annotate this field as a one to many relationship
	 * 
	 * Set the cascade to All
	 * 
	 * Have the join column named RECORDING_ID
	 * 
	 * 
	 */
        
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="RECORDING_ID")
    protected List<Track> tracks;


    //
    //  CONSTRUCTORS
    //

    public MusicRecording() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MusicRecording(String theTitle, double thePrice, String theCategory,
            String theImageName) {
        super(theTitle, thePrice, theCategory, theImageName);
        // TODO Auto-generated constructor stub
    }

    public MusicRecording(String theTitle, double thePrice, String theCategory,
            String theImageName, int theStockCount) {
        super(theTitle, thePrice, theCategory, theImageName, theStockCount);
        // TODO Auto-generated constructor stub
    }

    public MusicRecording(String theTitle, double thePrice, String theCategory,
            String theImageName, int theStockCount, String theArtist, String thePublisher, 
            List<Track> theTracks) {
        super(theTitle, thePrice, theCategory, theImageName, theStockCount);
        artist = theArtist;
        publisher = thePublisher;
        tracks = theTracks;
    }

    //
    //  GETTER/SETTER METHODS
    //

    /*
     * Returns to name of the artist
     */
    public String getArtist() {
        return artist;
    }

    /*
     * Returns the publisher/record label
     */
    public String getPublisher() {
        return publisher;
    }

    /*
     * Returns the tracks
     */
    public List<Track> getTracks() {
        return tracks;
    }

    /*
     * Sets the name of the artist
     */
    public void setArtist(String theArtist) {
        artist = theArtist;
    }

    /*
     * Sets the publisher/record label
     */
   public void setPublisher(String thePublisher) {
        publisher = thePublisher;
    }

   /*
    * Sets the tracks
    */
   public void setTracks(List<Track> theTracks) {
       tracks = theTracks;
   }

   /*
    * Get the total duration of the MusicRecording by summing the durations of the individual tracks
    */
    public Duration getDuration() {
        Duration totalDuration = new Duration();
        for(int i = 0; i < tracks.size(); i++)
            totalDuration = totalDuration.add(((Track)tracks.get(i)).getDuration());
        return totalDuration;
    }

    public String toString() {
        return "'" + getTitle() + "' by " + artist + " (" + publisher + ")";
    }
}
