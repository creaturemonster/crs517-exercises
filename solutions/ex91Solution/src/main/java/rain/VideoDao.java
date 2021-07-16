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
	 * Flag to sort by title
	 */
	public static final int SORT_BY_TITLE = 0;

	/**
	 * Flag to sort by price
	 */
	public static final int SORT_BY_PRICE = 1;

	/**
	 * Flag to sort by stock count
	 */
	public static final int SORT_BY_STOCK_COUNT = 2;


	
	/**
	 *  Get a list of video categories from the database
	 *
	 *  @return a list of video categories
	 *  @throws DAOException error accessing the data source
	 */
	public List<Category> getVideoCategories() throws DAOException;
	/**
	 *  Get a sorted list of video recordings from the database for the given category. <br>
	 *  The list is sorted by title.
	 *
	 *	@param theCategory the category
	 *  @return a list of VideoRecording objects
	 *  @throws DAOException error accessing the data source
	 *	@see #getVideoRecordings(String theCategory, int sortBy)
	 */
	public List<VideoRecording> getVideoRecordings(String theCategory) throws DAOException ;

		
	/**
	 *  Get a sorted list of video recordings from the database for the given category. <br>
	 *  The sort order is ascending.
	 *
	 *  @param theCategory the category name
	 *  @param sortBy the key to sort by
	 *  @return a list of sorted <code>VideoRecording</code> objects
	 *  @throws DAOException error accessing the data source
	 *	@see #SORT_BY_TITLE
	 *	@see #SORT_BY_PRICE
	 *	@see #SORT_BY_STOCK_COUNT
	 */
	public List<VideoRecording> getVideoRecordings(String theCategory, int sortBy)throws DAOException;
	/**
	 *  Returns a video recording based on the id
	 *
	 *	@param recordingId the recording id
	 *	@return a <code>VideoRecording</code> object for the given recording id
	 *  @throws DAOException error accessing the data source
	 * 	@see #getVideoRecording
	 */
	public VideoRecording getVideoRecording(String recordingId)throws DAOException;

	/**
	 *  Returns a video recording based on the id
	 *
	 *  @throws DAOException error accessing the data source
	 */
	public VideoRecording getVideoRecording(int recordingId) throws DAOException;


}