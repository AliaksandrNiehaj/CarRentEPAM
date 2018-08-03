package by.epam.carrent.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.carrent.domain.User;

public class DAO implements iDAO{
	
	@Override
	public void createAccount(HttpServletRequest request, HttpServletResponse response, User user, String password) {
		
		String path = "org.gjt.mm.mysql.Driver";
		Connection connection = null;
		PreparedStatement prst = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName(path);
			connection = DriverManager.getConnection("jdbc:mysql://localhost/CarRentEPAM?useSSL=false", "root", "root");
			
			String sql = "INSERT into userprofile (name, surname, email, phone, status, nickname, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
			prst = connection.prepareStatement(sql);
			
			prst.setString(1, user.getName());
			prst.setString(2, user.getSurname());
			prst.setString(3, user.getE_mail());
			prst.setString(4, user.getPhone());
			prst.setString(5, user.getRole());
			prst.setString(6, user.getNickname());
			prst.setString(7, password);
			
			prst.executeUpdate();
			
			st = connection.createStatement();
			String select = "SELECT * FROM userprofile";
			rs = st.executeQuery(select);
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8));
			}
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			if (prst != null) {
				try {
					prst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
			response.sendRedirect("creating_account");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User signIn(HttpServletRequest request, HttpServletResponse response, String nickname, String password) {
		
		User user = null;
		
		String path = "org.gjt.mm.mysql.Driver";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName(path);
			connection = DriverManager.getConnection("jdbc:mysql://localhost/CarRentEPAM?useSSL=false", "root", "root");
			
			String sql = "SELECT name, surname, email, phone, status, nickname from userprofile WHERE nickname=? and password=?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, nickname);
			preparedStatement.setString(2, password);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
				user = new User();
				user.setName(resultSet.getString(1));
				user.setSurname(resultSet.getString(2));
				user.setE_mail(resultSet.getString(3));
				user.setPhone(resultSet.getString(4));
				user.setRole(resultSet.getString(5));
				user.setNickname(resultSet.getString(6));
				
				String role = user.getRole();
				String pathRetslation = null;
				
				if(role.equals("renter")) {
					pathRetslation = "sign_in_renter";
				} else if (role.equals("landlord")) {
					pathRetslation = "sign_in_landlord";
				} else if (role.equals("administrator")){
					pathRetslation = "sign_in_administrator";
				}

				try {
					response.sendRedirect(pathRetslation);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} else {
				try {
					response.sendRedirect("authorization");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}