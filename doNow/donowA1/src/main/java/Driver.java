import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import rain.RainforestService;


public class Driver {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		
		// TODO 
		
		// Lookup the rainforestService bean defined in the file applicationContext.xml
		//
		// Call both methods defined in the RainforestService class
		// Pass any String as the argument to serviceMethodTwo

		
		
		((AbstractApplicationContext)context).close();
		
	}

}
