package rain;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/*
 *	TODO
 *
 *  Configure the class as an MVC controller 
 *
 *  Configure the class to process the url "/enquiry"
*/

public class EnquiryController {

	/*
	 * 
	 * 	TODO
	 * 
	 *  Define a method named setupForm.
	 *  
	 *  The method should process HTTP GET requests
	 *    The parameter type for the method should be ModelMap
	 *    The return type should be String
	 *  
	 *  The method body should create an EnquiryCommand object 
	 *    The EnquiryCommand should be placed in the ModelMap with the key "enquiry" 
	 * 
	 *  The method should return the view name "enquiry_form"
	 */
	

	
	

	/*
	 * 
	 * 	TODO
	 * 
	 *  Define a method named onSubmit.
	 *  
	 *  The method should process HTTP POST requests
	 *    The method should receive 3 arguments
	 *    1. An EnquiryCommand object bound to the "enquiry" model attribute
	 *       You should request validation of the EnquiryCommand object
	 *    2. A BindingResult object
	 *    3. The redirect attribute 
	 *    The return type should be String
	 *    
	 *  
	 * 
	 *  If validation errors are detected return a view name "enquiry_form"
	 *    Otherwise redirect to the url enquiry/success"
	 *
	 *    
	 *  Make the enquiry command object a flash attribute named enquiry so it will be visible 
	 *    to the view page on the redirect
	 *

	 *    
	 *   The controller method to which the redirect is targeted is below 
	 */
	
	

	
	@RequestMapping("/success")
	public String succussView(){
		return "enquiry_confirmation";
	}

	
}