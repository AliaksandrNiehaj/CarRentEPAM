package by.epam.carrent.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.carrent.domain.User;

public interface iService {
	
	void createAccount(HttpServletRequest request, HttpServletResponse response, User user, String password1, String password2);
	User signIn(HttpServletRequest request, HttpServletResponse response, String nickname, String password);
	
}