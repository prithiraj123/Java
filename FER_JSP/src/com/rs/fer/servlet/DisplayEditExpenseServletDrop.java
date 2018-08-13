package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;


public class DisplayEditExpenseServletDrop extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest requset, HttpServletResponse response)
			throws ServletException, IOException {
		FERService ferService = new FERServiceImpl();
		PrintWriter out = response.getWriter();

		HttpSession session = requset.getSession();
		session.getAttribute("username").toString();
		HTMLUtil.displayHeaderAndLeftFrame(out, "");

		List<Expense> expenses = ferService.geteditDrop();

		if (expenses != null && !expenses.isEmpty()) {
			out.println("Expense Id :");
			out.println("<select name='expenseId'>");

			for (Expense expense : expenses) {
				out.println("<option value=" + expense.getId() + ">");
				out.println(" " + expense.getId() + "," + expense.getExpenseType() + "," + expense.getDate() + ","
						+ expense.getPrice() + "," + expense.getNoOfItems() + "," + expense.getTotalAmount() + ","
						+ expense.getUserId() + "," + expense.getByWhom());
				out.println("</option>");
			}
			out.println("</select>");
			out.println("<input type='button' value='Edit Expense' onclick=\"javascript:submitForm('displayEditExpense')\">");
		} else {
			out.println("No Expense Available  to Edit");
		}
		HTMLUtil.displayfooter(out);


				}

	}
