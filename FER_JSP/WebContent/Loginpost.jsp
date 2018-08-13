<%@page import="com.rs.fer.util.HTMLUtil"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<% 
FERService ferService = new FERServiceImpl();

String username = request.getParameter("username").toString();
String password = request.getParameter("password").toString();

// String username = request.getParameter("username");
// String password = request.getParameter("password");

boolean isValidUser = ferService.login(username, password);
if (isValidUser) {
	session.setAttribute("username", username);
%>
	
  <jsp:include page="Header.jsp"/>
  <jsp:include page="LeftFrame.jsp"/>
	welcome to user ${username }
	<jsp:include page="Footer.jsp"/>
<%
} else {
	out.println("user is not valid");
%>
	<jsp:include page="Login.jsp"/>
<%
}

%>