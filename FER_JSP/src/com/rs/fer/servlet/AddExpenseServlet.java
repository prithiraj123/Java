package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class AddExpenseServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FERService ferService = new FERServiceImpl();
		Expense expense = new Expense();

		expense.setExpenseType(request.getParameter("expesneType"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice(Integer.parseInt(request.getParameter("price")));
		expense.setNoOfItems(Integer.parseInt(request.getParameter("noOfItems")));
		expense.setTotalAmount(Integer.parseInt(request.getParameter("totalAmount")));
		expense.setByWhom(request.getParameter("byWhom"));
		expense.setUserId(request.getParameter("userid"));

		boolean isAddExpense = ferService.addExpense(expense);
		
		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(out, "");
		out.println(isAddExpense ? "Expense added sucessfully" : "Add expense failed");

		HTMLUtil.displayfooter(out);

	}
}
