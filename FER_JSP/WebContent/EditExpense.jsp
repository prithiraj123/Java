<%@page import="java.util.List"%>
<%@page import="com.rs.fer.bean.Expense"%>

<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<%
	FERService ferService = new FERServiceImpl();

	List<Expense> expenses = ferService.geteditDrop();

	if (expenses != null && !expenses.isEmpty()) {
		out.println("Expense Id :");
%>
<select name='id'>
	<%
		for (Expense expense : expenses) {

				out.println("<option value=" + expense.getId() + ">");
				out.println(" " + expense.getId() + "," + expense.getExpenseType() + "," + expense.getDate() + ","
						+ expense.getPrice() + "," + expense.getNoOfItems() + "," + expense.getTotalAmount() + ","
						+ expense.getUserId() + "," + expense.getByWhom());
				out.println("</option>");
			}
	%>
</select>
<input type='button' value='Edit'
	onclick="javascript:submitForm('DisplayEditExpense.jsp')">
<%
	} else {
		out.println("No Expense Available  to Edit");
	}
%>
<jsp:include page="Footer.jsp" />