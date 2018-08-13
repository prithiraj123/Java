<html>
<head>
<meta charset="ISO-8859-1">
<title>Login.jsp</title>
<script>
	function validateForm() {
		var form = document.LoginForm;
		var errorMessage = "";
		if (form.username.value == '') {
			errorMessage += "please enter Username.<BR>";
		}
		if (form.password.value == '') {
			errorMessage += "please enter Password.<BR>";
		}
		var errorTrID = document.getElementById('errorTrID');
		if (errorMessage != '') {
			//alert(errorMessage);
			var errorTdID = document.getElementById('errorTdID');
			errorTdID.innerHTML = errorMessage;
			errorTdID.style.color = 'red';

			errorTrID.style.display = '';
		} else {
			errorTrID.style.display = 'none';
			form.submit();

		}
	}
</script>
</head>
<body>
	<form name="LoginForm" action='Loginpost.jsp' method="get">
		<h1>Please Login</h1>
		<table align='center' border='1'>
			<tr>
				<td colspan="2 " align='center'>login</td>
			</tr>
			<tr id="errorTrID" style='display: none'>
				<td colspan="2 " align='center' id="errorTdID"></td>
			</tr>
			<tr>
				<td>username <font color="red">*</font></td>
				<td><input type='text' name='username'></td>
			</tr>

			<tr>
				<td>password<font color="red">*</font></td>
				<td><input type="password" name='password'></td>
			</tr>
			<tr>
				<td colspan="2" align='center'><input type="button"
					value='login' onclick="validateForm();"> &nbsp; <a
					href='Registration.jsp'>Register</a></td>
			</tr>
		</table>
	</form>
</body>
</html>