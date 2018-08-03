package by.epam.carrent.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.carrent.controller.iCommand;
import by.epam.carrent.domain.User;
import by.epam.carrent.service.ServiceFactory;
import by.epam.carrent.service.iService;

public class AccountCreating implements iCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("username").trim();
		String surname = request.getParameter("usersurname").trim();
		String mail = request.getParameter("useremail").trim();
		String phone = request.getParameter("userphone").trim();
		String role = request.getParameter("userstatus").trim();
		String nickname = request.getParameter("userlogin").trim();
		String password = request.getParameter("userpassword").trim();
		String confirmPassword = request.getParameter("userconfirmpassword").trim();
		
		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setE_mail(mail);
		user.setPhone(phone);
		user.setRole(role);
		user.setNickname(nickname);
		
		if(!user.getName().equals("") && user.getName() != null) {
			
			if(!user.getSurname().equals("") && user.getSurname() != null) {
				
				if(!user.getE_mail().equals("") && user.getE_mail() != null) {
					
					if(!user.getPhone().equals("") && user.getPhone() != null) {
						
						if(!user.getRole().equals("") && user.getRole() != null) {
						
							if(!user.getNickname().equals("") && user.getNickname() != null) {
						
								if(!password.equals("") && password != null) {
							
									if(!confirmPassword.equals("") && confirmPassword != null) {
								
										ServiceFactory serviceFactory = ServiceFactory.getInstance();
										iService iServ = serviceFactory.getiService();
										iServ.createAccount(request, response, user, password, confirmPassword);
								
									} else {
										System.out.println("Input confirmPassword field");
									}
								} else {
									System.out.println("Input password field");
								}
							} else {
								System.out.println("Input login field");
							}
						} else {
							System.out.println("Input role field");
						}
					} else {
						System.out.println("Input phone field");
					}
				} else {
					System.out.println("Input e-mail field");
				}
			} else {
				System.out.println("Input surname field");
			}
		} else {
			System.out.println("Input name field");
		}
	}
}