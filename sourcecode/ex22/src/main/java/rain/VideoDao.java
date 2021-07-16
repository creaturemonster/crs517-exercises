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




	//TODO
	//
	// Define a method with the following specification
	// name: getVideoRecordings
	// parameters: String the category of video recordings to get
	// return type: List<VideoRecording>
	// throws DaoException
	public List<VideoRecording> getVideoRecordings(String category) throws DaoException;
	
	


	
	//TODO
	//
	// Define a method with the following specification
	// name: getVideoRecording
	// parameters: String the recording Id
	// return type: VideoRecording	
	// throws DaoException
	public VideoRecording getVideoRecording(String recordingId) throws DaoException;
	
	
	
	public List<String> getVideoCategories() throws DaoException;
	public VideoRecording getVideoRecording(int recordingId) throws DaoException;
	public List<VideoRecording> getVideoRecordings(String theCategory, int sortBy)throws DaoException;


}