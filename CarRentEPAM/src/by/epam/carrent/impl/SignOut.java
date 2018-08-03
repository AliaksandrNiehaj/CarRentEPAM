package by.epam.carrent.impl;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.carrent.controller.iCommand;

public class SignOut implements iCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(0);
		
		Cookie[] cookies = request.getCookies();
		
		for (Cookie cook : cookies) {
			String value = cook.getValue();
			
			System.out.println("value: " + value);
			
			Cookie cookie1 = new Cookie(cook.getName(), "");
			cookie1.setMaxAge(0);
			response.addCookie(cookie1);
		}
		
		try {
			response.sendRedirect("authorization");
		} catch (IOException e) {
			System.out.println("Authorization page is unavailable");		}
		
	}
}