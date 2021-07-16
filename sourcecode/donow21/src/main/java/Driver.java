import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import message.ConsoleRenderer;


public class Driver {
	public static void main(String[] args) {


		/*
		 * 	TODO 
		 * 
		 *  Note the call to the registerShutdownHook below
		 *  What is the purpose of this call ?
		 *  
		 *  The purpose of the call is to print out "In tidyUp method of ConsoleRenderer".
		 *  Run the code and then comment out the call and
		 *  re-run the code to get a hint of what it does
		 */
		
		
		ConfigurableApplicationContext context = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		
		context.registerShutdownHook();
		
		ConsoleRenderer renderer = context.getBean("messageRenderer", ConsoleRenderer.class);
		
		System.out.println("Welcome to the World of Spring.  Here is your message:");
		
		renderer.renderMessage();
	}

}
