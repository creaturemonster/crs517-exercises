package rain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;


public class RainforestService {

	protected VideoDao videoDao;
    protected MusicDao musicDao;
    protected TransactionTemplate transactionTemplate;

    
	/**
	 *
	 * Fetches all recordings in database
	 *
	 */
	public List<Recording> getRecordings() {
		List<Recording> recordings = null;
		try {
			recordings = musicDao.getMusicRecordings();
			recordings.addAll(videoDao.getVideoRecordings());
		} catch (DAOException e) {
			if(recordings == null){
				recordings = new ArrayList<Recording>();
			}
		}
		return recordings;
	}


	/**
	 *
	 * Updates prices of music recordings, reducing them by the specified percentage
	 *
	 */
	public void updateMusicRecordingPrices(double percent){
		musicDao.updatePrices(percent);
	}


	/**
	 *
	 * Updates prices of video recordings, reducing them by the specified percentage
	 *
	 */
	public void updateVideoRecordingPrices(double percent) throws DAOException{
		videoDao.updatePrices(percent);
	}


	/**
	 *
	 * Updates prices of both the music and video recordings, reducing them by the specified percentage
	 *
	 */
	public void updateAllPrices(double percent) {
		updateMusicRecordingPrices(percent);
		updateVideoRecordingPrices(percent);
	}


	public void resetAllPrices() {
		musicDao.resetPrices();
		videoDao.resetPrices();
	}

	
	public VideoDao getVideoDao() {
		return videoDao;
	}

	public void setVideoDao(VideoDao videoDao) {
		this.videoDao = videoDao;
	}

	public MusicDao getMusicDao() {
		return musicDao;
	}

	public void setMusicDao(MusicDao musicDao) {
		this.musicDao = musicDao;
	}

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
}
