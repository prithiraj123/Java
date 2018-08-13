<<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script>
function validateForm() {
	var form = document.ExpenseReportForm;
	var errorMessage = "";
	if (form.expenseType.value == '') {
		errorMessage += "please enter expenseType.<BR>";
	}
	if (form.fromDate.value == '') {
		errorMessage += "please enter fromDate.<BR>";
	}
	if (form.toDate.value == '') {
		errorMessage += "please enter toDate.<BR>";
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
<form name="ExpenseReportForm" action='ExpenseReportPost.jsp'>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<table align='center' border='1'>
<tr>
<td colspan='2' align='center'>ExpenseReport</td>
</tr>
<tr id="errorTrID" style='display: none'>
				<td colspan="2 " align='center' id="errorTdID"></td>
			</tr>
		
<tr>
<td>Expense Type<font color="red">*</font></td>
<td><input type='text' name='expenseType'></td>
</tr>
<tr>
<td>From Date<font color="red">*</font></td>
<td><input type='text' name='fromDate'></td>
</tr>
<tr>
<td>To Date<font color="red">*</font></td>
<td><input type='text' name='toDate'></td>
</tr>
<tr>
<td colspan='2' align='center'><input type="button"
					value='GetReport' onclick="validateForm();"></td>
					
<!-- <a href="javascript:submitForm('ExpenseReportPost.jsp')">getReport</a> -->
</tr>
</table>
</body>


<jsp:include page="Footer.jsp" />
</html>