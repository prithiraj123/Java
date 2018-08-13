package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class DIsplayPersonalAddressServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		PersonalInfo personalinfo = (PersonalInfo) session.getAttribute("personalinfo");

		personalinfo.getUser().setEmail(request.getParameter("email"));
		personalinfo.getUser().setMobileNumber(request.getParameter("mobileNumber"));
		
		HTMLUtil.displayHeaderAndLeftFrame(out, session.getAttribute("username").toString());

		out.println("<table  align='center' border='2'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Address Info</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Address Line1</td>");
		out.println("<td><input type='text' name='addressLine1' value='" + personalinfo.getAddress().getAddressLine1()
				+ "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Address Line2</td>");
		out.println("<td><input type='Text' name='addressLine2' value='" + personalinfo.getAddress().getAddressLine2()
				+ "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("<td><input type='Text' name='city' value='" + personalinfo.getAddress().getCity() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("<td><input type='Text' name='state' value='" + personalinfo.getAddress().getState() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Zip</td>");
		out.println("<td><input type='Text' name='zip' value='" + personalinfo.getAddress().getZip() + " '></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Country</td>");
		out.println(
				"<td><input type='Text' name='country' value='" + personalinfo.getAddress().getCountry() + "'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println(
				"<td colspan='2' align='center' ><input type='button' value='Next' onclick='javascript:submitForm(\"displayPersonalReview\")'></td>");
		out.println("</tr>");

		out.println("</table>");

		HTMLUtil.displayfooter(out);

	}

}
