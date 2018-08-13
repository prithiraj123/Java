package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class DisplayDeleteExpenseServletDropBox extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FERService ferservice = new FERServiceImpl();
		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(out, "");

		List<Expense> expenses = ferservice.getdeletedrop();
		if (expenses != null && !expenses.isEmpty()) {
			out.println("ExpenseId");
			out.println("<select name='expenseID'>");

			for (Expense expense : expenses) {
				out.println("<option value=" + expense.getId() + ">");
				out.println("  " + expense.getId() + "," + expense.getExpenseType() + "," + expense.getDate() + ","
						+ expense.getPrice() + "," + expense.getNoOfItems() + "," + expense.getTotalAmount() + ","
						+ expense.getByWhom());
				out.println("</option>");
			}
			out.println("</select>");
			out.println("<a href=\"javascript:submitForm('deleteExpense')\">DeleteExpense</a><br>");
		} else {
			out.println("No Expense Available to Edit");
		}

		HTMLUtil.displayfooter(out);

	}
}