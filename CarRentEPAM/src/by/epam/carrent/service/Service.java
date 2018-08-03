package by.epam.carrent.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.carrent.dao.DAOFactory;
import by.epam.carrent.dao.iDAO;
import by.epam.carrent.domain.User;

public class Service implements iService{

	@Override
	public void createAccount(HttpServletRequest request, HttpServletResponse response, User user, String password1, String password2) {
		
		if(!user.getName().equals("") && !user.getSurname().equals("")) {
			
			if(user.getE_mail().contains("@") && user.getE_mail().contains(".")) {
				
				if(user.getPhone().contains("+")) {
					
					if(checkLogin(user.getNickname()) == true) {
					
						if(password1.equals(password2)) {
						
							String password = password1;
							DAOFactory daoFactory = DAOFactory.getInstance();
							iDAO dao = daoFactory.getiDao();
							dao.createAccount(request, response, user, password);
						
						} else {
							System.out.println("Check passwords, please. They must be able");
						}
						
					} else {
						System.out.println("This login name is not available");
					}
					
				} else {
					System.out.println("Check the phone, please. It must contains + as a prefix");
				}
				
			} else {
				System.out.println("Check e-mail, please. They must contains @ and(or) .");
			}
			
		} else {
			System.out.println("Check name and(or) surname, please. They must have letters");
		}
	}

	// if I need to check analog login name in DataBase, I call this method as testing
	private static boolean checkLogin(String login) {

		boolean checkLoginResult = false;
		
		String path = "org.gjt.mm.mysql.Driver";
		
		String sqlSelectRequest = "SELECT nickname FROM userprofile";
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String dataBasePath = "jdbc:mysql://localhost/CarRentEPAM?useSSL=false";
		String dataBaseLogin = "root";
		String dataBasePassword = "root";
		
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(dataBasePath, dataBaseLogin, dataBasePassword);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlSelectRequest);
			
			String emptyCheckDataBase = emptyCheckDataBase(resultSet);
			checkLoginResult = getBooleanValue(resultSet, emptyCheckDataBase, login);
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return checkLoginResult;
	}

	private static boolean getBooleanValue(ResultSet resultSet, String emptyCheckDataBase, String login) throws SQLException {
		
		boolean result = false;
		
		if(login.equals(emptyCheckDataBase)) {
			result = false;
		} else if(emptyCheckDataBase != null) {
			result = checkLoginsInDataBase(resultSet, login);
		} else {
			result = true;
		}
		
		return result;
	}

	private static boolean checkLoginsInDataBase(ResultSet resultSet, String login) {
		
		boolean value = true;
		
		try {
			while(resultSet.next()) {
				
				String currentLoginFromDataBase = resultSet.getString(1).trim();
				
				if(login.equals(currentLoginFromDataBase)) {
					value = false;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return value;
	}

	private static String emptyCheckDataBase(ResultSet resultSet) {
		
		String emptyCheckDataBase = null;
		
		try {
			
			if(resultSet.next()) {
				String firstString = resultSet.getString(1);
				emptyCheckDataBase = firstString;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emptyCheckDataBase;
	}

	@Override
	public User signIn(HttpServletRequest request, HttpServletResponse response, String nickname, String password) {
		
		User user;
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		iDAO iDao = daoFactory.getiDao();
		user = iDao.signIn(request, response, nickname, password);
		
		return user;
	}
}