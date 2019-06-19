package com.revature.dao;

import java.util.ArrayList;

import com.revature.project.Car;

public interface CarDao {
	
	public void createCar(Car c);
	
	public void updateCar(Car c);
	
	public void deleteCar(Car c);
	
	public Car getCarById(Integer id);
	
	public Car getCarByUsername(String username);
	
	public ArrayList<Car> getAllCars();
	
	public ArrayList<Car> getAllOffers();

	void preparedUpdateCar(Car c);
	
}
