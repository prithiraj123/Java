package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class DeleteExpenseMain {
	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		boolean isDeleated = ferService.deleteExpense(4);
		if (isDeleated) {
			System.out.println("expense deleated successfully");
		} else {
			System.out.println("expense not deleated ");
		}

	}
}
