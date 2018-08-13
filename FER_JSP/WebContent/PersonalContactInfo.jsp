
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.bean.PersonalInfo"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<%
	FERService service = new FERServiceImpl();

	PersonalInfo personalinfo = (PersonalInfo) session.getAttribute("personalinfo");

	personalinfo.getUser().setFirstName(request.getParameter("firstName"));
	personalinfo.getUser().setMiddleName(request.getParameter("middleName"));
	personalinfo.getUser().setLastName(request.getParameter("lastName"));
%>
<table border='1' align='center'>

	<tr>
		<td>Email id</td>
		<td><input type='text' name='email'
			value=<%=personalinfo.getUser().getEmail()%>></td>
	</tr>
	<tr>
		<td>Mobile</td>

		<td><input type='text' name='mobileNumber'
			value=<%=personalinfo.getUser().getMobileNumber()%>></td>

	</tr>

	<tr>

		<td colspan='2' align='center'><input type='button' value='Next'
			onclick='javascript:submitForm("PersonalAddressInfo.jsp")'></td>
	</tr>
</table>
<jsp:include page="Footer.jsp" />