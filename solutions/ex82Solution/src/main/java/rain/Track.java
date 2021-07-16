package rain;

import javax.persistence.Embedded;



public class Track {

    /*
     * The id of this track
     */
	
    int id;

    /*
     * The MusicRecording this track is a part of 
     */
    int recordingId;

    /*
     * The listing number of the track on the MusicRecording
     */
    int trackNo;

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
    
    @Embedded
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
     * Returns the track's recordingId
     */
    public int getRecordingId() {
        return recordingId;
    }

    /*
     * Returns the track's listing number
     */
    public int getTrackNo() {
        return trackNo;
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
     * Sets the the track's recordingId
     */
    public void setRecordingId(int theRecordingId) {
        id = theRecordingId;
    }

    /*
     * Sets the the track's listing number
     */
    public void setTrackNo(int theTrackNo) {
        trackNo = theTrackNo;
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
        return trackNo + ". " + title + " - " + duration + " ("+ composer +")";
    }
}


