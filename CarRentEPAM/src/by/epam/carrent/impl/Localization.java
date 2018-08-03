package by.epam.carrent.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.carrent.controller.iCommand;

public class Localization implements iCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String local = request.getParameter("local");
		System.out.println("Local = " + local);
		
		request.getSession(true).setAttribute("local", local);
		
		try {
			response.sendRedirect("authorization");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}