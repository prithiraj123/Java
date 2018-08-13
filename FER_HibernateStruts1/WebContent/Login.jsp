<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<div style="color: red">
		<html:errors />
	</div>
	<html:form action="Login">
		<table border="10" align="center">

			<tr>
				<td colspan="2" align="center" style="color: red;"><html:errors /></td>
			</tr>

			<tr>
				<td colspan="2" align="center">Login</td>
			</tr>
			<tr>
				<td>User name</td>
				<td><html:text property="username" name="LoginForm" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><html:password property="password" name="LoginForm" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><html:submit>Login</html:submit>
					<a href="Registration.jsp">Registration</a></td>
			</tr>

		</table>
	</html:form>
</body>
</html>


