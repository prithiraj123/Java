<html>
<head>
<script>
function validateForm() {
	var form = document.AddExpenseForm;
	var errorMessage = "";
	if (form.expenseType.value == '') {
		errorMessage += "please enter expenseType.<BR>";
	}
	if (form.date.value == '') {
		errorMessage += "please enter date.<BR>";
	}
	if (form.price.value == '') {
		errorMessage += "please enter price.<BR>";
	}
	if (form.noOfItems.value == '') {
		errorMessage += "please enter noOfItems.<BR>";
	}
	if (form.totalAmount.value == '') {
		errorMessage += "please enter totalAmount.<BR>";
	}
	if (form.byWhom.value == '') {
		errorMessage += "please enter byWhom.<BR>";
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
<form name="AddExpenseForm" action='AddExpensePost.jsp'>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<table align='center'border='1'>
		<tr>
		<td colspan='2' align='center'>Add Expense</td>
		</tr>
		<tr id="errorTrID" style='display: none'>
				<td colspan="2 " align='center' id="errorTdID"></td>
			</tr>
			
		<td>ExpenseType<font color="red">*</font></td>
		<td><input type='text' name='expenseType'></td>
		</tr>
		<tr>
		<td>Date<font color="red">*</font></td>
		<td><input type='date' name='date'></td>
		</tr>
		<tr>
		<td>Price<font color="red">*</font></td>
		<td><input type='text' name='price'></td>
		</tr>

		<tr>
		<td>NOofItems<font color="red">*</font></td>
		<td><input type='text' name='noOfItems'></td>
		</tr>
		<tr>
		<td>TotalAmount<font color="red">*</font></td>
		<td><input type='text' name='totalAmount'></td>
		</tr>
		<tr>
		<td>By whom<font color="red">*</font></td>
		<td><input type='text' name='byWhom'></td>
		</tr>

		<tr>
		<td  colspan='2' align='center'><input type="button"
					value='save' onclick="validateForm();">
					
		
		</tr>

		</table>
		</form>
		</body>
		
		
<jsp:include page="Footer.jsp" />
</html>