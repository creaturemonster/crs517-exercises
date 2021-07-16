package rain;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.web.context.*;
import org.springframework.web.context.support.*;

/**
 *  Called on application startup/shutdown to initialize/close resources
 *
 *  @author 517 Development Team
 */

public class RainAppListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		ServletContext application = event.getServletContext();


		// TODO
		//
		// a. Get the WebApplicationContext
		// b. Use the WebApplicationContext to lookup the RainforestService JavaBean
		// c. Store the RainforestService JavaBean reference in a variable named
		//    rainforestService

		
		
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		
		RainforestService rainforestService = context.getBean("rainforestService", RainforestService.class);
		
		// Add to ServletContext
		application.setAttribute(Constants.RAINFOREST_SERVICE_KEY, rainforestService);


		log(application, "Application Context Initialized: " + new java.util.Date());

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