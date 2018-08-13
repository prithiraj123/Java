<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<%
FERService ferservice = new FERServiceImpl();
int id = Integer.parseInt(request.getParameter("expenseID"));

boolean isdelete=ferservice.deleteExpense(id);
if(isdelete){
	// response.sendRedirect("Dashboard.html");
	out.println(isdelete ? "Deleted successfully" : "failed");
	
}
%>
<jsp:include page="Footer.jsp" />