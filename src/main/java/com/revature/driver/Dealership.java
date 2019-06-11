package com.revature.driver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.revature.project.Car;
import com.revature.project.CarLot;
import com.revature.project.Customer;
import com.revature.project.Employee;
import com.revature.project.serialize.FileSerializeDAO;

public class Dealership implements Serializable{

	private static  FileSerializeDAO fdao = new FileSerializeDAO();

	private static Car car = new Car();
	private static CarLot cl = new CarLot();
	private static CarDriver cd = new CarDriver();
	private static Customer c = new Customer();
	private static Dealership d;// = new Customer();
	private static Employee e;


//	private ArrayList<Car> cars2 ;//= new ArrayList<Car>(cl.cars);
//	private ArrayList<Car> offersMade2;// = new ArrayList<Car>(cl.offersMade);
//	private ArrayList<Car> carsOwned22 = new ArrayList<Car>(cl.carsOwned2);
//	private Map <String, String> customers22 = new HashMap<String, String>(cd.customers2);
//	private Map<String, ArrayList<Car>> caps2 = new HashMap<String, ArrayList<Car>>(cd.caps);


	public static void startHere() {
//		/* ArrayList<Car> */ cl.cars = new ArrayList<Car>(e.cars2);
//		ArrayList<Car> offersMade = new ArrayList<Car>(e.offersMade2);
//		ArrayList<Car> carsOwned2 = new ArrayList<Car>(e.carsOwned22);
//		Map <String, String> customers2 = new HashMap<String, String>(e.customers22);
//		Map<String, ArrayList<Car>> caps = new HashMap<String, ArrayList<Car>>(e.caps2);
		CarLot.initCarLot();
		CarDriver.startDriver();
	}






	//		car = fdao.loadCar();
	//		cl = fdao.loadCarLot();
	//		cd = fdao.loadCarDriver();
	//		c = fdao.loadCustomer();
	//		cars3= fdao.loadCarArrayList();
	//		CarDriver.startDriver();


}
