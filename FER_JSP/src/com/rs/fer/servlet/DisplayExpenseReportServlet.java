package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.util.HTMLUtil;

public class DisplayExpenseReportServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//String username = request.getAttribute("username").toString();
String username	=	request.getSession().getAttribute("username").toString();

		HTMLUtil.displayHeaderAndLeftFrame(out, username);

		out.println("<table align='center' border='1'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>ExpenseReport</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Expense Type</td>");
		out.println("<td><input type='text' name='expenseType'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>From Date</td>");
		out.println("<td><input type='text' name='fromDate'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>To Date</td>");
		out.println("<td><input type='text' name='toDate'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<a href=\"javascript:submitForm('expenseReport')\">getReport</a></td>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.displayfooter(out);

	}

}
