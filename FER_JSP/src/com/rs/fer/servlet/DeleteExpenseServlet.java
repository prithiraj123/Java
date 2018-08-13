package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class DeleteExpenseServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	FERService ferservice = new FERServiceImpl();
		int id = Integer.parseInt(request.getParameter("expenseID"));
		
		boolean isdelete=ferservice.deleteExpense(id);
		if(isdelete){
			PrintWriter out = response.getWriter();
			HTMLUtil.displayHeaderAndLeftFrame(out, "");
			// response.sendRedirect("Dashboard.html");
			out.println(isdelete ? "Deleted successfully" : "failed");
			HTMLUtil.displayfooter(out);
		
			

	}

}
}
