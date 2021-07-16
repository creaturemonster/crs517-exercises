package rain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


/**
 *  DAO implementation built using Spring JDBCTemplate
 *
 *  @author 517 Development Team
 */



// TODO 
//
// Modify the class so that it extends the Spring JdbcDaoSupport class



public class SpringJdbcTemplateVideoDao  extends JdbcDaoSupport implements VideoDao {

	
	/**
	 * Reference to logger
	 */
	protected Logger logger = Logger.getLogger("rain");

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
	
	public List<String> getVideoCategories(List<String> categories) throws DaoException{
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
	/**
	 *  Get a sorted list of video recordings from the database for the given category. <br>
	 *  The list is sorted by title.
	 *
	 *	@param theCategory the category
	 *  @return a list of VideoRecording objects
	 *  @throws DaoException error accessing the data source
	 *	@see #getVideoRecordings(String theCategory, int sortBy)
	 */
	public List<VideoRecording> getVideoRecordings(String theCategory) throws DaoException {
		return getVideoRecordings(theCategory, SORT_BY_TITLE);
	}

	/**
	 *  Get a sorted list of video recordings from the database for the given category. <br>
	 *  The sort order is ascending.
	 *
	 *  @param theCategory the category name
	 *  @param sortBy the key to sort by
	 *  @return a list of sorted <code>VideoRecording</code> objects
	 *  @throws DaoException error accessing the data source
	 *	@see #SORT_BY_TITLE
	 *	@see #SORT_BY_PRICE
	 *	@see #SORT_BY_STOCK_COUNT
	 */
	public List<VideoRecording> getVideoRecordings(String theCategory, int sortBy)
		throws DaoException {
		String orderString=null;
		
		switch(sortBy) {
			case VideoDao.SORT_BY_PRICE:
				orderString=" order by price";
				break;
			case VideoDao.SORT_BY_STOCK_COUNT:
				orderString=" order by stock_count";
				break;
			default:
				orderString=" order by title";
		}
		 return this.getJdbcTemplate().query(SQL_VIDEO_QUERY+ orderString, videoMapper, theCategory);
		/*
		 * List<VideoRecording> theList = new ArrayList<VideoRecording>();
		 * 
		 * // setup the base SQL query String videoSql =
		 * "SELECT recording_id, director, title, category, image_name, duration " +
		 * ", rating, year_released, price, stock_count " + "FROM Video_Recordings";
		 * 
		 * // setup the where clause for the category if
		 * (!theCategory.equalsIgnoreCase("all")) { videoSql += " WHERE category LIKE '"
		 * + theCategory + "%'"; }
		 * 
		 * // determine the field to sort on String field = null; switch (sortBy) { case
		 * SORT_BY_TITLE : field = "title"; break; case SORT_BY_PRICE : field = "price";
		 * break; case SORT_BY_STOCK_COUNT : field = "stock_count"; break; default :
		 * field = "title"; } videoSql += " ORDER BY " + field;
		 * 
		 * 
		 * // get a connection from the pool // create a statement // execute the query
		 * try (Connection tempConn = getDataSource().getConnection(); Statement myStmt
		 * = tempConn.createStatement(); ResultSet myRs =
		 * myStmt.executeQuery(videoSql);) {
		 * 
		 * // build a list based on the query while (myRs.next()) { VideoRecording
		 * tempRecording = new VideoRecording(myRs); theList.add(tempRecording); } }
		 * catch (SQLException e) { logError(e); throw new DaoException(e); }
		 * 
		 * return theList;
		 */
	}

	/**
	 *  Returns a video recording based on the id
	 *
	 *	@param recordingId the recording id
	 *	@return a <code>VideoRecording</code> object for the given recording id
	 *  @throws DaoException error accessing the data source
	 * 	@see #getVideoRecording
	 */
	public VideoRecording getVideoRecording(String recordingId)
		throws DaoException {

		int rid = Integer.parseInt(recordingId);
		return getVideoRecording(rid);
	}

	/**
	 *  Returns a video recording based on the id
	 *
	 *  @throws DaoException error accessing the data source
	 */
	public VideoRecording getVideoRecording(int recordingId)
		throws DaoException {
		VideoRecording recording=new VideoRecording();
		
		// get a connection from the pool
		// create a statement
		// execute the query
		try (Connection tempConn = getDataSource().getConnection();
				Statement myStmt = tempConn.createStatement();
				
				ResultSet myRs = myStmt.executeQuery(
					"SELECT recording_id, director, title, category, image_name "
					+ ", duration, rating, year_released, price, stock_count "
					+ "FROM Video_Recordings "
					+ "WHERE recording_id=" + recordingId)) {
			//recording.setId(myRs.getInt(recordingId));
			//recording.setTitle(myRs.getString("title"));
			//return recording;
			
			  return (myRs.next()) ? new VideoRecording(myRs) : null;
			 
		} catch (SQLException e) {
			logError(e);
			throw new DaoException(e);
		}
	}

	/**
	 * Log a message
	 * @param message
	 */
	protected void log(Object message) {
		logger.info(message.toString());
	}

	/**
	 * Log an error w/ the given message
	 * @param message
	 * @param thrown
	 */
	protected void logError(Object message, Throwable thrown) {
		logger.log(Level.SEVERE, message.toString(), thrown);
	}

	/**
	 * Log an error
	 * @param thrown
	 */
	protected void logError(Throwable thrown) {
		logError("", thrown);
	}

	@Override
	public List<String> getVideoCategories() throws DaoException {
		return this.getJdbcTemplate().queryForList(SQL_CATEGORY_QUERY, String.class);
	}
	
}
