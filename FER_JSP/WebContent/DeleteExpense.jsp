
<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.rs.fer.util.HTMLUtil"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<%
FERService ferservice = new FERServiceImpl();

List<Expense> expenses = ferservice.getdeletedrop();
if (expenses != null && !expenses.isEmpty()) {
	out.println("ExpenseId");
%>
	<select name='expenseID'>
<%  	

	for (Expense expense : expenses) {
		out.println("<option value=" + expense.getId() + ">");
		out.println("  " + expense.getId() + "," + expense.getExpenseType() + "," + expense.getDate() + ","
				+ expense.getPrice() + "," + expense.getNoOfItems() + "," + expense.getTotalAmount() + ","
				+ expense.getByWhom());
	  out.println("</option>");

		
	}

	out.println("</select>");
	out.println("<input type='button' value='Delete Expense' onclick=\"javascript:submitForm('DeleteExpensePost.jsp')\">");
} else {
}
%>






<jsp:include page="Footer.jsp" />