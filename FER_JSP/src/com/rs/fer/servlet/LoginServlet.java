package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		FERService ferService = new FERServiceImpl();

		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		session.setAttribute("username", username);

		// String username = request.getParameter("username");
		// String password = request.getParameter("password");

		boolean isValidUser = ferService.login(username, password);
		if (isValidUser) {

			HTMLUtil.displayHeaderAndLeftFrame(out, username);

			out.println("welcome to user=" + username);
			HTMLUtil.displayfooter(out);
			// response.sendRedirect("Dashboard.html");
		} else {
			out.println("user is not valid");

		}

	}
}