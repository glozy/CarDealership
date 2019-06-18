package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.project.Customer;

public interface CustomerDao {
	
	public void createCustomer(Customer c);
	
	public void updateCustomer(Customer c);
	
	public void deleteCustomer(Customer c);
	
	public Customer getCustomerById(Integer id);
	
	public Customer getCustomerByUsername(String username);
	
	public ArrayList<Customer> getAllCustomer();

	void preparedUpdateCustomer(Customer c);
}
