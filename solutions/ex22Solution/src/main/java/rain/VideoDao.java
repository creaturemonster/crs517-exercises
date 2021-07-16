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
	 *  Get a sorted list of video recordings from the database for the given category. <br>
	 *  The list is sorted by title.
	 *
	 *	@param theCategory the category
	 *  @return a list of VideoRecording objects
	 *  @throws DaoException error accessing the data source
	 *	@see #getVideoRecordings(String theCategory, int sortBy)
	 */

	
	//TODO
	//
	// Define a method with the following specification
	// name: getVideoRecordings
	// parameters: String the category of video recordings to get
	// return type: List<VideoRecording>
	// throws DaoException
	
	
	public List<VideoRecording> getVideoRecordings(String theCategory) throws DaoException ;


	
	/**
	 *  Returns a video recording based on the id
	 *
	 *  @throws DaoException error accessing the data source
	 */
	

	//TODO
	//
	// Define a method with the following specification
	// name: getVideoRecording
	// parameters: String the recording Id
	// return type: VideoRecording	
	// throws DaoException
	
	
	public VideoRecording getVideoRecording(String recordingId)throws DaoException;


	
	
	
	
	
	/**
	 *  Get a sorted list of video recordings from the database for the given category. <br>
	 *  The sort order is ascending.
	 *
	 *  @param theCategory the category name
	 *  @param sortBy the key to sort by
	 *  @return a list of sorted <code>VideoRecording</code> objects
	 *  @throws DaoException error accessing the data source
	 *	@see rain.Dao#SORT_BY_TITLE
	 *	@see rain.Dao#SORT_BY_PRICE
	 *	@see rain.Dao#SORT_BY_STOCK_COUNT
	 */
	public List<VideoRecording> getVideoRecordings(String theCategory, int sortBy)throws DaoException;
	/**
	 *  Returns a video recording based on the id
	 *
	 *	@param recordingId the recording id
	 *	@return a <code>VideoRecording</code> object for the given recording id
	 *  @throws DaoException error accessing the data source
	 * 	@see #getVideoRecording
	 */

	


	public VideoRecording getVideoRecording(int recordingId) throws DaoException;

	/**
	 *  Get a list of video categories from the database
	 *
	 *  @return a list of video categories
	 *  @throws DaoException error accessing the data source
	 */
	public List<String> getVideoCategories() throws DaoException;

}