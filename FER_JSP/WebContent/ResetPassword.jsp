<<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script>
function validateForm() {
	var form = document.ResetPasswordForm;
	var errorMessage = "";
	if (form.currentPassword.value == '') {
		errorMessage += "please enter currentPassword.<BR>";
	}
	if (form.newPassword.value == '') {
		errorMessage += "please enter newPassword.<BR>";
	}
	if (form.confirmPassword.value == '') {
		errorMessage += "please enter confirmPassword.<BR>";
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

<form name="ResetPasswordForm" action='ResetPasswordPost.jsp'>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<table align='center' border='1'>
	<tr>
		<td colspan='2' align='center'>ResetPassword</td>
	</tr>
	<tr id="errorTrID" style='display: none'>
				<td colspan="2 " align='center' id="errorTdID"></td>
			</tr>

	<tr>
		<td>Current Password<font color="red">*</font></td>
		<td><input type='text' name='currentPassword'></td>
	</tr>
	<tr>
		<td>New password<font color="red">*</font></td>
		<td><input type='password' name=newPassword></td>
	</tr>
	<tr>
		<td>Confirm password<font color="red">*</font></td>
		<td><input type='password' name=confirmPassword></td>
	</tr>


	<tr>
		<td colspan='2' align='center'><input type="button"
					value='Reset' onclick="validateForm();">
		</td>
	</tr>

</table>
</form>
</body>
<jsp:include page="Footer.jsp" />
</html>