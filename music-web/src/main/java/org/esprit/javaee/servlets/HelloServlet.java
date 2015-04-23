package org.esprit.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/hello")
public class HelloServlet extends HttpServlet{
	
	private int visitCount;

	private static final long serialVersionUID = -5170159996498178659L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		visitCount++;
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("hello");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Hello "+name+"! </h2>");
		out.println("<h4>vists: "+visitCount+"! </h4>");
		out.println("</body>");
		out.println("</html>");
	}

}
