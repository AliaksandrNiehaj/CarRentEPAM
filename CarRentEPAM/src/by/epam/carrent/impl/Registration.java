package by.epam.carrent.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.carrent.controller.iCommand;

public class Registration implements iCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			response.sendRedirect("registration");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}	
}