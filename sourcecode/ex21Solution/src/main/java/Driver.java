import org.springframework.context.*;
import org.springframework.context.support.*;

public class Driver {

	/**
	 * 
	 * Extracts ConsoleRenderer bean from Spring and renders message
	 */
	
	public static void main(String[] args) {

		ConfigurableApplicationContext context = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Fetch ConsoleRenderer

		ConsoleRenderer renderer = context.getBean("messageRenderer", ConsoleRenderer.class);
		
		System.out.println("Welcome to the World of Spring.  Here is your message:");
		
		//TODO call renderMessage on the renderer
		
		renderer.renderMessage();

		context.close();
	}

}
