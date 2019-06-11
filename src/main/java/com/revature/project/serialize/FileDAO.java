package com.revature.project.serialize;

import java.util.ArrayList;

import com.revature.driver.CarDriver;
import com.revature.driver.Dealership;
import com.revature.project.Car;
import com.revature.project.CarLot;
import com.revature.project.Customer;

public interface FileDAO {


	public void saveDealership(Dealership d);
	
	public Dealership loadDealership();
	
	
	
//		public void saveCar(Car car);
//		
//		public Car loadCar();
//		
//		public void saveCarLot(CarLot carLot);
//		
//		public CarLot loadCarLot();
//		
//		public void saveCarDriver(CarDriver carDriver);
//		
//		public CarDriver loadCarDriver();
//		
//		public void saveCustomer(Customer customer);
//		
//		public Customer loadCustomer();
//
//		void saveCarArrayList(ArrayList<Car> cars);
//
//		ArrayList loadCarArrayList();


}
