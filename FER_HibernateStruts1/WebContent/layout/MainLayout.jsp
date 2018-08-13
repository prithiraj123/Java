<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<title></title>
<script type="text/javascript">
	function submitForm(urlaction) {
		var form = document.forms[0];
		form.action = urlaction;
		form.submit();
	}
</script>
</head>
<body>
	<table width='800px' height='800px' border='1'>
		<tr height='100px'>
			<td colspan="2"><tiles:insert attribute="header" /></td>
		</tr>
		<tr height='600px'>
			<td width='100px'><tiles:insert attribute="leftFrame" /></td>
			<td width='600px'><tiles:insert attribute="body" /></td>
		</tr>
		<tr height='100px'>
			<td colspan="2"><tiles:insert attribute="footer" /></td>
		</tr>
	</table>

</body>
</html>