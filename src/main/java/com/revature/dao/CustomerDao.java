package com.revature.dao;

import java.util.ArrayList;

import com.revature.project.Car;
import com.revature.project.Customer;

public interface CustomerDao {
	
	public void createCustomer(Customer c);
	
	public void updateCustomer(Customer c);
	
	public void deleteCustomer(Customer c);
	
	public Customer getCustomerById(Integer id);
	
	public Customer getCustomerByUsername(String username);
	
	public ArrayList<Customer> getAllCustomer();
	
	public ArrayList<Car> viewCars(String userName);

	void preparedUpdateCustomer(Customer c);
}
