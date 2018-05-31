package rain;

import java.util.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.*;


/**
 *  DAO implementation built using Spring JDBCTemplate
 *
 *  @author 517 Development Team
 */


public class SpringJdbcTemplateVideoDao extends JdbcDaoSupport implements
		VideoDao {

	private static final String SQL_VIDEO_QUERY = "select * from video_recordings where category = ?";
	private static final String SQL_SINGLE_VIDEO_QUERY = "select * from video_recordings where recording_id=?";
    private static final String SQL_CATEGORY_QUERY = "select name from video_categories"; 
	

    
    
	// TODO
	//
	// You are to implement the method getVideoCategories
	// The return type should be a type safe List of String objects.
	// Each String represents the name of a category.

    // From the "SQL_*" constants above, pick the correct one to use for this query
    
	// Invoke the queryForList() method on the inherited Spring JdbcTemplate instance to execute your query
    
	public List<String> getVideoCategories() throws DaoException {

		return this.getJdbcTemplate().queryForList(SQL_CATEGORY_QUERY, String.class);
	}	
		

	
	
	

	private static final RowMapper<VideoRecording> videoMapper = new RowMapper<VideoRecording>() {
		
		public VideoRecording mapRow(ResultSet rs, int rowNum) throws SQLException{
			VideoRecording recording = new VideoRecording();
			recording.setId(rs.getInt("recording_id"));
			recording.setDirector(rs.getString("director"));
			recording.setTitle(rs.getString("title"));
			recording.setCategory(rs.getString("category"));
			recording.setImageName(rs.getString("image_name"));
			recording.setDuration(new Duration(rs.getInt("duration")));
			recording.setRating(rs.getString("rating"));
			recording.setYearReleased(rs.getInt("year_released"));
			recording.setPrice(rs.getDouble("price"));
			recording.setStockCount(rs.getInt("stock_count"));
			recording.setActors(null);
			return recording;
		}
	};


	public List<VideoRecording> getVideoRecordings(String theCategory)throws DaoException{
	
		return getVideoRecordings(theCategory, VideoDao.SORT_BY_TITLE);
	}


	
	public List<VideoRecording> getVideoRecordings(String theCategory,
			int sortBy) throws DaoException {
		String orderString = null;
		switch(sortBy){
		case VideoDao.SORT_BY_PRICE:
			orderString = " order by price";
			break;
		case VideoDao.SORT_BY_STOCK_COUNT:
			orderString = " order by stock_count";
			break;
		default:
			orderString = " order by title";
		}
		return this.getJdbcTemplate().query(SQL_VIDEO_QUERY+ orderString, videoMapper, theCategory);
	}

	
	
	
	
	public VideoRecording getVideoRecording(String recordingId)
			throws DaoException {
		return this.getVideoRecording(Integer.parseInt(recordingId));
	}

	public VideoRecording getVideoRecording(int recordingId) throws DaoException {

		return this.getJdbcTemplate().queryForObject(SQL_SINGLE_VIDEO_QUERY, videoMapper, recordingId);
		

	}


}
