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
import com.revature.project.Car;
import com.revature.util.ConnectionFactory;

public class CarDaoImpl implements CarDao {

	private static Connection conn = ConnectionFactory.getConnection();
    
	
	@Override
	public void createCar(Car c) {
		try {
			conn.setAutoCommit(false);
			String query = "insert into car_dealership(vin,make,model,color,caryear,mileage,price) values (?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getVIN());
			pstmt.setString(2, c.getMake());
			pstmt.setString(3, c.getModel());
			pstmt.setString(4, c.getColor());
			pstmt.setInt(5, c.getYear());
			pstmt.setInt(6, c.getMileage());
			pstmt.setDouble(7, c.getPrice());
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
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCar(Car c) {
		try {
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);  //needs to be done to run transactions
			Savepoint sp = conn.setSavepoint("Before delete");
			//String query = "delete from car_dealership where carid = ; set password = '" + u.getPassword() + "' where username = '" + u.getUsername() + "'";
			//int numberOfRows = stmt.executeUpdate(query);
			
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car getCarByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getAllCars() {
		List<Car> carList = new ArrayList<Car>();
		String sql = "select * from car_dealership";
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
            	carList.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7), 0));
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

}
