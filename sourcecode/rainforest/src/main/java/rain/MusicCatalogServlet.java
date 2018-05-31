package rain;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.util.List;

/**
 *  This servlet allows the user to browse the music catalog.  The servlet reads
 *  parameters and displays a table of the products.
 *
 *  <p>
 *	The servlet retrieves the data and then "dispatches" the request
 *  to the page "music_catalog.jsp".  The JSP page handles the rendering of the data.
 *
 *  @author 570 Development Team
 *
 */
public class MusicCatalogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 *  Reference to music data accessor
	 */
	private MusicDAO myMusicDAO;


	/**
	 *  Retrieves an instance of the MusicDAO
	 *
	 */
	public void init() throws ServletException {

		// Retrieve the MusicDAO from the servlet context
		// The MusicDAO was initialized by the listener class: RainAppListener
		ServletContext application = getServletContext();
		myMusicDAO = (MusicDAO) application.getAttribute(Constants.MUSIC_DAO_KEY);
	}


	/**
	 *  This method reads the form parameters and calls methods to
	 *  display a list of recordings matching the search.
	 */
    public void doGet (HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

		String category = request.getParameter("music_category");

		List<MusicRecording> musicList = null;

		try {
			String sortByString = request.getParameter("sort_by");

			if (sortByString == null) {
				musicList = myMusicDAO.getMusicRecordings(category);
			}
			else {

				try {
					int sortByFlag = Integer.parseInt(sortByString);
					musicList = myMusicDAO.getMusicRecordings(category, sortByFlag);
				}
				catch (NumberFormatException exc) {
					// non-numeric sort flag...
					log(exc.getMessage());
					exc.printStackTrace();

					// just give them the basic list
					musicList = myMusicDAO.getMusicRecordings(category);
				}
			}

			//  Set the musicList as an attribute in the "request" object
			request.setAttribute(Constants.MUSIC_LIST_KEY, musicList);

			//  Dispatch/forward the request to "/rainforest/music/music_catalog.jsp"
			RequestDispatcher dispatcher = request.getRequestDispatcher("/music/music_catalog.jsp");
			dispatcher.forward(request, response);
		}
		catch (Exception exc) {
			log(exc.getMessage());
			exc.printStackTrace();
		}

    }



	/**
	 *  Forwards requests to the doGet(...) method
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		doGet(request, response);
	}


}
