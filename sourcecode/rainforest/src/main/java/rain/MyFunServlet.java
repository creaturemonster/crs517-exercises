package rain;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class MyFunServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected final int YEAR = 60 * 60 * 24 * 365;

    public void doGet (HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

		String sport = null;
		String city = null;

		// read the cookies
		Cookie[] theCookies = request.getCookies();
		Cookie tempCookie;
		String name;

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>My rainforest.web</title></head>");
		out.println("<body>");

		if (theCookies != null) {

			for (int i=0; i < theCookies.length; i++) {

				tempCookie = theCookies[i];
				name = tempCookie.getName();

				if (name.equals("rain.pref.sport")) {
					sport = tempCookie.getValue();
				}
				else if (name.equals("rain.pref.weather")) {
					city = tempCookie.getValue();
				}
			}
		}

		if (theCookies == null || sport == null) {
			out.println("<h2>Oops...you didn't follow directions!</h2>");
			out.println("<hr>");
			out.println("You haven't personalized the site yet.<p>");
			out.println("<a href=/myrain/personalize_form.html>Click here to personalize</a>");
			out.println("</BODY></HTML>");
			return;
		}

		out.println("<html>");
		out.println("<head><title>My rainforest.web</title></head>");
		out.println("<body>");

		out.println("<h2><i>Welcome Back!</i></h2>");
		out.println("<hr>");
		out.println("As requested, I'm keeping track of your news!");
		out.println("<p>");

		out.println("<h4>Hot News for <font color=red>" + sport + "</font> </h4>");
		out.println("<ul>");
		out.println("<li>Upcoming " + sport + " games...");
		out.println("<li>Interviews with the top " + sport + " players...");
		out.println("<li>Tickets available for...");
		out.println("</ul>");

		out.println("<h4>Weather Report for <font color=red>" + city + "</font> </h4>");
		out.println("<ul>");
		out.println("<li>Current temperature...");
		out.println("<li>3 day forecast...");
		out.println("</ul>");

		out.println("<a href=/myrain/index.html>Return to the home page</a>");

		out.println("</body></html>");

    }


	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		doGet(request, response);
	}


}
