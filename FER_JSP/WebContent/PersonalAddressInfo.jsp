
<%@page import="com.rs.fer.bean.PersonalInfo"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<%

PersonalInfo personalinfo = (PersonalInfo) session.getAttribute("personalinfo");

personalinfo.getUser().setEmail(request.getParameter("email"));
personalinfo.getUser().setMobileNumber(request.getParameter("mobileNumber"));

%>
<table  align='center' border='2'>
		<tr>
		<td colspan='2' align='center'>Address Info</td>
		</tr>
		<tr>
		<td>Address Line1</td>
		<td><input type='text' name='addressLine1' value=<%=personalinfo.getAddress().getAddressLine1()%>>
			</td>
		</tr>
		<tr>
		<td>Address Line2</td>
		<td><input type='Text' name='addressLine2' value=<%= personalinfo.getAddress().getAddressLine2() %>></td>
		</tr>
		<tr>
		<td>City</td>
		<td><input type='Text' name='city' value=<%=personalinfo.getAddress().getCity() %>></td>
		</tr>
		<tr>
		<td>State</td>
		<td><input type='Text' name='state' value=<%= personalinfo.getAddress().getState()%>></td>
		</tr>
		<tr>
		<td>Zip</td>
		<td><input type='Text' name='zip' value=<%= personalinfo.getAddress().getZip()%>></td>
		</tr>
		<tr>
		<td>Country</td>
		
				<td><input type='Text' name='country' value=<%=personalinfo.getAddress().getCountry() %>></td>
		</tr>

		<tr>
		
				<td colspan='2' align='center' ><input type='button' value='Next' onclick="javascript:submitForm('PersonalReviewInfo.jsp')"></td>
		</tr>

		</table>

<jsp:include page="Footer.jsp" />