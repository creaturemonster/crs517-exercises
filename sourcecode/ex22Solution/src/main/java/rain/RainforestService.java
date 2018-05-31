package rain;

import java.util.*;

/**
 *  RainforestService implementation
 *
 *  @author 517 Development Team
 */


//TODO
//
// Complete the definition of the RainforestService class


public class RainforestService  {

	// TODO
	//
	// Define a private data member that is a reference to a VideoDao
	// This will be set by the Spring JavaBean container
	// Provide a public setter method for the VideoDao data member
	
	
	private VideoDao videoDao;

	public void setVideoDao(VideoDao videoDao) {
		this.videoDao = videoDao;
	}
	
	
	/**
	 *  Get a list of video recording categories from the database.
	 */
	public List<String> getVideoCategories() {
		
		List<String> categories = null;
		try {
			categories = videoDao.getVideoCategories();
		} catch (DaoException e) {
			if(categories == null){
				categories = new ArrayList<String>();
			}
		}
		
		return categories;
	}

	
	// TODO
	//
	// Implement the getVideoRecordings(String theCategory) method, 
	// following the Javadoc contract below.
	// You should delegate the work to the VideoDao
	// Your method should handle the DaoException returning an empty
	// list if the exception is thrown

	/**
	 *  Get a sorted list of video recordings from the database for the given category. <br>
	 *  The list is sorted by title.
	 *
	 *	@param theCategory the category
	 *  @return a list of VideoRecording objects
	 *  
	 *	@see rain.Dao#SORT_BY_TITLE
	 */
	public List<VideoRecording> getVideoRecordings(String theCategory) {
		List<VideoRecording> recordings = null;
		try {
			recordings = videoDao.getVideoRecordings(theCategory, Dao.SORT_BY_TITLE);
		} catch (DaoException e) {
			if(recordings == null){
				recordings = new ArrayList<VideoRecording>();
			}
		}
		return recordings;
	}

	
	/**
	 *  Get a sorted list of video recordings from the database for the given category. <br>
	 *  The sort order is ascending.
	 *
	 *  @param theCategory the category name
	 *  @param sortBy the key to sort by
	 *  @return a list of sorted <code>VideoRecording</code> objects
	 *  
	 *	@see rain.Dao#SORT_BY_TITLE
	 *	@see rain.Dao#SORT_BY_PRICE
	 *	@see rain.Dao#SORT_BY_STOCK_COUNT
	 */
	public List<VideoRecording> getVideoRecordings(String theCategory,int sortBy){
		List<VideoRecording> recordings = null;
		try {
			recordings = videoDao.getVideoRecordings(theCategory, sortBy);
		} catch (DaoException e) {
			if(recordings == null){
				recordings = new ArrayList<VideoRecording>();
			}
		}
		return recordings;
	}

	
	/**
	 *  Returns a video recording based on the id
	 *
	 *	@param recordingId the recording id
	 *	@return a <code>VideoRecording</code> object for the given recording id
	 * 	@see #getVideoRecording
	 */
	public VideoRecording getVideoRecording(String recordingId) {
		VideoRecording recording = null;
		try {
			recording = videoDao.getVideoRecording(recordingId);
		} catch (DaoException e) {
			if(recording == null){
				recording = new VideoRecording();
			}
		}
		return recording;
	}

	
	/**
	 *  Returns a video recording based on the id
	 */
	public VideoRecording getVideoRecording(int recordingId) {
		VideoRecording recording = null;
		try {
			recording = videoDao.getVideoRecording(recordingId);
		} catch (DaoException e) {
			if(recording == null){
				recording = new VideoRecording();
			}
		}
		return recording;
	}
}
