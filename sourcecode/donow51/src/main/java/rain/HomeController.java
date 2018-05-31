package rain;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	
	
	
	/*
	 * TODO
	 * 
	 * Define the method urlParameters to process a request of the form
	 * /{value1}/{value2}
	 * 
	 * Where value1 is a String and value2 is an int
	 * 
	 */
	
	public String urlParameters(/* TODO  Define parameters to match your mapping here*/ , ModelMap model ){
		model.addAttribute("value1", value1);
		model.addAttribute("value2", value2);
		return "url_parameters";
		
	}
	
}
