package com.rs.fer.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.rs.fer.DBUtil.HibernateUtil;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;

public class FERServiceImpl implements FERService {

	@Override
	public boolean registration(User user) {

		Session session = null;
		boolean registrationFlag = false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			registrationFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return registrationFlag;
	}

	@Override
	public boolean login(String username, String password) {
		Session session = null;
		boolean loginFlag = false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(User.class);
			Criterion crit = Restrictions.eq("username", username);
			Criterion cn = Restrictions.eq("password", password);

			criteria.add(crit);
			criteria.add(cn);

			List l = criteria.list();
			if (l != null) {
				return l.get(0) != null;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		return loginFlag;
	}

	@Override
	public boolean addExpense(Expense expense) {
		Session session = null;
		boolean addExpenseFlag = false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(expense);
			tx.commit();
			addExpenseFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return addExpenseFlag;
	}

	@Override
	public boolean deleteExpense(int id) {

		Session session = null;
		boolean deleteExpenseFlag = false;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			Expense expense = (Expense) session.get(Expense.class, id);
			Transaction tx = session.beginTransaction();
			session.delete(expense);
			tx.commit();

			deleteExpenseFlag = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return deleteExpenseFlag;

	}

	@Override
	public boolean editExpense(Expense expense) {
		Session session = null;
		boolean editExpenseFlag = false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.update(expense);
			tx.commit();
			editExpenseFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return editExpenseFlag;
	}

	@Override
	public Expense getExpense(int id) {

		Expense expense = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("from Expense p where p.id='" + id + "'");

			List<Expense> list = query.list();
			Iterator<Expense> iterator = list.iterator();
			while (iterator.hasNext()) {
				expense = iterator.next();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return expense;
	}

	@Override
	public List<Expense> getExpenseReport(String expensetype, String fromdate, String todate) {
		// TODO Auto-generated method stub
		Expense expense = null;
		Session session = null;
		List<Expense> expenses = new ArrayList<Expense>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("from Expense p where p.expensetype='" + expensetype + "'and  p.date between'"
					+ fromdate + "'and'" + todate + "'");
			List<Expense> list = query.list();
			Iterator<Expense> iterator = list.iterator();
			while (iterator.hasNext()) {
				expense = iterator.next();
				expenses.add(expense);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return expenses;
	}

	@Override
	public List<Expense> getExpenses() {

		Session session = null;
		List<Expense> expenses = new ArrayList<Expense>();
		Expense expense = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(" from Expense p");
			List<Expense> list = query.list();
			Iterator<Expense> iterator = list.iterator();
			while (iterator.hasNext()) {
				expense = iterator.next();
				expenses.add(expense);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return expenses;
	}

	@Override
	public boolean resetPassword(String username, String currentpassword, String newPassword) {

		Session session = null;
		boolean resetPasswordFlag = false;
		try {
			// User user =(User) session.get(User.class, username);
			// User user=new User();
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("update User u set u.password='" + newPassword + "' where u.username='"
					+ username + "'and u.password='" + currentpassword + "'");
			q.executeUpdate();
			tx.commit();

			// session.
			resetPasswordFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resetPasswordFlag;
	}

	@Override
	public boolean isUsernameAvailabe(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
