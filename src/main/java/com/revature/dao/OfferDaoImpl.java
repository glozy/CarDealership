package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.project.Offer;
import com.revature.util.ConnectionFactory;

public class OfferDaoImpl implements OfferDao {

	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public void insertOffer(Offer o) {
		String sql = "insert into offer_dealership(customerid, carid, offerprice, statusid)" + "values(?,?,?,?);";
		String sql2 = "update car_dealership set car_offer = true where carid = ?";
		PreparedStatement pstmt, pstmt2;
		//int newId = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, o.getCustomerid());
			pstmt.setInt(2, o.getCarid());
			pstmt.setDouble(3, o.getOffer_price());
			pstmt.setInt(4, o.getStatus_id());
			pstmt.executeUpdate();
			
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, o.getCarid());
			pstmt2.executeUpdate();

		} catch (SQLException e) {
			// LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}

//		try {
//			conn.setAutoCommit(false);
//			PreparedStatement pstmt = conn.prepareStatement("update car_dealership set available = false where carid = ?");
//			//pstmt.setString(1, c.getPrice());
//			pstmt.setInt(1, c.getId());
//			pstmt.executeUpdate();
////			
////			if (numberOfRows > 1) {
////				conn.rollback(sp);
////				System.out.println("Too many rows affected");
////			}
//			
//			conn.commit();
//			conn.setAutoCommit(true);
//		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}
		
	}

	@Override
	public ArrayList<Offer> getOffersbyCarID(Integer id) {
		ArrayList<Offer> offers = new ArrayList<Offer>();
		String sql = "select * from offer_dealership where carid = " + id;
		Statement stmt;

		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
//				carList.add(new Car(, , rs.getDouble("car_price"),
//						rs.getBoolean("for_sale"), rs.getBoolean("offer_flag")));
				
				offers.add(new Offer(rs.getInt(1), rs.getInt("customerid"), rs.getInt("carid"), 
						rs.getDouble("offerprice"), rs.getInt("statusid")));
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return offers;
	}

	@Override
	public int getCustomerIDbyofferID(Integer offerChosen) {
		String sql = "select * from offer_dealership where offerid = " + offerChosen;
		Offer ret = null;
		Statement stmt;

		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				
				ret = new Offer(rs.getInt("offerid"), rs.getInt("customerid"),
						rs.getInt("carid"), rs.getDouble("offerprice"), rs.getInt("statusid"));

			//	offers.add(new Offer(rs.getInt(1), rs.getInt("customerid"), rs.getInt("carid"), 
			//			rs.getInt("status_id"), rs.getDouble("offer_price")));
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret.getCustomerid();
	
	}

}
