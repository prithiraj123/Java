package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class EditExpenseMain {

	public static void main(String[] args) {

		FERService ferservice = new FERServiceImpl();
		Expense expense = new Expense();
		expense.setExpenseType("function");
		expense.setDate("20/12/17");
		expense.setPrice(1005);
		expense.setNoOfItems(5);
		expense.setTotalAmount(6000);
		expense.setByWhom("ramesh");
		expense.setUserId("4");
		expense.setId(5);
		

		boolean isUpdated = ferservice.editExpense(expense);
		if (isUpdated) {
			System.out.println("Expense edited successfully");
		} else {
			System.out.println("Expense not edited");
		}

	}
}