package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.logging.LoggingUtil;
import com.revature.project.Customer;
import com.revature.util.ConnectionFactory;

public class CustomerDaoImpl implements CustomerDao {

	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public void createCustomer(Customer c) {
		try {
			conn.setAutoCommit(false);
			String query = "insert into customer_dealership(username,password) values (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.get);
			pstmt.setString(2, c.get2);
			Savepoint sp = conn.setSavepoint("Before Create");
			boolean check = pstmt.execute();
			System.out.println(check);
			if (check) {
				conn.rollback(sp);
				LoggingUtil.error("Customer was not added. Rolling back");
			}
			conn.commit();
			conn.setAutoCommit(true);
			LoggingUtil.info("Creating a customer");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomer(Customer c) {
		try {

			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);  //needs to be done to run transactions
			Savepoint sp = conn.setSavepoint("Before Update");
			String query = "update user_table set password = '" ;//+ c.getPassword() + "' where username = '" + c.getFirstName() + "'";
			int numberOfRows = stmt.executeUpdate(query);

			if (numberOfRows > 1) {
				conn.rollback(sp);
				System.out.println("Too many rows affected");
			}

			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCustomer(Customer c) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> custList = new ArrayList<Customer>();

		String sql = "select * from customer_dealership";

		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				custList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3)));//, rs.getString(4)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return custList;
	}

	@Override
	public void preparedUpdateCustomer(Customer c) {
		// TODO Auto-generated method stub

	}

}
