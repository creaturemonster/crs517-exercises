import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


// TODO
//
// Annotate the class as an aspect

public class BeforeAdviceExample {

	
	// TODO
	//
	// Annotate this method as Before advice that is to be applied to 
	// any method in the rain.RainforestService class

	public void beforeAdvice(){

		System.out.println("beforeAdvice() method of BeforeAdviceExample executing");
	}
}
