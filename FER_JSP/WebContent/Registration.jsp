<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<script>
	function validateForm() {

		var form = document.RegistrationForm;
		var errorMessage = "";
		if (form.firstname.value == '') {
			errorMessage += "please enter firstname.<BR>";
		}
		if (form.lastname.value == '') {
			errorMessage += "please enter lastname.<BR>";
		}
		if (form.email.value == '') {
			errorMessage += "please enter email.<BR>";
		}
		if (form.userName.value == '') {
			errorMessage += "please enter userName.<BR>";
			
		} else if (form.isUsernameAvailable.value == 'N') {
			
			errorMessage += "Username is not avilable:Please Choose Different Name.<BR>"
		}
		if (form.password.value == '') {

			errorMessage = errorMessage + "please enter password.<BR>";
		}
		if (form.mobileNumber.value == '') {
			errorMessage += "please enter mobileNumber.<BR>";
			
		}else if(isNaN(form.mobileNumber.value)){
			
			errorMessage+="please enter valid mobileNumber.<BR>";
		}
		/* function validateMobileNumber() {
			var form = document.RegistrationForm;
			var mobileNo = form.mobileNo.value;
			var url = "Ajax_Mobileno.jsp?mobileNo=" + mobileNo;

			if (window.XMLHttpRequest) {
				another_request = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				another_request = new ActiveXObject("Microsoft.XMLHTTP");
			}
			try {
				another_request.onreadystatechange = getAnotherResponse;
				another_request.open("GET", url, true);
				another_request.send();

			} catch (e) {
				alert("Unable to connect to server");
			}
		}
		function checkMobileNumberInput() {
			var x = form.mobileNo.value;
			if (isNaN(x)) {
				alert("Must input numbers");
				return false;
			}
		}
 */

		}
		var errorTrID = document.getElementById('errorTrID');
		if (errorMessage != '') {
			//alert(errorMessage);
			var errorTdID = document.getElementById('errorTdID');
			errorTdID.innerHTML = errorMessage;var another_request;
						errorTdID.style.color = 'red';

			errorTrID.style.display = '';
		} else {
			errorTrID.style.display = 'none';
			form.submit('Registrationpost.jsp');
		}

	
	var request;
	function validateUsername() {
		var form = document.RegistrationForm;
		var username = form.userName.value;
		var url = "FER_AJAX.jsp?username=" + username;

		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}

		try {
			request.onreadystatechange = getResponse;
			request.open("GET", url, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}
	/* var another_request;
	function validateMobileNumber() {
		var form = document.RegistrationForm;
		var mobileNo = form.mobileNo.value;
		var url = "Ajax_mobileNumber.jsp?mobileNo=" + mobileNo;

		if (window.XMLHttpRequest) {
			another_request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			another_request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		try {
			another_request.onreadystatechange = getAnotherResponse;
			another_request.open("GET", url, true);
			another_request.send();

		} catch (e) {
			alert("Unable to connect to server");
		}
	}
	function checkMobileNumberInput() {
		var x = form.mobileNo.value;
		if (isNaN(x)) {
			alert("Must input numbers");
			return false;
		}
	}
 */

	function getResponse() {
		if (request.readyState == 4) {
			var response = request.responseText.trim();
			var RegistrationButtonId = document
					.getElementById('RegistrationButtonId');
			//alert("."+response+".");
			//document.getElementById('amit').innerHTML=val;
			var tdMessageId = document.getElementById('tdMessageId');
			var message = "";
			if (response == "N") {
				message = "Username is not avilable:Please Choose Different Name";
				tdMessageId.style.color = 'red';
			} else {
				message = "Username is avilable";
				tdMessageId.style.color = 'green';
			}
			tdMessageId.innerHTML = message;
			document.getElementById('trMessageId').style.display = '';
			document.getElementById("isUsernameAvailable").value=response.trim();
		}
	}
	function getAnotherResponse() {
		if (another_request.readyState == 4) {
			var anotherResponse = another_request.responseText;
			var registrationButtonId = document
					.getElementById('registrationButtonId');

			if (anotherResponse.trim() == 'N') {
				alert('Mobile number is not available...')
				registrationButtonId.disabled = true;
			} else {
				registrationButtonId.disabled = false;
			}
		}

</script>
</head>
<body>
	<form name="RegistrationForm" action="Registrationpost.jsp">
		<table align="center" border="1">
			<tr>
				<td colspan="2 " align="center">Registration</td>
			</tr>
			<tr id="errorTrID" style='display: none;'>
				<td colspan="2 " align="center" id="errorTdID" style='color: red;'></td>
			</tr>

			<tr>
				<td>first name <font color='red'>*</font></td>
				<td><input type="text" name="firstname"></td>
			</tr>
			<tr>
				<td>middle name</td>
				<td><input type="text" name="middlename"></td>
			</tr>


			<tr>
				<td>last name <font color='red'>*</font></td>
				<td><input type="text" name="lastname"></td>
			</tr>

			<tr>
				<td>email <font color='red'>*</font></td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>userName <font color='red'>*</font></td>
				<td><input type="text" name="userName"
					onchange="javascript: validateUsername()"></td>
			</tr>
			<tr id='trMessageId' style='display: none;'>
				<td colspan='2' id='tdMessageId'></td>
			</tr>

			<tr>
				<td>password <font color='red'>*</font></td>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>
				<td>mobileNumber <font color='red'>*</font></td>
				<td><input type="text" name="mobileNumber"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type='button'
					value="Registration" onclick="validateForm();"
					id="RegistrationButtonId"> &nbsp;</td>
			</tr>
		</table>
		<input type="hidden" name="isUsernameAvailable"
			id="isUsernameAvailable">
	</form>
</body>

</html>