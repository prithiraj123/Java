package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class LoginMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		boolean isValidUser = ferService.login("raj", "12345");
		if (isValidUser) {
			System.out.println("user is valid");
		} else {
			System.out.println("user is not valid");
		}
	}

}
