package com.rs.fer.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rs.fer.bean.Expense;
import com.rs.fer.form.ExpenseReportForm;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ExpenseReportAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		FERService ferService = new FERServiceImpl();
		ExpenseReportForm expensereportForm = (ExpenseReportForm) form;
		String expensetype = expensereportForm.getExpensetype();
		String fromdate = expensereportForm.getFromdate();
		String todate = expensereportForm.getTodate();
		List<Expense> expenseReportFlag = ferService.getExpenseReport(expensetype, fromdate, todate);
		HttpSession session = request.getSession();
		session.setAttribute("expenseReportFlag", expenseReportFlag);
		if (expenseReportFlag != null) {
			return mapping.findForward("Success");
		} else {
			return mapping.findForward("failure");

		}
	}

}
