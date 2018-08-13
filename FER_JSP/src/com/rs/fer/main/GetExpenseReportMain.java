package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpenseReportMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		List<Expense> expense = ferService.getExpenseReport("function", "2020-12-17", "2020-12-17");
		if (expense != null) {
			for (Expense expenses : expense) {
				System.out.println(expenses.getPrice());
			}
		}
	}

}
