package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.logging.LoggingUtil;
import com.revature.project.Car;
import com.revature.project.Customer;
import com.revature.util.ConnectionFactory;

public class CustomerDaoImpl implements CustomerDao {

	private static Connection conn = ConnectionFactory.getConnection();
	public static ArrayList<Customer> custList = new ArrayList<Customer>();
	public static CarDaoImpl cdi = new CarDaoImpl();
	
	@Override
	public void createCustomer(Customer c) {
		try {
			conn.setAutoCommit(false);
			String query = "insert into customer_dealership(username,pass_word) values (?,?)";
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
			PreparedStatement pstmt = conn.prepareStatement("update customer_dealership set password = ? where username = ?");
			pstmt.setString(1, c.get2);
			pstmt.setString(2, c.get);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCustomer(Customer c) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer getCustomerById(Integer id) {
		Customer ret = null;
		String sql = "select * from customer_dealership where customerid =" + id;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				ret = new Customer();
				ret.setId(rs.getInt(1));
				ret.setName(rs.getString("username"));
				ret.setPassword(rs.getString("pass_word"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		String sql = "select username from customer_dealership where username = '" + username + "'";
		Customer c = null;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.getString(1);
			c = new Customer(rs.getString(1));
//			while(rs.next()) {
//				custList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3)));//, rs.getString(4)));
//			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;

		//return rs.getString(1);
	}

	@Override
	public ArrayList<Customer> getAllCustomer() {
		

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

	@Override
	public ArrayList<Car> viewCars(String userName) {
			ArrayList<Car> outCars = new ArrayList<Car>();
			String sql2 = "select carid, vin, make, model, car_year, mileage, price from car_dealership where customerid in "
					+ "(select customerid from customer_dealership where username = '" + userName + "')";
			try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql2);
			while (rs.next()) {
			//=rs.getInt(1)
			//outCars.add(cdi.getCarById(rs.getInt(1)));	
			outCars.add(new Car(rs.getInt(1),rs.getString(2), rs.getString(3), 
        			rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7)));
			}
			} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return outCars;
			
	}

}
