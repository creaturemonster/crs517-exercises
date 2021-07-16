package rain;


import java.util.*;


/**
 *  This interface defined the data access methods for the video recordings database.
 *  Methods are available to get a list of video recordings.   <p>
 *
 *
 *  @author 517 Development Team
 */
public interface VideoDao  {

	
	
	/**
	 *  Get a list of video recordings from the database. <br>
	 *  
	 *
	 *  @return a list of VideoRecording objects
	 *  @throws DAOException error accessing the data source
	 */
	public List<Recording> getVideoRecordings() throws DAOException ;

	public void updatePrices(double percent) throws DAOException;

	public void resetPrices();

}