package com.rs.fer.service;

import java.util.ArrayList;
import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;

public interface FERService {
	boolean registration(User user);

	boolean login(String username, String password);

	boolean addExpense(Expense expense);

	boolean editExpense(Expense expense);

	boolean deleteExpense(int id);

	Expense getExpense(int id);

	List<Expense> getExpenses(int userId);

	List<Expense> getExpenseReport(String type, String fromDate, String toDate);

	boolean resetPassword(String username, String currentPassword, String newPassword);

	PersonalInfo getPersonalInfo(String username);

	boolean updatePersonalInfo(User user, Address address);

	public List<Expense> getdeletedrop();

	 public  List<Expense> geteditDrop();

	PersonalInfo getPersonalInfo(int userId);
	
	boolean isUsernameAvailable(String username);
	boolean isMobileNumberAvailable(String mobileNo);
}
