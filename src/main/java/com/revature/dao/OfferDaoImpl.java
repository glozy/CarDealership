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

public class OfferDaoImpl implements OfferDao {

	private static Connection conn = ConnectionFactory.getConnection();
	private CustomerDaoImpl cdi = new CustomerDaoImpl();
	
	@Override
	public ArrayList<Car> getAllOffers() {
		ArrayList<Car> offerList = new ArrayList<Car>();

		String sql = "select * from offer_dealership";

		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				offerList.add(new Car(rs.getInt(1), rs.getInt(2), rs.getDouble(3)));//, rs.getString(4)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return offerList;
	}

	@Override
	public void createOffer(Car c) {
		OfferDao od = new OfferDaoImpl();
		try {
			conn.setAutoCommit(false);
			String query = "insert into offer_dealership(customerid,carid,offerprice) values (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cdi.getAllCustomer().get(2).getId());
			pstmt.setInt(2, c.getId());
			pstmt.setDouble(3, c.getOfferPrice());
			Savepoint sp = conn.setSavepoint("Before offer");
			boolean check = pstmt.execute();
			if (check) {
				conn.rollback(sp);
				LoggingUtil.error("Offer was not made. Rolling back");
			}
			conn.commit();
			conn.setAutoCommit(true);
			LoggingUtil.info("Making an offer");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
