package rain;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.annotation.Resource;

/*
 *  TODO
 *  
 *  Mark this class as a Spring MVC Controller
 *  
 */


public class VideoCatalogController {
	
	private RainforestService rainforestService;
	
	
	
/*
 * 
 * TODO
 * 
 * Mark the rainforestService property for automatic dependency injection
 * 	
 */
	
	public void setRainforestService(RainforestService rainforestService) {
		this.rainforestService = rainforestService;
	}


	
	
	/*
	 * TODO
	 * 
	 * Specify that the method should process the path "/videos" 

	 * 	
	 */
	
	

    public String process(@RequestParam("video_category") String category, ModelMap model){
		

		
		// TODO
		// Use the rainforest service to get the VideoRecordings in the 
		// user selected category
		
		
		
		// TODO
		// Add the videoList collection to the model with the key Constants.VIDEO_LIST_KEY
		// HINT:   model.addAttribute(Constants.VIDEO_LIST_KEY, xxxx);
		
		// TODO
		// Return the view named video_catalog
		
	}

}
