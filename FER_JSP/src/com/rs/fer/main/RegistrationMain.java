package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationMain {
	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		User user = new User();
		user.setFirstName("ruturaj");
		user.setMiddleName("ku");
		user.setLastName("sinhaaaa");
		user.setEmail("akash750@gmail.com");
		user.setMobileNumber("9040410");
		user.setPassword("124000");
		user.setUserName("raj");
		boolean isRegister = ferService.registration(user);
		if (isRegister) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		} 
	}
}
