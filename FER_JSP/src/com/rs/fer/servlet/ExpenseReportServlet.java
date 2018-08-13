
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

public class ExpenseReportServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FERService ferservice = new FERServiceImpl();

		String expenseType = request.getParameter("expenseType");
		String fromdate = request.getParameter("fromDate");
		String todate = request.getParameter("toDate");

		List<Expense> expense = ferservice.getExpenseReport(expenseType, fromdate, todate);
		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(out, "");
		if (expense != null) {
			
			for (Expense expenses : expense) {

				
				
				// response.sendRedirect('Dashboard.html');
			/*	out.println("<table border='1' align='center'>");
				out.println("<tr>");
				out.println("<td>ExpenseType</td>","<td>date</td>","<td>Price</td>","<td>NoOfItems</td>","<td>TotalAmount</td>","<td>ByWhom</td>","<td>Action</td>");
						
			
				
				out.println();
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>" + expenses.getExpenseType() + "</td>");
				out.println("<td> " + expenses.getDate() + "</td>");
				out.println("<td> " + expenses.getPrice() + "</td>");
				out.println("<td> " + expenses.getNoOfItems() + "</td>");
				out.println("<td> " + expenses.getTotalAmount() + "</td>");
				out.println("<td>" + expenses.getByWhom() + "</td>");
				

				out.println("<td><input type='submit' value='edit'></td>");
				out.println("</tr>");

				out.println("</table>");*/

				out.println("<table border='1' align='center'><tr>");
				out.println("<td hight=20px>Expense Type value=" + expenses.getExpenseType() + "</td>");
				out.println("<td>Date =" + expenses.getDate() + "</td>");
				out.println("<td>Price =" + expenses.getPrice() + "</td>");
				out.println("<td>Number Of Items =" + expenses.getNoOfItems() + "</td>");

				out.println("<td>Total =" + expenses.getTotalAmount() + "</td>");

				out.println("<td>By Whom =" + expenses.getByWhom() + "</td>");

				out.println("<td colspan='2'></td></tr></table>");


			}

			HTMLUtil.displayfooter(out);
		}

	
	}

}