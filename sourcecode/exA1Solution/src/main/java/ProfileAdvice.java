import org.aspectj.lang.ProceedingJoinPoint;



public class ProfileAdvice{


	public Object profile(ProceedingJoinPoint pjp) throws Throwable {

		// TODO  
		// Take a reading of the current time
	
		long startTime = System.currentTimeMillis();

		// TODO
		// Call the target method
		
		Object result = pjp.proceed();
		
		// TODO
		// Take a reading of the current time 
		
		long endTime = System.currentTimeMillis();
		
		// TODO
		// Display the method execution time to the console
		
		System.out.println("Method took " + (endTime - startTime) + "ms");
		
		return result;
	}

}
