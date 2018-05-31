package rain;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class RainAppListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		ServletContext application = event.getServletContext();

		try {
			//  Look up the data source using the data source name
			Context jndiContext = new InitialContext();
			DataSource myDataSource = (DataSource) jndiContext.lookup(Constants.DATA_SOURCE_NAME);

			//  Construct the VideoDAO based on the data source
			VideoDAO myVideoDAO = new VideoDAO(myDataSource);

			// Add to application context
			application.setAttribute(Constants.VIDEO_DAO_KEY, myVideoDAO);

			//  Construct the MusicDAO based on the data source
			MusicDAO myMusicDAO = new MusicDAO(myDataSource);

			// Add to application context
			application.setAttribute(Constants.MUSIC_DAO_KEY, myMusicDAO);

			log(application, "Application Context Initialized: " + new java.util.Date());

		} catch (NamingException exc) {
			exc.printStackTrace();
			log(application, exc);
		}
	}

	public void contextDestroyed(ServletContextEvent event) {
		ServletContext application = event.getServletContext();

		log(application, "Application Context Destroyed: " + new java.util.Date());
	}

	private void log(ServletContext application, Object message) {
		// contextName is the <display-name> for the web app defined in web.xml
		String applicationName = application.getServletContextName();

		// log data to server's event log and stdout
		application.log(applicationName + ": " + message.toString());
		System.out.println(applicationName + ": " + message);
	}
}