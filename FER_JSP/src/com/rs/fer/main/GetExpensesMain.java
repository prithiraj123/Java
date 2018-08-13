package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpensesMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		List<Expense> expense=ferService.getExpenses(4);
		if(expense!=null) {
			for(Expense expenses:expense) {
				System.out.println(expenses.getByWhom());
			}
		}
	
		
	}

	}

