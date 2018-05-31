import message.ConsoleRenderer;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Driver {
	public static void main(String[] args) {


		/*
		 * 	TODO 
		 * 
		 *  Note the call to the registerShutdownHook below
		 *  What is the purpose of this call ?
		 *  
		 *  Run the code and then comment out the call and
		 *  re-run the code to get a hint of what it does
		 */
		
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		context.registerShutdownHook();
		
		ConsoleRenderer renderer = context.getBean("messageRenderer", ConsoleRenderer.class);
		
		System.out.println("Welcome to the World of Spring.  Here is your message:");
		
		renderer.renderMessage();

	}

}
