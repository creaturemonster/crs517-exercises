import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import rain.RainforestService;


public class Driver {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		
		// TODO 
		
		// Note the service methods being called below
		//
		// Predict what the output of executing the code below will be
		
		
		RainforestService service = (RainforestService)context.getBean("rainforestService");  
		
		service.serviceMethodOne();
		service.serviceMethodTwo("hello");
		
		
	
		
		
	}

}
