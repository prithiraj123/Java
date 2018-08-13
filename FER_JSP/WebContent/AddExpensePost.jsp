

<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
FERService ferService = new FERServiceImpl();
Expense expense = new Expense();

expense.setExpenseType(request.getParameter("expenseType"));
expense.setDate(request.getParameter("date"));
expense.setPrice(Integer.parseInt(request.getParameter("price")));
expense.setNoOfItems(Integer.parseInt(request.getParameter("noOfItems")));
expense.setTotalAmount(Integer.parseInt(request.getParameter("totalAmount")));
expense.setByWhom(request.getParameter("byWhom"));
expense.setUserId(request.getParameter("userid"));

boolean isAddExpense = ferService.addExpense(expense);



%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<%
out.println(isAddExpense ? "Expense added sucessfully" : "Add expense failed");
%>
<jsp:include page="Footer.jsp" />