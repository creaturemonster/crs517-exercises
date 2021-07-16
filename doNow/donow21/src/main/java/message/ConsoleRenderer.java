package message;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/*
 * 	TODO 
 * 
 *  1. Annotate the ConsoleRenderer class
 *     as a Spring Component with the name messageRenderer
 *     
 *  2. Annotate the Component to have as scope of singleton
 *  
 *  3. Annotate the Component to be created on factory startup (not lazy loaded)
 */
@Component("messageRenderer")
@Scope("singleton")
@Lazy(false)
public class ConsoleRenderer {

		private MessageProvider messageProvider = null;
		

		/*
		 * 	TODO 
		 * 
		 *  Annotate the init method 
		 *  as a post construction method
		 */

		
		@PostConstruct
		public void init(){
			
			System.out.println("In init method of ConsoleRenderer");
		}
	
		/*
		 * 	TODO 
		 * 
		 *  Mark the tidyUp method
		 *  as a method to be called just before the Spring factory closes 
		 */

		@PreDestroy
		public void tidyUp(){
			
			System.out.println("In tidyUp method of ConsoleRenderer");
		}
		
		public void renderMessage(){
			System.out.println(messageProvider.getMessage());
		}

		/*
		 * 	TODO 
		 * 
		 *  Mark the setMessageProvider method in the appropriate way
		 *  so that Spring will set the property with a bean whose name
		 *  is messageProvider
		 */

		@Resource(name="messageProvider")
		public void setMessageProvider(MessageProvider messageProvider){
			this.messageProvider = messageProvider;
		}

		public MessageProvider getMessageProvider(){
			return messageProvider;
		}

}

