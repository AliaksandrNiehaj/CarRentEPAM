package by.epam.carrent.impl;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.carrent.controller.iCommand;
import by.epam.carrent.domain.User;
import by.epam.carrent.service.ServiceFactory;
import by.epam.carrent.service.iService;

public class SignIn implements iCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		User user = new User();
		
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		
		if(!nickname.equals("") && !password.equals("")) {
			
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			iService iService = serviceFactory.getiService();
			user = iService.signIn(request, response, nickname, password);
			
			try {
				HttpSession session = request.getSession();				
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(25);
				if(session.getAttribute("user") == null) {
					try {
						response.sendRedirect("authorization");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				String s = session.getId();
				System.out.println("value: " + s);
			} catch (IllegalStateException e) {
				System.out.println("Cannot create a session after the response has been committed");
			}
			
		} else {
			
			try {
				response.sendRedirect("authorization");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}