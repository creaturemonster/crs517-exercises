import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.jdbc.core.*;
import javax.sql.*;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		DataSource dataSource = context.getBean("dataSource",DataSource.class);
		
		// TODO
		//
		// Create a JdbcTemplate using the dataSource above
		
		
		
		// TODO
		//
		// Execute the SQL statement "select count(*) from music_recordings"
		

		// TODO
		//
		// Display the number of recordings to the console

	}

}
