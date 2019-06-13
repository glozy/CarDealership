package com.revature.driver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.revature.logging.LoggingUtil;
import com.revature.project.Car;
import com.revature.project.CarLot;
import com.revature.project.Customer;
import com.revature.project.Employee;
import com.revature.project.serialize.FileSerializeDAO;

public class CarDriver implements Serializable{

	private static Scanner sc = new Scanner(System.in);
	public   Map <String, String> customers2 = new HashMap<String, String>();
	public  static Map<String, ArrayList<Car>> carsOwned;// = new HashMap<>();
	private static  FileSerializeDAO fdao = new FileSerializeDAO();
	public ArrayList<Customer> cust = new ArrayList<Customer>();
	public static Map<String, ArrayList<Car>> caps;// = new HashMap<>();
	private static CarLot cl;
	
	
	public Map<String, ArrayList<Car>> getCaps() {
		System.out.println(caps);
		return caps;
	}

	public static void calcMonthlyPay() {
		double payment;
		for (Car car : cl.cars) {
			payment = car.getPrice() / 12;
			payment = Math.round(payment*100);
			payment /=100;
			System.out.println(payment);
		}
	}

	public static void  remainMonthlyPay() {
		double payment = 0;
		for (Car car : CarLot.carsOwned2) {
			payment = (car.getPrice() - Customer.offeringPrice) / 12;
			payment = Math.round(payment*100);
			payment /=100;
			System.out.println("\n" + car.getYear() + " " + car.getMake() + " " + car.getModel());
			System.out.println("Remaining payment: $" + (car.getPrice() - Customer.offeringPrice));
			System.out.println("Monthly payment: $" + payment + " for 12 months");
		}
	}


	public void getCarsOwned() {
		for (ArrayList<Car> url : carsOwned.values()) {
			System.out.println(url);
		}
	}


	public Map<String, String> getCustomers2() {
		System.out.println(customers2);
		return customers2;
	}

	public CarDriver() {
		super();
		carsOwned = new HashMap<String, ArrayList<Car>>();
		caps = new HashMap<String, ArrayList<Car>>();
	}

	public static void viewCars(ArrayList<Car> cars) {
		int i = 1;
		for (Car car : cars) {
			System.out.println("# " + "| " + "VIN " + "| " + "Make " + "| " + "Model " + "| " + "Color " + "| " + "Year " + "| " + "Mileage " + "| " + "Price " + "| " + "Offer ");
			System.out.println(i++ + " " + car.getVIN() + " " +  car.getMake() + " " + car.getModel() + " " + car.getColor()
			+ " " + car.getYear() + " " + car.getMileage() + " " + car.getPrice());
			System.out.println();
		}
	}

	public static void startDriver() {

		welcomeMessage();
		int loginOption;
		do {
			System.out.println("\nPlease select (1) or (2) or (3)");
			while(!sc.hasNextInt()) {
				System.out.println("Thats not a valid input");
				sc.next();
			}
			loginOption = sc.nextInt();
		} while (loginOption < 1 || loginOption > 3);
		doLoginOption(loginOption);
	}


	public static void welcomeMessage() {
		System.out.println("\n        ***HELLO***         ");
		System.out.println("Welcome to QC's Car Dealership");
		System.out.println("--------------------------");
		System.out.println("Press 1 for Employee Login");
		System.out.println("Press 2 for Customer Login");
		System.out.println("Press 3 to exit");
		System.out.println("--------------------------");
	}

	public static void doLoginOption(int action){
		switch (action) {
		case 1:
			Employee e = new Employee();
			System.out.println("\nEmployee Login");
			do {  
				System.out.println("Enter password");
				int pass = sc.nextInt();
				e.login(pass);
			} while (!e.isPasswordFlag());
			
			break;

		case 2:
			Customer c = new Customer();
			System.out.println("Customer Login");
			Customer.welcomeDisplay();
			break;
		case 3:
			System.out.println("Thanks for stopping by!\nCome back soon!");
        	//fdao.saveDealership(d);
        	LoggingUtil.trace("Program ended successfully.");
			System.exit(0);
			break;
		}
	}
}
