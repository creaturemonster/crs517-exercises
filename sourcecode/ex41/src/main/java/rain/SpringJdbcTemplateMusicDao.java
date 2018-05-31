package rain;

import java.util.*;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.*;
import java.sql.*;


public class SpringJdbcTemplateMusicDao extends JdbcDaoSupport implements
		MusicDao {

	private static String SQL_MUSIC_QUERY = "select * from music_recordings_tx";


	
	class MusicRecordingMapper implements RowMapper<Recording>{
		
	
		public Recording mapRow(ResultSet rs, int index) throws SQLException {
			MusicRecording recording = new MusicRecording();
			recording.setId(rs.getInt("recording_id"));
			recording.setTitle(rs.getString("title"));
			recording.setCategory(rs.getString("category"));
			recording.setImageName(rs.getString("image_name"));


			recording.setPrice(rs.getDouble("price"));
			recording.setNewPrice(rs.getDouble("new_price"));
			recording.setStockCount(rs.getInt("stock_count"));

			recording.setTrackList(null);
			return recording;
		}

	}
	
	public List<Recording> getMusicRecordings() throws DAOException {
		return this.getJdbcTemplate().query(SQL_MUSIC_QUERY, new MusicRecordingMapper());
	}


	public void updatePrices(double percent){
		String sql = "update music_recordings_tx set new_price=(price -(price*"+ percent/100.0 + "))";
		this.getJdbcTemplate().update(sql);
	}
	
	public void resetPrices(){

		String sql = "update music_recordings_tx set new_price=0.0";
		this.getJdbcTemplate().update(sql);
	}



}
