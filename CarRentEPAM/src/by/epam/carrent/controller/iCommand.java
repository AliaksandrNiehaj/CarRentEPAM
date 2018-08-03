package by.epam.carrent.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface iCommand {
	
	void execute(HttpServletRequest request, HttpServletResponse response);
	
}