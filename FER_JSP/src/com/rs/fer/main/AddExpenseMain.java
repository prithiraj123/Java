package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class AddExpenseMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		Expense expense = new Expense();
		expense.setExpenseType("personal");
		expense.setDate("1/1/18");
		expense.setPrice(1000);
		expense.setNoOfItems(3);
		expense.setTotalAmount(5000);
		expense.setByWhom("ramya");
		expense.setUserId("3");
		expense.setId(2);

		boolean isAdded = ferService.addExpense(expense);
		if (isAdded) {
			System.out.println("Expenses added successfully");
		} else {
			System.out.println("Expenses not added ");
		}
	}

}
