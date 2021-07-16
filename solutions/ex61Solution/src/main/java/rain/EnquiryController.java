package rain;


import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;





/*
 *	TODO
 *
 *  Configure the class as an MVC controller 
 *
 *  Configure the class to process the url "/enquiry"
*/

@Controller
@RequestMapping("/enquiry")
public class EnquiryController{

	
	@ModelAttribute("musicCategories")
	public List<String> getMusicCategories(){
		String [] categories = {"", "Jazz", "Rock"};
		return Arrays.asList(categories);
	}
	
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
	

	
	@RequestMapping(method=RequestMethod.GET)
	public String setupForm(ModelMap model){
		EnquiryCommand enquiry = new EnquiryCommand();
		model.addAttribute("enquiry", enquiry);
		return "enquiry_form";
		
	}
	

	/*
	 * 
	 * 	TODO
	 * 
	 *  Define a method named onSubmit.
	 *  
	 *  The method should process HTTP POST requests
	 *    The method should receive 3 arguments
	 *    1. An EnquiryCommand object bound to the "enquiry" model attribute
	 *    2. A BindingResult object
	 *    3. The redirect attribute
	 *    The return type should be String
	 *  
	 * 
	 *  If validation errors are detected return a view name "enquiry_form"
	 *    Otherwise redirect to the url enquiry/success"
	 *    
	 *    Make the enquiry command object a flash attribute so it will be visible 
	 *    to the view page on the redirect
	 *
	 */
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String onSubmit(@ModelAttribute("enquiry") @Valid EnquiryCommand enquiry, BindingResult result, RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			return "enquiry_form";
		}
		
		redirectAttributes.addFlashAttribute("enquiry", enquiry);
		return "redirect:enquiry/success";
	}
	
	
	@RequestMapping("/success")
	public String successView(){
		return "enquiry_confirmation";
	}

		
}
