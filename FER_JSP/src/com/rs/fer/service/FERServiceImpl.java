package com.rs.fer.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;
import com.rs.fer.util.DBUtil;

public class FERServiceImpl implements FERService {
	static Logger log = Logger.getLogger(FERServiceImpl.class.getName());

	@Override
	public boolean registration(User user) {
		boolean isregister = false;
		Connection connection = null;
		PreparedStatement pstatement = null;
		log.info("user:" + user);

		try {

			connection = DBUtil.getConnection();
			// System.out.println("Connecting to a selected database...");

			// STEP 3: Creating a statement
			// System.out.println("Creating a statement...");
			String query = "insert into user(firstname,middlename,lastname,email,username,password,mobileNumber) values(?,?,?,?,?,?,?)";
			pstatement = connection.prepareStatement(query);
			// pstatement.setInt(1, 4);
			pstatement.setString(1, user.getFirstName());
			pstatement.setString(2, user.getMiddleName());
			pstatement.setString(3, user.getLastName());
			pstatement.setString(4, user.getEmail());
			pstatement.setString(5, user.getUserName());
			pstatement.setString(6, user.getPassword());
			pstatement.setString(7, user.getMobileNumber());
			// pstatement.addBatch();

			// int[] noRecInsArr = pstatement.executeBatch();
			// STEP 4: Execute statement
			int i = pstatement.executeUpdate();

			System.out.println("total number" + i);

			isregister = i > 0;

		} catch (SQLException e) {
			log.error("SQLException:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("isregister:" + isregister);
		return isregister;
	}

	@Override
	public boolean login(String username, String password) {
		boolean isValidUser = false;
		Connection connection = null;
		PreparedStatement pstatement = null;
		log.info("username:" + password);

		try {
			connection = DBUtil.getConnection();
			String query = "select * from user where userName=? and password=? ";
			pstatement = connection.prepareStatement(query);

			pstatement.setString(1, username);
			pstatement.setString(2, password);

			// STEP 4: Execute statement

			ResultSet resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				isValidUser = true;
			}
		} catch (SQLException e) {
			log.error("SQLexpection:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);

		}
		log.info("isValidUser:" + isValidUser);
		return isValidUser;
	}

	@Override
	public boolean addExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement pstatement = null;
		log.info("Expense:" + expense);
		boolean isAdded = false;
		try {
			connection = DBUtil.getConnection();
			// STEP 3: Creating a statement
			// System.out.println("Creating a statement...");
			String query = "insert into expense(userId,expenseType,date,price,noOfItems,totalAmount,byWhom) values(?,?,?,?,?,?,?)";
			pstatement = connection.prepareStatement(query);
			// pstatement.setInt(1, 2);
			pstatement.setString(1, expense.getUserId());
			pstatement.setString(2, expense.getExpenseType());
			pstatement.setString(3, expense.getDate());
			pstatement.setInt(4, expense.getPrice());
			pstatement.setInt(5, expense.getNoOfItems());
			pstatement.setInt(6, expense.getTotalAmount());
			pstatement.setString(7, expense.getByWhom());
			// pstatement.addBatch();

			int i = pstatement.executeUpdate();

			isAdded = i > 0;

		} catch (SQLException e) {
			log.error("SQLexpection:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("isAdded:" + isAdded);
		return isAdded;
	}

	@Override
	public boolean editExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement pstatement = null;
		log.info("Expense:" + expense);
		boolean isUpdated = false;

		try {

			connection = DBUtil.getConnection();

			// System.out.println("Creating a statement...");
			String query = "update expense set   expenseType=?,userId=?,date=?,price=?,noOfItems=?,totalAmount=?,byWhom=?  where id=?";
			pstatement = connection.prepareStatement(query);

			pstatement.setString(1, expense.getExpenseType());
			pstatement.setString(2, expense.getUserId());
			pstatement.setString(3, expense.getDate());
			pstatement.setInt(4, expense.getPrice());
			pstatement.setInt(5, expense.getNoOfItems());
			pstatement.setInt(6, expense.getTotalAmount());
			pstatement.setString(7, expense.getByWhom());
			pstatement.setInt(8, expense.getId());

			// STEP 4: Execute statement

			int i = pstatement.executeUpdate();

			isUpdated = i > 0;

		} catch (SQLException e) {
			log.error("SQLexpection:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("isUpdated:" + isUpdated);
		return isUpdated;
	}

	@Override
	public boolean deleteExpense(int id) {
		boolean isDeleated = false;
		Connection connection = null;
		PreparedStatement pstatement = null;
		log.info("int:" + id);

		try {

			connection = DBUtil.getConnection();
			// System.out.println("Connecting to a selected database...");

			// STEP 3: Creating a statement
			// System.out.println("Creating a statement...");
			String query = "delete from expense where id=?";
			pstatement = connection.prepareStatement(query);

			pstatement.setInt(1, id);

			// STEP 4: Execute statement

			int i = pstatement.executeUpdate();
			isDeleated = i > 0;
			log.info("ExpenseStatues" + isDeleated);

		} catch (SQLException e) {

			log.error("SQLException" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("isDeleated:" + isDeleated);
		return isDeleated;

	}

	@Override

	public List<Expense> getExpenses(int userId) {
		Connection connection = null;
		PreparedStatement pstatement = null;
		log.info("int:" + userId);
		List<Expense> expenses = new ArrayList<>(1);
		try {

			connection = DBUtil.getConnection(); //
			// System.out.println("Connecting to a selected database...");

			// STEP 3: Creating a statement //
			// System.out.println("Creating a statement...");
			String query = "select * from expense  where userId=?";
			pstatement = connection.prepareStatement(query);
			pstatement.setInt(1, userId);
			// STEP 4:Execute statement
			ResultSet resultSet = pstatement.executeQuery();
			Expense expense = null;
			while (resultSet.next()) {
				expense = new Expense();
				expense.setExpenseType(resultSet.getString("expenseType"));
				expense.setByWhom(resultSet.getString("byWhom"));
				expense.setDate(resultSet.getString("date"));
				expense.setTotalAmount(resultSet.getInt("totalAmount"));
				// expense.setId(resultSet.getInt("id"));
				expense.setPrice(resultSet.getInt("price"));
				expense.setNoOfItems(resultSet.getInt("noOfItems"));
				// System.out.println("success");
				// System.out.println("success");
				expenses.add(expense);
			}

		}

		catch (SQLException e) {
			log.error("SQLException" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);

		}
		log.info("expenses:" + expenses);
		return expenses;

	}

	@Override
	public List<Expense> getExpenseReport(String type, String fromDate, String toDate) {
		Connection connection = null;
		PreparedStatement pstatement = null;
		log.info("String:" + type + "String:" + fromDate + "String:" + toDate);
		List<Expense> expenses = new ArrayList<>(1);
		try {

			connection = DBUtil.getConnection();
			// System.out.println("Connecting to a selected database...");

			// STEP 3: Creating a statement
			// System.out.println("Creating a statement...");
			String query = "select * from expense  where expenseType=? and date between ? and ? ";
			pstatement = connection.prepareStatement(query);
			pstatement.setString(1, type);
			pstatement.setString(2, fromDate);
			pstatement.setString(3, fromDate);

			ResultSet resultSet = pstatement.executeQuery();
			Expense expense = null;
			while (resultSet.next()) {

				expense = new Expense();
				expense.setExpenseType(resultSet.getString("expenseType"));
				expense.setByWhom(resultSet.getString("byWhom"));
				expense.setDate(resultSet.getString("date"));
				expense.setTotalAmount(resultSet.getInt("totalAmount"));
				expense.setId(resultSet.getInt("id"));
				expense.setPrice(resultSet.getInt("price"));
				expense.setNoOfItems(resultSet.getInt("noOfItems"));
				System.out.println("success");

				expenses.add(expense);
			}

		} catch (SQLException e) {
			log.error("SQLException" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);

		}
		log.info("expenses:" + expenses);
		return expenses;
	}

	@Override
	public boolean resetPassword(String username, String currentPassword, String newPassword) {
		boolean isReset = false;
		Connection connection = null;
		PreparedStatement pstatement = null;
		log.info("int:" + username + "String:" + currentPassword + "String:" + newPassword);

		try {

			connection = DBUtil.getConnection();
			// System.out.println("Connecting to a selected database...");

			// STEP 3: Creating a statement
			// System.out.println("Creating a statement...");
			String query = "update user set password=? where username=? and password=?";
			// String query = "update user set password='"
			// +user.getPassword()+"' where
			// password='234'";
			pstatement = connection.prepareStatement(query);
			pstatement.setString(1, newPassword);
			pstatement.setString(2, username);
			pstatement.setString(3, currentPassword);
			// STEP 4: Execute statement
			int i = pstatement.executeUpdate();
			isReset = i > 0;
		} catch (SQLException e) {
			log.error("SQLException" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("isReset:" + isReset);
		return isReset;

	}

	@Override
	public Expense getExpense(int id) {
		// Expense expenses=null;
		Connection connection = null;
		PreparedStatement pstatement = null;
		log.info("int:" + id);
		Expense expense = null;
		try {

			connection = DBUtil.getConnection();
			// System.out.println("Connecting to a selected database...");

			// STEP 3: Creating a statement
			// System.out.println("Creating a statement...");
			String query = "select * from expense  where id=?";
			pstatement = connection.prepareStatement(query);
			pstatement.setInt(1, id);
			// STEP 4:Execute statement
			ResultSet resultSet = pstatement.executeQuery();

			while (resultSet.next()) {
				expense = new Expense();
				expense.setExpenseType(resultSet.getString("expenseType"));
				expense.setByWhom(resultSet.getString("byWhom"));
				expense.setDate(resultSet.getString("date"));
				expense.setTotalAmount(resultSet.getInt("totalAmount"));
				expense.setId(resultSet.getInt("id"));
				expense.setPrice(resultSet.getInt("price"));
				expense.setNoOfItems(resultSet.getInt("noOfItems"));
				System.out.println("success");

				// expense=(resultSet.next())>0;
			}

		}

		catch (SQLException e) {
			log.error("SQLException" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);

		}
		log.info("expense:" + expense);
		return expense;
	}

	/*
	 * @Override public boolean updatePersonalInfo(User user, Address address) {
	 * // TODO Auto-generated method stub return false;
	 */

	@Override
	public PersonalInfo getPersonalInfo(int userId) {

		Connection connection = null;
		PreparedStatement pstatement = null;
		log.info("int:" + userId);
		PersonalInfo personalInfo = null;

		try {

			connection = DBUtil.getConnection();
			// System.out.println("Connecting to a selected database...");

			// STEP 3: Creating a statement
			// System.out.println("Creating a statement...");
			String query = "select u.*, a.* from user u left join address a on u.id=a.userId  where u.id='" + userId
					+ "'";
			pstatement = connection.prepareStatement(query);
			pstatement.setInt(1, userId);
			// pstatement.setString(2,"1/06/18");
			// pstatement.setString(3,"hari");

			// STEP 4: Execute statement
			ResultSet resultSet = pstatement.executeQuery();
			// PersonalInfo personal=null;
			while (resultSet.next()) {
				personalInfo = new PersonalInfo();
				User user = new User();
				// System.out.println("Id : " + resultSet.getInt("id"));
				user.setId(resultSet.getInt(1));
				user.setFirstName(resultSet.getString("firstName"));
				user.setMiddleName(resultSet.getString("middleName"));
				user.setLastName(resultSet.getString("lastName"));
				user.setUserName(resultSet.getString("userName"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setMobileNumber(resultSet.getString("mobileNumber"));

				Address address = new Address();
				address.setUserId(resultSet.getInt(9));
				address.setAddressLine1(resultSet.getString("addressLine1"));
				address.setAddressLine2(resultSet.getString("addressLine2"));
				address.setCity(resultSet.getString("city"));
				address.setState(resultSet.getString("state"));
				address.setZip(resultSet.getString("zip"));
				address.setCountry(resultSet.getString("country"));
				personalInfo.setAddress(address);
				personalInfo.setUser(user);
				System.out.println("success");

				personalInfo.setUser(user);
				personalInfo.setAddress(address);
				return personalInfo;

			}

		} catch (SQLException e) {
			log.error("SQLException" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);

		}
		log.info("personalInfo:" + personalInfo);
		return null;
	}

	@Override
	public boolean updatePersonalInfo(User user, Address address) {
		Connection connection = null;
		PreparedStatement prst = null;
		log.info("user:" + address);
		boolean isUpdated = false;
		try {
			connection = DBUtil.getConnection();
			connection.setAutoCommit(false);
			String query = "Update user set FirstName=?,MiddleName=?,LastName=?,email=?,UserName=?,Password=?,mobileNumber=? where id=?";
			prst = connection.prepareStatement(query);
			prst.setString(1, user.getFirstName());
			prst.setString(2, user.getMiddleName());
			prst.setString(3, user.getLastName());
			prst.setString(4, user.getEmail());
			prst.setString(5, user.getUserName());
			prst.setString(6, user.getPassword());
			prst.setString(7, user.getMobileNumber());
			prst.setInt(8, user.getId());
			int updatePersonal = prst.executeUpdate();
			if (updatePersonal > 0) {
				int noOfAddOrEditAddress = 0;
				if (address.getUserId() != 0) {
					String query1 = "update address set Addressline1=?,Addressline2=?,City=?,State=?,Zip=?,Country=? where userId=?";
					prst = connection.prepareStatement(query1);
					prst.setString(1, address.getAddressLine1());
					prst.setString(2, address.getAddressLine2());
					prst.setString(3, address.getCity());
					prst.setString(4, address.getState());
					prst.setString(5, address.getZip());
					prst.setString(6, address.getCountry());
					prst.setInt(7, address.getUserId());
				} else {
					String query2 = "insert into address(Addressline1,Addressline2,City,State,Zip,Country,UserId,id) values(?,?,?,?,?,?,?,?)";
					prst = connection.prepareStatement(query2);
					prst.setString(1, address.getAddressLine1());
					prst.setString(2, address.getAddressLine2());
					prst.setString(3, address.getCity());
					prst.setString(4, address.getState());
					prst.setString(5, address.getZip());
					prst.setString(6, address.getCountry());
					prst.setInt(7, address.getUserId());
					prst.setInt(8, user.getId());
				}
				noOfAddOrEditAddress = prst.executeUpdate();
				System.out.println("updated item=" + noOfAddOrEditAddress);
				if (noOfAddOrEditAddress > 0) {
					isUpdated = true;
				}

			}
			if (isUpdated) {
				connection.commit();
			} else {
				connection.rollback();
			}

		} catch (SQLException e) {
			log.error("SQLException" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}
		log.info("isUpdated:" + isUpdated);
		return isUpdated;

	}

	@Override
	public List<Expense> getdeletedrop() {
		Connection connection = null;
		PreparedStatement pstatement = null;
		List<Expense> expenses = new ArrayList<>();
		try {

			connection = DBUtil.getConnection(); //
			// System.out.println("Connecting to a selected database...");

			// STEP 3: Creating a statement //
			// System.out.println("Creating a statement...");
			String query = "select * from expense";
			pstatement = connection.prepareStatement(query);
			// pstatement.setInt(1, userId);
			// STEP 4:Execute statement
			ResultSet resultSet = pstatement.executeQuery();
			Expense e = null;
			while (resultSet.next()) {
				e = new Expense();
				e.setId(resultSet.getInt("id"));
				e.setExpenseType(resultSet.getString("expenseType"));
				e.setByWhom(resultSet.getString("byWhom"));
				e.setDate(resultSet.getString("date"));
				e.setTotalAmount(resultSet.getInt("totalAmount"));
				// expense.setId(resultSet.getInt("id"));
				e.setPrice(resultSet.getInt("price"));
				e.setNoOfItems(resultSet.getInt("noOfItems"));
				expenses.add(e);
			}

		}

		catch (SQLException e) {
			log.error("SQLException" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);

		}
		log.info("expenses:" + expenses);
		return expenses;

	}

	@Override
	public List<Expense> geteditDrop() {
		Connection connection = null;
		PreparedStatement pstatement = null;

		List<Expense> expenses = new ArrayList<>();
		try {

			connection = DBUtil.getConnection();
			String query = "select * from expense order by id desc";
			pstatement = connection.prepareStatement(query);
			ResultSet resultSet = pstatement.executeQuery();
			Expense e = null;
			while (resultSet.next()) {
				e = new Expense();
				e.setId(resultSet.getInt("id"));
				e.setExpenseType(resultSet.getString("expenseType"));
				e.setByWhom(resultSet.getString("byWhom"));
				e.setDate(resultSet.getString("date"));
				e.setTotalAmount(resultSet.getInt("totalAmount"));
				// expense.setId(resultSet.getInt("id"));
				e.setPrice(resultSet.getInt("price"));
				e.setNoOfItems(resultSet.getInt("noOfItems"));
				// System.out.println("success");
				// System.out.println("success");
				expenses.add(e);
			}

		}

		catch (SQLException e) {
			log.error("SQLException" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
			{

				return expenses;
			}

		}
	}

	@Override
	public PersonalInfo getPersonalInfo(String username) {
		PersonalInfo persanlInfo = new PersonalInfo();
		Connection connection = (Connection) DBUtil.getConnection();
		PreparedStatement preparesatement;
		try {
			preparesatement = connection.prepareStatement(
					"select u.*, a.* from user u left join address a on u.id=a.userId where u.username='" + username
							+ "'");
			ResultSet resultset = (ResultSet) preparesatement.executeQuery();
			while (resultset.next()) {
				User user = new User();
				user.setId(resultset.getInt(1));
				user.setFirstName(resultset.getString("firstName"));
				user.setMiddleName(resultset.getString("middleName"));
				user.setLastName(resultset.getString("lastName"));
				user.setUserName(resultset.getString("userName"));
				user.setEmail(resultset.getString("email"));
				user.setPassword(resultset.getString("password"));
				user.setMobileNumber(resultset.getString("mobileNumber"));

				Address address = new Address();
				address.setUserId(resultset.getInt(9));
				address.setAddressLine1(resultset.getString("addressLine1"));
				address.setAddressLine2(resultset.getString("addressLine2"));
				address.setCity(resultset.getString("city"));
				address.setState(resultset.getString("state"));
				address.setZip(resultset.getString("zip"));
				address.setCountry(resultset.getString("country"));
				address.setUserId(resultset.getInt("userId"));
				persanlInfo.setAddress(address);
				persanlInfo.setUser(user);
				// address.setUserId(resultset.getString(15));

				persanlInfo.setUser(user);
				persanlInfo.setAddress(address);
				if (username.equals(user.getUserName())) {
					return persanlInfo;
				}

				System.out.println(persanlInfo.getUser().getFirstName());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			DBUtil.closeConnection(connection);

		}

		return persanlInfo;
	}

	@Override
	public boolean isUsernameAvailable(String username) {
		boolean isUsernameAvailable = true;
		Connection connection = null;
		PreparedStatement pstatement = null;
		// log.info("username:" + password);

		try {
			connection = DBUtil.getConnection();
			String query = "select * from user where userName=? ";
			pstatement = connection.prepareStatement(query);

			pstatement.setString(1, username);

			// STEP 4: Execute statement

			ResultSet resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				isUsernameAvailable = false;
				break;
			}
		} catch (SQLException e) {
			// log.error("SQLexpection:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);

		}
		// log.info("isUsernameAvailable:" + isUsernameAvailable);
		return isUsernameAvailable;
	}

	@Override
	public boolean isMobileNumberAvailable(String mobileNo) {
		boolean isMobileNumberAvailable = true;
		Connection connection = null;

		PreparedStatement statement = null;

		try {
			connection = DBUtil.getConnection();

			String sql = "SELECT * FROM user WHERE mobileNo=?";

			statement = connection.prepareStatement(sql);
			statement.setString(1, mobileNo);

			ResultSet set = statement.executeQuery();

			while (set.next()) {
				isMobileNumberAvailable = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return isMobileNumberAvailable;

	}

}
