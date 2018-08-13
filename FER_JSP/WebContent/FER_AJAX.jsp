<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
	String username = request.getParameter("username");
	FERService ferservice = new FERServiceImpl();
	boolean isUsernameAvailable = ferservice.isUsernameAvailable(username);

	out.println(isUsernameAvailable ? "Y" : "N");
%>