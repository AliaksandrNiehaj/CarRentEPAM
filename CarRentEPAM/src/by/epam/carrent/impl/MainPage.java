package by.epam.carrent.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.carrent.controller.iCommand;

public class MainPage implements iCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			response.sendRedirect("main_page");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}