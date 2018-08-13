package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.util.HTMLUtil;

public class DisplayAddExpenseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//String username = request.getAttribute("username").toString();
		HTMLUtil.displayHeaderAndLeftFrame(out, "");

		out.println("<table align='center'border='1'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Add Expense</td>");
		out.println("</tr>");
		out.println("<td>ExpenseType</td>");
		out.println("<td><input type='text' name='expenseType'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Date</td>");
		out.println("<td><input type='date' name='date'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Price</td>");
		out.println("<td><input type='text' name='price'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>NOofItems</td>");
		out.println("<td><input type='text' name='noOfItems'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>TotalAmount</td>");
		out.println("<td><input type='text' name='totalAmount'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Bywhom</td>");
		out.println("<td><input type='text' name='byWhom'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<a href=\"javascript:submitForm('addExpense')\">Save</a>");
		out.println("</tr>");

		out.println("</table>");

		HTMLUtil.displayfooter(out);

	}
}
