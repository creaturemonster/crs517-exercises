package rain;

import java.util.*;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import java.sql.*;


public class SpringJdbcTemplateVideoDao extends JdbcDaoSupport implements
		VideoDao {

	private static String SQL_VIDEO_QUERY = "select * from video_recordings_tx";


	
	

	class VideoRecordingMapper implements RowMapper<Recording>{

		public Recording mapRow(ResultSet rs, int index) throws SQLException {
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
			recording.setNewPrice(rs.getDouble("new_price"));
			recording.setStockCount(rs.getInt("stock_count"));

			recording.setActors(null);
			return recording;
		}
		
	}
	
	
	public List<Recording> getVideoRecordings() throws DAOException {
		return this.getJdbcTemplate().query(SQL_VIDEO_QUERY, new VideoRecordingMapper());
	}

	
	public void updatePrices(double percent)throws DAOException{
		String sql = "update video_recordings_tx set new_price=(price -(price*"+ percent/100.0 + "))";
		this.getJdbcTemplate().update(sql);
		if(percent > 50.0){
			throw new DAOException("Value is not valid Must be <= 50 percent");
		}
	}
	
	public void resetPrices(){
		String sql = "update video_recordings_tx set new_price=0.0";
		this.getJdbcTemplate().update(sql);
	}


}
