package com.rs.fer.main;

import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetPersonalInfoMain {

	

	public static void main(String[] args) {
		
		FERService ferService = new FERServiceImpl();
		PersonalInfo info=ferService.getPersonalInfo(1);
		System.out.println(info.getAddress().getAddressLine1());
		System.out.println(info.getUser().getFirstName());
		
	}
	

	}

