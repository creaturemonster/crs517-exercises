package rain;

import java.util.*;


// TODO
//
// Complete the definition of the RainforestService class

public class ... {

// TODO
//
// Define a private data member that is a reference to a VideoDao
// This will be set by the Spring JavaBean container
// Provide a public setter method for the VideoDao data member



// TODO
//
// Implement the getVideoRecordings(String theCategory) method
// you defined in the RainforestService interface.
// You should delegate the work to the VideoDao
// Your method should handle the DaoException returning an empty
// list if the exception is thrown





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
