package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.project.Car;

public interface OfferDao {
	
	
	public ArrayList<Car> getAllOffers();
	
	public void createOffer(Car c);
	
//	public void updateCar(Car c);
//	
//	public void deleteCar(Car c);
//	
//	public Car getCarById(Integer id);
//	
//	public Car getCarByUsername(String username);
//	
//	public ArrayList<Car> getAllCars();
//
//	void preparedUpdateCar(Car c);
	
}