<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<%
	FERService ferService = new FERServiceImpl();
	int id = Integer.parseInt(request.getParameter("id"));

	Expense expense = ferService.getExpense(id);
	session.setAttribute("id", id);

%>

<table align='center' border='1'>
	<tr>
		<td colspan='2' align='center'>Expense Report</td>
	</tr>
	<tr>
		<td>Expense Type :</td>
		<td><input type='text' name='expensetype'
			value=<%=expense.getExpenseType()%>>
	</tr>
	<tr>
		<td>Date :</td>
		<td><input type='text' name='date' 
		value=<%=expense.getDate()%>>
	</tr>
	<tr>
		<td>Price :</td>
		<td><input type='text' name='price' 
		value=<%=expense.getPrice()%>>
	</tr>
	<tr>
		<td>No of items :</td>
		<td><input type='text' name='noOfItems'
			value=<%=expense.getNoOfItems()%>>
	</tr>
	<tr>
		<td>Total Amount :</td>
		<td><input type='text' name='TotalAmount'
			value=<%=expense.getTotalAmount()%>>
	</tr>
	<tr>
		<td>User ID :</td>
		<td><input type='text' name='userId'
			value=<%=expense.getUserId()%>>
	</tr>
	<tr>
		<td>By Whom :</td>
		<td><input type='text' name='byWhom'
			value=<%=expense.getByWhom()%>>
	</tr>
	<tr>
		<td colspan='2' align='center'><a
			href="javascript:submitForm('EditExpensePost.jsp')">Edit</a></td>
	</tr>

</table>

<jsp:include page="Footer.jsp" />
