package com.rs.fer.service;

import java.sql.Connection;
import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;

public interface FERService {

	boolean login(String username, String password);

	boolean registration(User user);

	boolean addExpense(Expense expense);

	boolean deleteExpense(int id);

	boolean editExpense(Expense expense);

	Expense getExpense(int expenseid);

	List<Expense> getExpenseReport(String expensetype, String fromdate, String todate);

	List<Expense> getExpenses();

	boolean resetPassword(String username, String currentpassword, String newPassword);

	boolean isUsernameAvailabe(String username);

}