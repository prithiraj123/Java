<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<html:form action="Register">
		<table border="10" align="center">

			<tr>
				<td colspan="2" align="center" style="color: red;"><html:errors /></td>
			</tr>

			<tr>
				<td colspan="2" align="center">Registration</td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><html:text property="firstname" name="RegistrationForm" /></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><html:text property="middlename" name="RegistrationForm" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><html:text property="lastname" name="RegistrationForm" /></td>
			</tr>
			<tr>
				<td>EMail</td>
				<td><html:text property="emailid" name="RegistrationForm" /></td>
			</tr>
			<tr>
				<td>User name</td>
				<td><html:text property="username" name="RegistrationForm" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><html:text property="password" name="RegistrationForm" /></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><html:text property="mobile" name="RegistrationForm" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><html:submit>Registration</html:submit>
				</td>
			</tr>
		</table>
	</html:form>

</body>
</html>