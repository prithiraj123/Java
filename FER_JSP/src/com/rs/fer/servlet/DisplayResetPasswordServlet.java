package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.util.HTMLUtil;

public class DisplayResetPasswordServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(out, "");

		out.println("<table  align='center' border='1'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center' >ResetPassword</td>");
		out.println("/tr>");
	
		

		out.println("<tr>");
		out.println("<td>Current Password</td>");
		out.println("<td><input type='text' name='currentPassword'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>New password</td>");
		out.println("<td><input type='password' name=newPassword></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Confirm password</td>");
		out.println("<td><input type='password' name=confirmPassword></td>");
		out.println("</tr>");


		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<a href=\"javascript:submitForm('ResetPassword')\">Reset</a></td>");
		out.println("</tr>");

		out.println("</table>");
		HTMLUtil.displayfooter(out);

	}

}