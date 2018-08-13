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

public class DisplayPersonalContactInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FERService service = new FERServiceImpl();
		HttpSession session = request.getSession();
		PersonalInfo personalinfo = (PersonalInfo) session.getAttribute("personalinfo");
		
		PrintWriter out = response.getWriter();

		personalinfo.getUser().setFirstName(request.getParameter("firstName"));
		personalinfo.getUser().setMiddleName(request.getParameter("middleName"));
		personalinfo.getUser().setLastName(request.getParameter("lastName"));

		HTMLUtil.displayHeaderAndLeftFrame(out, session.getAttribute("username").toString());

		out.println("<table border='1' align='center'>");

		out.println("<tr>");
		out.println("<td>Emailid</td>");
		out.println("<td><input type='text' name='email' value='" + personalinfo.getUser().getEmail() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Mobile</td>");
		out.println(
				"<td><input type='text' name='mobileNumber' value='" + personalinfo.getUser().getMobileNumber() + "'></td>");

		out.println("</tr>");

		out.println("<tr>");
		out.println(
				"<td colspan='2' align='center'><input type='button' value='Next' onclick='javascript:submitForm(\"DIsplayPersonalAddress\");'></td>");
		out.println("</tr>");
		out.println("</table>");
		HTMLUtil.displayfooter(out);

	}

}
