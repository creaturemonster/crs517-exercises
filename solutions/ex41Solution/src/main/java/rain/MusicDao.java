package rain;


import java.util.*;


/**
 *  This interface defined the data access methods for the video recordings database.
 *  Methods are available to get a list of video recordings.   <p>
 *
 *
 *  @author 517 Development Team
 */
public interface MusicDao  {

	
	
	/**
	 *  Get a list of music recordings from the database. <br>
	 *  
	 *
	 *  @return a list of MusicRecording objects
	 *  @throws DAOException error accessing the data source
	 */
	public List<Recording> getMusicRecordings() throws DAOException ;

	public void updatePrices(double percent);

	public void resetPrices();

}