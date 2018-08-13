<%@page import="com.rs.fer.bean.PersonalInfo"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<%
FERService ferservice = new FERServiceImpl();
String username = session.getAttribute("username").toString();

PersonalInfo personalinfo = ferservice.getPersonalInfo(username);

session.setAttribute("personalinfo", personalinfo);

%>

		<table border='1' align='center'>
		<tr>
		<td colspan='2' align='center'>NameInfo</td>
		</tr>
		<tr>
		<td>FirstName:</td>
		<td><input type='text' name='firstName' value=<%=personalinfo.getUser().getFirstName()%>></td>
		</tr>
		<tr>
		<td>MiddleName:</td>
		<td><input type='text' name='middleName' value=<%=personalinfo.getUser().getMiddleName()%>></td>
				
		</tr>
		<tr>
		<td>LastName:</td>
		
		<td><input type='text' name='lastName' value=<%= personalinfo.getUser().getLastName()%>></td>
		</tr>
		<tr>
		<td colspan='2' align='center'><input type='button' value='Next' onclick='javascript:submitForm("PersonalContactInfo.jsp")'></td>
		</td>
		</tr>
		</td>
		</table>
<jsp:include page="Footer.jsp" />