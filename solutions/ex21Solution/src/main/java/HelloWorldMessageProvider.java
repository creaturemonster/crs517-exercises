
/**
 * 
 * @author 517 development team
 *
 * Implements MessageProvider interface
 */

// TODO
//
//	Define a public class named HelloWorldMessageProvider that 
//  implements the MessageProvider interface.
//  Have your method return the String 'Hello World'



public class HelloWorldMessageProvider implements MessageProvider {

	/**
	 *  returns fixed "Hello World" message 
	 */
	
	public String getMessage(){
		return "Hello World";
	}
}
