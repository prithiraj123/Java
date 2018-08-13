package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		boolean isReset = ferService.resetPassword("", "1234", "8523");
		if (isReset) {
			System.out.println("reset password successfully");
		} else {
			System.out.println("reset password not done");
		}
	}

}
