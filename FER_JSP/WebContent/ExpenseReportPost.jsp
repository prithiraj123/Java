<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.rs.fer.util.HTMLUtil"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<%
FERService ferservice = new FERServiceImpl();

String expenseType = request.getParameter("expenseType");
String fromdate = request.getParameter("fromDate");
String todate = request.getParameter("toDate");

List<Expense> expense = ferservice.getExpenseReport(expenseType, fromdate, todate);
if (expense != null) {
	
	for (Expense expenses : expense) {

		
%>	
		<table border='1' align='center'>
		<tr>
						<td>Expense Type</td>
						<td>Date</td>
						<td>Price</td>
						<td>No Of Items</td>
						<td>Total Amount</td>
						<td>By Whom</td>
						<td>Action    </td></tr>
		
		<tr>
		<td><%=expenses.getExpenseType()  %></td>
		<td><%=expenses.getDate() %></td>
		<td><%= expenses.getPrice()  %></td>
		<td><%=expenses.getNoOfItems() %></td>

		<td><%= expenses.getTotalAmount() %></td>

		<td><%= expenses.getByWhom()  %></td>

		
		<td><a href="EditExpense.jsp">Edit</a>
					
						<a href="DeleteExpense.jsp">Delete</a></td>
						</tr>
		</table>


<%
	}
}
%>

<jsp:include page="Footer.jsp" />