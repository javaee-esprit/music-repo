package org.esprit.javaee.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.esprit.javaee.beans.AuthenticationBean;
import org.esprit.javaee.persistence.User;
import org.esprit.javaee.services.interfaces.UserServiceLocal;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserServiceLocal userServiceLocal;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		String navigateTo = null;
		AuthenticationBean bean = new AuthenticationBean(userServiceLocal, login, password);
		navigateTo = bean.doLogin();
		RequestDispatcher rd = getServletContext()
				.getRequestDispatcher(navigateTo);
		rd.forward(request, response);
	}

}
