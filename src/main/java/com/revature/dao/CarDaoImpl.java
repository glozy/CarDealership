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
import com.revature.util.ConnectionFactory;

public class CarDaoImpl implements CarDao {

	private static Connection conn = ConnectionFactory.getConnection();
	//public static ArrayList<Car> carList = new ArrayList<Car>();
	
	@Override
	public void createCar(Car c) {
		try {
			conn.setAutoCommit(false);
			String query = "insert into car_dealership(vin,make,model,car_year,mileage,price) values (?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getVIN());
			pstmt.setString(2, c.getMake());
			pstmt.setString(3, c.getModel());
			pstmt.setInt(4, c.getYear());
			pstmt.setInt(5, c.getMileage());
			pstmt.setDouble(6, c.getPrice());
			Savepoint sp = conn.setSavepoint("Before creating a car");
			boolean check = pstmt.execute();
			if (check) {
				conn.rollback(sp);
				LoggingUtil.error("Car was not added. Rolling back");
			}
			conn.commit();
			conn.setAutoCommit(true);
			LoggingUtil.info("Adding a car");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void updateCar(Car c) {
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update car_dealership set price = ? where vin = ?");
			pstmt.setDouble(1, c.getPrice());
			pstmt.setString(2, c.getVIN());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCar(Car c) {
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update car_dealership set available = false where carid = ?");
			//pstmt.setString(1, c.getPrice());
			pstmt.setInt(1, c.getId());
			pstmt.executeUpdate();
//			
//			if (numberOfRows > 1) {
//				conn.rollback(sp);
//				System.out.println("Too many rows affected");
//			}
			
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
	public Car getCarById(Integer id) {
		Car ret = null;
		String sql = "select * from car_dealership where carid =" + id;
		try {
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				ret = new Car();
				ret.setId(rs.getInt(1));
				//ret.setName(rs.getString("username"));
				//ret.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Car getCarByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Car> getAllCars() {
		ArrayList<Car> carList = new ArrayList<Car>();
		String sql = "select carid,vin,make,model,car_year,mileage,price "
				+ "from car_dealership where available = 'true'";
        Statement stmt;
        try {
        	conn.setAutoCommit(false);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
            	carList.add(new Car(rs.getInt(1),rs.getString(2), rs.getString(3), 
            			rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7)));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return carList;
	}

	@Override
	public void preparedUpdateCar(Car c) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Car> getAllOffers() {
		ArrayList<Car> carOffer = new ArrayList<>();

		String sql = "select carid,vin,make,model,car_year,mileage,price"
				+ " from car_dealership where car_offer = 'true'";
		Statement stmt;

		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			//while (rs.next()) {
				while (rs.next()) {
					carOffer.add(new Car(rs.getInt(1),rs.getString(2), rs.getString(3), 
	            			rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7)));
	            }
//				carList.add(new Car(rs.getInt(1), rs.getInt("customerid"), rs.getString("car_name"), 
//						rs.getDouble("car_price"), rs.getBoolean("for_sale"), rs.getBoolean("offer_flag")));
			//}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return carOffer;
	}
}


