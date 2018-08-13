package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class DisplayEditExpenseServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();

		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(out, username);
		FERService ferService = new FERServiceImpl();
		int id = Integer.parseInt(request.getParameter("expenseId"));

		Expense expense = ferService.getExpense(id);

		session.setAttribute("id", id);

		out.println("<table align='center' border='1'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Expense Report</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Expense Type :</td>");
		out.println("<td><input type='text' name='expenseType' value="+expense.getExpenseType()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Date :</td>");
		out.println("<td><input type='text' name='date' value="+expense.getDate()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Price :</td>");
		out.println("<td><input type='text' name='price' value="+expense.getPrice()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>No of items :</td>");
		out.println("<td><input type='text' name='noOfItems' value="+expense.getNoOfItems()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Total Account :</td>");
		out.println("<td><input type='text' name='totalAccount' value="+expense.getTotalAmount()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>User ID :</td>");
		out.println("<td><input type='text' name='userId' value="+expense.getUserId()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>By Whom :</td>");
		out.println("<td><input type='text' name='byWhom' value="+expense.getByWhom()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<a href=\"javascript:submitForm('EditExpenseServlet')\">EditExpense</a></td>");
		out.println("</tr>");

		out.println("</table>");

		
		}
	

}
