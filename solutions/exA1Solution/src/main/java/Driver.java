import org.springframework.context.*;
import org.springframework.context.support.*;

public class Driver {

	/**
	 * 
	 * Extracts ConsoleRenderer bean from Spring and renders message
	 */
	
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Fetch ConsoleRenderer
		
		ConsoleRenderer renderer = context.getBean("messageRenderer", ConsoleRenderer.class);
		
		System.out.println("Welcome to the World of Spring.  Here is your message:");
		
		// Display message
		
		renderer.renderMessage();
		
		((AbstractApplicationContext)context).close();

		
	}

}
