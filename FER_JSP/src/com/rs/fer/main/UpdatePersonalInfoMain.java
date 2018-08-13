package com.rs.fer.main;
import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;


	public class UpdatePersonalInfoMain {
		public static void main(String[] args) {
			FERService ferService=new FERServiceImpl();
		
	    User user=new User();
	    user.setFirstName("alan");
	    user.setMiddleName("");
	    user.setLastName("setty");
	    user.setEmail("alandasssjds0@gmail.com");
	    user.setMobileNumber("904654041");
	    user.setUserName("prithiraj");
	    user.setPassword("akash111");
	    user.setId(1);
	    
	    Address address=new Address();
	    
	    address.setAddressLine1("CGR");
	    address.setAddressLine2("madhapur");
	    address.setCity("hyd");
	    address.setState("tel");
	    address.setZip("50084");
	    address.setCountry("india");
	    address.setUserId(1);
	    
	     boolean isUpdated = ferService.updatePersonalInfo(user, address);
	     if(isUpdated){
	    	 System.out.println("success");
	     }else{
	    	 System.out.println("fail");
	     }
	}
	}
		