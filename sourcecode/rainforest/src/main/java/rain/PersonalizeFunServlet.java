package rain;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class PersonalizeFunServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected final int YEAR = 60 * 60 * 24 * 365;


    public void doGet (HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

		// read form data
		String sport = request.getParameter("sport");
		String city = request.getParameter("city");

		// set the cookies
		Cookie sportCookie = new Cookie("rain.pref.sport", sport);
		sportCookie.setMaxAge(YEAR);
		response.addCookie(sportCookie);

		Cookie cityCookie = new Cookie("rain.pref.weather", city);
		cityCookie.setMaxAge(YEAR);
		response.addCookie(cityCookie);

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Personalize Confirmation</title></head>");
		out.println("<body>");

		out.println("<h3>Thanks!</h3>");
		out.println("<hr>");
		out.println("Your site has been personalized!");
		out.println("<ul>");
		out.println("<li><b>Favorite Sport:</b> " + sport);
		out.println("<li><b>Local City: </b>" + city);
		out.println("</ul>");

		out.println("<a href=/myrain/index.html>Return to the home page</a>");

		out.println("</body></html>");

    }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		doGet(request, response);
	}


}
