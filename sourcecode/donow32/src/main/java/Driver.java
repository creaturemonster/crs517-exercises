import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.jdbc.core.*;

import rain.MusicRecording;

import javax.sql.*;


// TODO 
//
// Examine the implementation of the RowMapper interface

class MusicRecordingMapper implements RowMapper<MusicRecording> {

	
	public MusicRecording mapRow(ResultSet rs, int rowNum) throws SQLException{
		MusicRecording recording = new MusicRecording();
		recording.setId(rs.getInt("recording_id"));
		
		// TODO
		//
		// Set the recoding title with data extracted from the ResultSet column named "title"
		recording.setTitle(rs.getString("title"));
		
		return recording;
	}
}

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		
		// TODO
		//
		// Execute the SQL statement "select * from music_recordings where recording_id = ?"
		String query="select * from music_recordings where recording_id=?";
		
		// TODO
		//
		// Display the title of the recording to the console'
		MusicRecording recording=null;
		recording=template.queryForObject(query, new MusicRecordingMapper(), 2000);
		System.out.println(recording.getTitle());
		//Symphonie no 6
	}

}
