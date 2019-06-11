package com.revature.driver;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.revature.project.Customer;

public class UserManager {
	
	private String name;
	private int id = 0;
	private static int count = 1;
	
	 //Map <String, Customer> customers2 = new HashMap<>();
	
	public UserManager() {
		super();
	}

	public UserManager(String name) {
		super();
		this.name = name;
		id = count++;
	}

	@Override
	public String toString() {
		return "UserManager [name=" + name + ", id=" + id + "]";
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
//	public void addCustomer(UserManager u) {
//		customerList.add(u);
//		//return c;
//		
//	}

	public static void main(String[] args)  {
		UserManager us = new UserManager("glory");
		//us.customers2.put("H", new Customer("G"));
		//System.out.println(us.customers2);
		Customer c = new Customer();
		//c.makeOffer();

}}
