package rain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AjaxController {

	
	/*
	 * 
	 *  TODO
	 *  
	 *  Note the annotations on the getMusicRecording() method
	 */
	
	
	@RequestMapping(value="/ajax", method=RequestMethod.GET, headers="accept=application/json")
	public @ResponseBody MusicRecording getMusicRecording(){
		
		
		/*
		 * 
		 * 
		 *  TODO 
		 *  
		 *  Note the values of the following MusicRecording properties
		 *  This object will be serialised in JSON format 
		 */
		
		MusicRecording recording = new MusicRecording();
		recording.setArtist("Avril Lavigne");
		recording.setTitle("Goodbye Lullaby");
		Track trackOne = new Track("Push", new Duration(181));
		Track trackTwo = new Track("Wish You Were Here", new Duration(225));
		recording.setTrackList(new Track[]{trackOne,trackTwo});
		return recording;
		
		
	}
}
