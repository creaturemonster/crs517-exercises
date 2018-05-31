package rain;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;

import java.text.*;
/**
 *  This servlet allows the user to list all the recordings in the database.  
 *  @author 517 Development Team
 *
 */
public class RecordingCatalogServlet extends HttpServlet {

	/**
	 *  Reference to the rainforestService implementation
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

		response.setContentType("text/html");

		// 	Get a list of recordings from the VideoDAO

		List<Recording> theList = null;

		theList = rainforestService.getRecordings();

		PrintWriter out = response.getWriter();

			//	Build an HTML table for the list of products.
		buildHtmlTable(theList, out, response);

    }

	protected void buildHtmlTable(List<Recording> theList, PrintWriter out, HttpServletResponse response) {


		out.println("<h4>List of Music and Video Recordings</h4>");
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
