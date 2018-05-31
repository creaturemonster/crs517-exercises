
/**
 * 
 * @author 517 development team
 *
 */

//   TODO:
//
//   Define a class named MyMessageProvider that implements the
//   MessageProvider interface. You choose what message is returned
//

public class MyMessageProvider implements MessageProvider {


	public String getMessage() {
		try {
			Thread.sleep( (int)(Math.random()*(1000.0)));
		} catch (InterruptedException e) {
		}
		return "This is Exercise 4.1";
	}

}
