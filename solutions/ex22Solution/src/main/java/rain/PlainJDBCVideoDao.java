package rain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *  This class provides a data access mechanism for the video recordings database.
 *  Methods are available to get a list of video recordings. This implementation uses plain JDBC  <p>
 *
 *  Usage Example:
 *  <pre>
 *
 *    // create the data accessor
 *    VideoDAO myVideoDAO = new VideoDAO(theDataSource);
 *
 *    ...
 *
 *    // get a list of "Comedy" video recordings
 *    List&lt;VideoRecording&gt; videoList = myVideoDAO.getVideoRecordings("Comedy");
 *    ...
 *
 *    // get a list of "Comedy" video recordings sorted by price (ascending)
 *    List&lt;VideoRecording&gt; videoList = myVideoDAO.getVideoRecordings("Comedy", VideoDAO.SORT_BY_PRICE);
 *    ...
 *  </pre>
 *
 *  @author 517 Development Team
 */


//**************************************************************
//TODO 
//
//Modify the class so that it implements the VideoDao interface
//
//**************************************************************



public class PlainJDBCVideoDao extends Dao implements VideoDao{

	/**
	 *  Constructs the data accessor with the given data source
	 */
	public PlainJDBCVideoDao() {
		DataSource dataSource = null;
		try {
			//  Look up the data source using the data source name
			Context jndiContext = new InitialContext();
			dataSource = (DataSource) jndiContext.lookup(Constants.DATA_SOURCE_NAME);
		} catch (NamingException exc) {
			exc.printStackTrace();
		}
		super.setDataSource(dataSource);
	}

	/**
	 *  Get a list of video categories from the database
	 *
	 *  @return a list of video categories
	 *  @throws DaoException error accessing the data source
	 */
	public List<String> getVideoCategories() throws DaoException {

		List<String> theList = new ArrayList<String>();

		Connection tempConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			tempConn = dataSource.getConnection();
			myStmt = tempConn.createStatement();

			String videoSql = "SELECT name FROM Video_Categories";

			myRs = myStmt.executeQuery(videoSql);

			while (myRs.next()) {
				String cat = myRs.getString("name");
				theList.add(cat);
			}
		} catch (SQLException exc) {
			logError(exc);
			throw new DaoException(exc);
		} finally {
			cleanup(myRs, myStmt, tempConn);
		}

		return theList;
	}

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

		return getVideoRecordings(theCategory, Dao.SORT_BY_TITLE);
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

		List<VideoRecording> theList = new ArrayList<VideoRecording>();

		Connection tempConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// get a connection from the pool and create statement
			tempConn = dataSource.getConnection();
			myStmt = tempConn.createStatement();

			// setup the base SQL query
			String videoSql =
				"SELECT recording_id, director, title, category, image_name, duration, rating, year_released, price, stock_count FROM Video_Recordings";

			// setup the where clause for the category
			if (!theCategory.equalsIgnoreCase("all")) {
				videoSql += " WHERE category LIKE '" + theCategory + "%'";
			}

			// determine the field to sort on
			String field = null;
			switch (sortBy) {
				case Dao.SORT_BY_TITLE :
					field = "title";
					break;
				case Dao.SORT_BY_PRICE :
					field = "price";
					break;
				case Dao.SORT_BY_STOCK_COUNT :
					field = "stock_count";
					break;
				default :
					field = "title";
			}
			videoSql += " ORDER BY " + field;

			// now execute the query
			myRs = myStmt.executeQuery(videoSql);

			// build a list based on the query
			while (myRs.next()) {
				VideoRecording tempRecording = new VideoRecording(myRs);
				theList.add(tempRecording);
			}
		} catch (SQLException exc) {
			logError(exc);
			throw new DaoException(exc);
		} finally {
			cleanup(myRs, myStmt, tempConn);
		}

		return theList;
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

		VideoRecording tempRecording = null;

		Connection tempConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			tempConn = dataSource.getConnection();
			myStmt = tempConn.createStatement();
			myRs =
				myStmt.executeQuery(
					"SELECT recording_id, director, title, category, image_name, duration, rating, year_released, price, stock_count FROM Video_Recordings WHERE recording_id="
						+ recordingId);

			while (myRs.next()) {
				tempRecording = new VideoRecording(myRs);
			}
		} catch (SQLException exc) {
			logError(exc);
			throw new DaoException(exc);
		} finally {
			cleanup(myRs, myStmt, tempConn);
		}

		return tempRecording;
	}

}