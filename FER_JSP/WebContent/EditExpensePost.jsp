<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
	FERService ferService = new FERServiceImpl();
	int id = Integer.parseInt(session.getAttribute("id").toString());
	Expense expense = new Expense();

	expense.setExpenseType(request.getParameter("expenseType"));
	expense.setDate(request.getParameter("date"));
	expense.setPrice(Integer.parseInt(request.getParameter("price")));
	expense.setNoOfItems(Integer.parseInt(request.getParameter("noOfItems")));
	expense.setTotalAmount(Integer.parseInt(request.getParameter("TotalAmount")));
	expense.setUserId(request.getParameter("userId"));
	expense.setByWhom(request.getParameter("byWhom"));
	expense.setId(id);
	boolean isEditExpense = ferService.editExpense(expense);
%>

<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<%
	out.println(isEditExpense ? "Expense Edited Successfully" : "Edit Expense Failed ");
%>
<jsp:include page="Footer.jsp" />