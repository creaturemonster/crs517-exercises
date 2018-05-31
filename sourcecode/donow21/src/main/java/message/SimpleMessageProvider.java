package message;

import org.springframework.stereotype.Component;


/*
 * 	TODO 
 * 
 *  Annotate the SimpleMessageProvider class
 *  as a Spring Component with the name messageProvider
 */

public class SimpleMessageProvider implements MessageProvider{
	public String getMessage(){
		return "Hello World";
	}
}
