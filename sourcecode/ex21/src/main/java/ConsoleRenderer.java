/**
 * 
 * Renders messages to the console
 * 
 * @author 517 Development team
 *
 */

public class ConsoleRenderer {
	/**
	 *  Reference to MessageProvider
	 */
	private MessageProvider messageProvider = null;
	
	
	// TODO 
	//
	// Implement a method named renderMessage, that takes no 
	// arguments, and return type void.
	// Your method should print a message obtained from the MessageProvider
	// to the system console.
	
	public  void renderMessage() {
		System.out.println(messageProvider.getMessage());
	}

	
	
	
	/**
	 * setMessageProvider for dependency injection of message source
	 */
	public void setMessageProvider(MessageProvider messageProvider){
		this.messageProvider = messageProvider;
	}
	/**
	 * getMessageProvide to return reference of MessageProvider
	 */
	public MessageProvider getMessageProvider(){
		return messageProvider;
	}

}
