/*package com.rs.fer.util;

import java.io.PrintWriter;

public class HTMLUtil {

	public static void displayHeaderAndLeftFrame(PrintWriter out, String username) {
		out.println("<html>");
		out.println("<head>");

		out.println("<title>FER_Dashboard</title>");
		out.println("<script>");
		out.println("function submitform (action)");       //var action
		out.println("var form=document.Dashboardform");
		out.println("form.action=action");
		out.println("form.submit()");
		out.println("</script>");

		out.println("</head>");
		out.println("<body>");
		out.println("form name='Dashboardform'");
		out.println("<table align ='center' border='1' height='600px'width='800px'>");
		out.println("<tr height='100px'>");
		out.println("<td colspan='2' align='center'>");
		out.println("<h2>Family Expense Report User:" + username + "</h2>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width='150px'>");
		out.println("<a href=\"javascript:submitform('displayAddExpense')\">Add Expense</a><br><br><br>");
		out.println("<a href=EditExpenseDropbox.html>Edit Expense</a><br><br><br>");
		out.println("<a href=DeletExpenseDropbox.html>Delete Expense</a><br><br><br>");
		out.println("<a href=ExpenseReport.html>Expense Report</a><br><br><br>");
		out.println("<a href=ResetPassword.html>Reset password</a><br><br><br>");
		out.println("<a href=PersonalNameinfo.html>Update Personal info</a>");
		out.println("</td>");

		out.println("<td align='center'>");
	}

	public static void displayfooter(PrintWriter out){
		out.println("</td>");
		
		out.println("</tr>");
		out.println("<tr height='100px'>");
		out.println("<td colspan='2' align='center'>");
		out.println("<h4>Footer</h4>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");

		out.println("</body>");
		out.println("</html>");
		
	}

	//public static void displayHeaderAndLeftFrame(PrintWriter out,)
	
		
	}
*/
package com.rs.fer.util;

import java.io.PrintWriter;

public class HTMLUtil {

	public static void displayHeaderAndLeftFrame(PrintWriter out, String username) {
		out.println("<html>");
		out.println("<head>");

		out.println("<title>FER_Dashboard</title>");
		out.println("<script>");
		out.println("function submitForm(action) {");
		out.println("var form=document.DashboardForm;");
		out.println("form.action=action;");
		out.println("form.submit();");
		out.println("}");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form name='DashboardForm'>");
		out.println("<table align ='center' border='1' height='600px'width='800px'>");
		out.println("<tr height='100px'>");
		out.println("<td colspan='2' align='center'>Family Expense Report");
		out.println(" User:" + username + "</td>");
		// out.println("</td>");
		// out.println("</tr>");
		out.println("<tr>");
		out.println("<td width='150px'>");
		out.println("<a href=\"javascript:submitForm('displayAddExpense')\">AddExpense</a><br><br><br>");
		out.println("<a href=\"javascript:submitForm('displayEditExpense')\">EditExpesne</a><br><br><br>");
		out.println("<a href=\"javascript:submitForm('diaplayDeleteExpenseDrop')\">DeleteExpense</a><br><br><br>");
		out.println("<a href=\"javascript:submitForm('displayExpenseReport')\">ExpenseReport</a><br><br><br>");
		out.println("<a href=\"javascript:submitForm('DisplayResetPassword')\">Reset password</a><br><br><br>");
		out.println("<a href=\"javascript:submitForm('NameInfoServlet')\">Update Personal info</a><br><br><br>");
		out.println("</td>");
		out.println("<td align='center'>");//displayEditExpense,diaplayDeleteExpenseDrop

	}

	public static void displayfooter(PrintWriter out) {
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr height='100px'>");
		out.println("<td colspan='2' align='center'>Footer</td>");

		out.println("</tr>");
		out.println("</table>");

		out.println("</body>");
		out.println("</form>");
		out.println("</html>");

	}

}
