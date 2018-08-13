<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
	FERService ferService = new FERServiceImpl();

	User user = new User();
	user.setFirstName(request.getParameter("firstname"));
	user.setMiddleName(request.getParameter("middlename"));
	user.setLastName(request.getParameter("lastname"));
	user.setEmail(request.getParameter("email"));
	user.setUserName(request.getParameter("userName"));
	user.setPassword(request.getParameter("password"));
	user.setMobileNumber(request.getParameter("mobileNumber"));

	boolean isRegister = ferService.registration(user);

	if (isRegister) {
		out.println("Registration success");
	} else {
		out.println("failed");

	}
	String forwardPage = isRegister ? "Login.jsp" : "Registration.jsp";

	//response.sendRedirect("login.html");
%>
<jsp:include page="<%=forwardPage%>" />