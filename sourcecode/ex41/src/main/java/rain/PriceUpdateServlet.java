package rain;


import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import java.text.*;
/**
 *  This servlet allows the user to list all the recordings in the database.  
 *  @author 517 Development Team
 *
 */
public class PriceUpdateServlet extends HttpServlet {

	/**
	 *  Reference to the RainforestService implementation
	 */
	private RainforestService rainforestService;

	private DecimalFormat decimalFormat;

	
	public void init() throws ServletException {

		// Retrieve the service object from the servlet context
		// The RainforestService was initialized by the listener class: RainAppListener
		ServletContext application = getServletContext();
		rainforestService  = (RainforestService) application.getAttribute(Constants.RAINFOREST_SERVICE_KEY);

		decimalFormat = new DecimalFormat("0.00");
		
	}

    public void doGet (HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    	String errorMessage=null;
    	
		response.setContentType("text/html");

		// 	Get a list of recordings from the VideoDAO

		List<Recording> theList = null;


		String stringPercent = request.getParameter("percentage");
		double percent = 0.0;
		try {
			percent = Double.parseDouble(stringPercent);
		} catch (NumberFormatException e) {
			errorMessage = e.getMessage();
		}
		
		
		try{
	
			// TODO VERSION 1
			/*
			First, invoke the method on your RainforestService instance that will update the prices of Music recordings, 
			reducing them by the specified percentage
			
			On the next line, invoke the method on your RainforestService instance that will update the prices of Video recordings, 
			reducing them by the specified percentage
			*/
			rainforestService.updateMusicRecordingPrices(percent);
			rainforestService.updateVideoRecordingPrices(percent);
			// TODO VERSION 2
			/*
			First, comment out the 2 lines you just wrote above in VERSION 1.
			Next, invoke the single method on your RainforestService instance that will update the prices of both the Music and Video recordings, 
			reducing them by the specified percentage
			*/
			rainforestService.updateAllPrices(percent);
			
		}catch(DAOException e){
			errorMessage = e.getMessage();
			
		}
		
		
		theList = rainforestService.getRecordings();

		PrintWriter out = response.getWriter();

			//	Build an HTML table for the list of products.
		buildHtmlTable(theList, out, response, errorMessage);

    }

	protected void buildHtmlTable(List<Recording> theList, PrintWriter out, HttpServletResponse response, String errorMessage) {


		out.println("<h4>List of Music and Video Recordings</h4>");
		if(errorMessage != null){
			out.println("<font color='red'>" + "Transaction did not complete : " + errorMessage + "</font>" );
		}
		out.println("<table border=1 cellpadding=5>");

		out.println("<tr>");
			out.println("<th>Title</th>");
			out.println("<th>Price</th>");
			out.println("<th>New Price</th>");
			out.println("<th>Stock Count</th>");
			out.println("<th>Category</th>");
			
		out.println("</tr>");

		

		for (Recording tempRecording : theList) {

			
			out.println("<tr>");
			out.println("<td>" + tempRecording.getTitle() + "</td>");
			out.println("<td>" + decimalFormat.format(tempRecording.getPrice()) + "</td>");
			out.println("<td>" + decimalFormat.format(tempRecording.getNewPrice()) + "</td>");
			out.println("<td>" + tempRecording.getStockCount() + "</td>");

			out.print("<td>");
				out.print(tempRecording.getCategory());
			out.println("</td>");

			out.println("</tr>");
		}

		out.println("</table>");

	}


	/**
	 *  Forwards requests to the doGet(...) method
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		doGet(request, response);
	}


}
