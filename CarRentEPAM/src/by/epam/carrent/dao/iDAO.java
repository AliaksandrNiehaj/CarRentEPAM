package by.epam.carrent.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.carrent.domain.User;

public interface iDAO {
	
	void createAccount(HttpServletRequest request, HttpServletResponse response, User user, String password);
	User signIn(HttpServletRequest request, HttpServletResponse response, String nickname, String password);	
}