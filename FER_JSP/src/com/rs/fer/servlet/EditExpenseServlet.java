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

public class EditExpenseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		HTMLUtil.displayHeaderAndLeftFrame(out, "");
		FERService ferService=new FERServiceImpl();
		int id=Integer.parseInt(session.getAttribute("id").toString());
		Expense expense=new Expense();

			expense.setExpenseType(request.getParameter("expenseType"));
			expense.setDate(request.getParameter("date"));
			expense.setPrice(Integer.parseInt(request.getParameter("price")));
			expense.setNoOfItems(Integer.parseInt(request.getParameter("noOfItems")));
			expense.setTotalAmount(Integer.parseInt(request.getParameter("totalAmount")));
			expense.setUserId(request.getParameter("userId"));
			expense.setByWhom(request.getParameter("byWhom"));
			expense.setId(id);
			boolean isEditExpense=ferService.editExpense(expense);
			
			out.println(isEditExpense ? "Expense Edit Successfully" : "Edit Expense Failed ");
			HTMLUtil.displayfooter(out);

    	

			    	}
	}


