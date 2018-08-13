
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
FERService ferService = new FERServiceImpl();

String username = request.getSession().getAttribute("username").toString();

String currentpassword = request.getParameter("currentPassword");

String newpassword = request.getParameter("newPassword");
String confirmPassword = request.getParameter("confirmPassword");

boolean isReset = ferService.resetPassword(username, currentpassword, newpassword);

%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<%
out.println(isReset ? "Reset password successfully" : "Reset password not done");
%>