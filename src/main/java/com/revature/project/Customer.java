package com.revature.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.revature.dao.CarDaoImpl;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.OfferDao;
import com.revature.dao.OfferDao1;
import com.revature.dao.OfferDaoImpl;
import com.revature.dao.OfferDaoImpl1;
import com.revature.driver.CarDriver;
import com.revature.driver.Dealership;
import com.revature.logging.LoggingUtil;
import com.revature.project.serialize.FileSerializeDAO;


public class Customer implements Serializable{//User,


	public static CarDriver cd = new CarDriver(); 
	public static Employee e = new Employee();
	public static Customer c = new Customer();
	public static Car car;
	private String name, password;
	private int id;
	private static int count = 1;
	public static CarLot cl;// = new CarLot();
	private static FileSerializeDAO fdao = new FileSerializeDAO();
	public static double offeringPrice;
	public static Scanner sc = new Scanner(System.in);
	public String get,get2;
	private static Dealership d;
	private static OfferDao newOffer = new OfferDaoImpl();
	private static OfferDao1 newOffer1 = new OfferDaoImpl1();
	private static CarDaoImpl newCar = new CarDaoImpl();
	private static CustomerDaoImpl newCust = new CustomerDaoImpl();
	
	
	public Customer() {
		super();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer(String name) {
		this.name = name;
		id = count++;
	}


	public Customer(int id, String name, String password) {
		this.id =id;
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + " " + password +"]";
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public static void makeOffer(ArrayList<Car> cars) {
		int carNumber;
		//ArrayList<Car> carList = newCar.getAllCars();
		//System.out.println(newCar.carList);
		System.out.println("Please select # of the car you like");

		do {
			System.out.print("Select car #: ");
			while(!sc.hasNextInt()) {
				System.out.println("Thats not a valid input");
				sc.next();
			}
			carNumber = sc.nextInt();
		} while (carNumber < 1 || carNumber > newCar.carList.size());
		
		//if (CarLot.offersMade.contains(cars.get(carNumber-1))) {
		//	System.out.println("\nOffer for this car has already been made");			
		//} else {
			//newOffer.createOffer(new Car(c.getId(),car.getId(),car.getOfferPrice()));
			//CarLot.offersMade.add(cars.get(carNumber-1));
			//CarDriver.caps.put(c.get, new ArrayList<Car>());
			//CarDriver.caps.get(c.get).add((cars.get(carNumber-1)));
			
			System.out.println("Please enter your price");
			offeringPrice = sc.nextInt();
			//car.setOfferPrice(  offeringPrice);
			System.out.println("--------------");
			System.out.println("Car offer made");
			System.out.println("--------------");
			//System.out.println(newCust.custList.get(2).getId());
			//System.out.println(newCust.getCustomerById(newCust.custList.get(2).getId()));
			//System.out.println(newCust.getCustomerById(c.getId()));
			Integer pending = 1;
			//newOffer.createOffer(new Car(newCust.custList.get(2).getId(),newCar.carList.get(carNumber-1).getId(),c.offeringPrice));
			//Offer o = new Offer(newCust.custList.get(2).getId(), newCar.carList.get(carNumber-1).getId(), c.offeringPrice, pending );
			newOffer1.insertOffer(new Offer(newCust.custList.get(2).getId(), newCar.carList.get(carNumber-1).getId(), c.offeringPrice, pending ));
			//Car offerCar = newCar.getCarById(newCar.carList.get(carNumber-1).getId());
			//offerCar.setOfferFlag(true);
			
			
		}
	//}

	public static void viewCars2(ArrayList<Car> cars) {
		int i = 1;
		for (Car car : cars) {
			System.out.println("# " + "| " + "VIN " + "| " + "Make " + "| " + "Model " + "| " + "Color " + "| " + "Year " + "| " + "Mileage " + "| " + "Price " + "| " + "Offer ");
			System.out.println(i++ + " " + car.getVIN() + " " +  car.getMake() + " " + car.getModel() + " " + car.getColor()
			+ " " + car.getYear() + " " + car.getMileage() + " " + "$" + car.getPrice());
			System.out.println();
		}
	}

	public static void viewCarsOwned() {
		for (Map.Entry<String, ArrayList<Car>> entry : CarDriver.carsOwned.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}

	public static void viewOffersMade() {
		int i = 1;
		for (Car car : CarLot.offersMade) {
			System.out.println("# " + "| " + "VIN  " + "| " + "Make  " + "| " + "Model " + "| " + "Color " + "| " + "Year " + "| " + "Mileage " + "| " + "Price " + "| " + "Offer ");
			System.out.println(i++ + "  " + car.getVIN() + "  " +  car.getMake() + "    " + car.getModel() + "   " + car.getColor()
			+ "   " + car.getYear() + "   " + car.getMileage() + "     " + car.getPrice() + "   " + offeringPrice);//offeringPrice );//+ cd.customers2.get(car));
			System.out.println();
		}
		OfferDaoImpl om = new OfferDaoImpl();
        for (Car ca: om.getAllOffers()) {
        	System.out.println(ca);
        }
	}

	public static void viewCarsOwned2() {
		int i = 1;
		for (Car car : CarLot.carsOwned2) {
			System.out.println("# " + "| " + "VIN  " + "| " + "Make  " + "| " + "Model " + "| " + "Color " + "| " + "Year " + "| " + "Mileage " + "| " + "Price ");
			System.out.println(i++ + "  " + car.getVIN() + "  " +  car.getMake() + "    " + car.getModel() + "   " + car.getColor()
			+ "   " + car.getYear() + "   " + car.getMileage() + "     " + car.getPrice());
			System.out.println();
		}
	}

	public static boolean welcomeDisplay() {
		System.out.println("\nWhat would you like to do?");
		System.out.println("--------------------------------");
		System.out.println("1. Login to an existing account.");
		System.out.println("2. Create a new account.");
		System.out.println("--------------------------------");
		customerLoginPage();
		return true;
	}	

	public static void customerLoginPage() {
		int loginOption = 0;
		//int loginOption;
		do {
			System.out.println("\nPlease select (1) or (2)");
			while(!sc.hasNextInt()) {
				System.out.println("Thats not a valid input");
				sc.next();
			}
			loginOption = sc.nextInt();
		} while (loginOption < 1 || loginOption > 2);
		
		//doLoginOption(loginOption);
		//loginOption = sc.nextInt();
		//while(loginOption <1 || loginOption >2)
		//{
//			System.out.println("Please enter a correct option.");
//			loginOption = sc.nextInt();
		//}
		switch (loginOption) {
		case 1:
			System.out.println("Login to an existing account");
			loginAccount();
			break;
		case 2:
			System.out.println("Create a new account.");
			createAccount(null);
			break;
		}
	}

	public static void loginAccount() {
		System.out.println("Enter username: ");
		c.get = sc.next();
		CustomerDao newCust = new CustomerDaoImpl();
		ArrayList<Customer> custList = newCust.getAllCustomer();
		System.out.println(custList);
		if (custList.contains(c.get)) {
			System.out.println("forever youg");
		}
		//System.out.println(custList.get(0).getName());
		for (int i = 0; i < custList.size(); i++) {
			if (custList.get(i).name.equals(c.get) ) {
				System.out.println("Account Found");
				System.out.println("Enter password: ");
				c.get2 = sc.next();
				if (custList.get(i).password.equals(c.get2) ) {
					System.out.println("\n" + "Welcome Back " + c.get);
					displayMenu();
				} else {
					System.out.println("Wrong password");
					loginAccount();
				}
		}
		} 
		
//		for(Customer no : custList) {
//			    if(no.equals(c.get)) {
//			    	System.out.println("hello");
//			    }
//		
//		}
//		if (cd.customers2.containsKey(c.get)) {;
//		System.out.println("Account Found");
//		System.out.println("Enter password: ");
//		c.get2 = sc.next();
//		if (cd.customers2.containsKey(c.get) && cd.customers2.containsValue(c.get2)) {
//			System.out.println("\n" + "Welcome Back " + c.get);
//			displayMenu();
//		} else {
//			System.out.println("Wrong password");
//			loginAccount();
//		}
//		} else {
//			System.out.println("No Accounts found! \n" + "Add an Account first");
//			welcomeDisplay();
//		}
	}


	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((get == null) ? 0 : get.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (get == null) {
			if (other.get != null)
				return false;
		} else if (!get.equals(other.get))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static void createAccount(Map <String, Customer> customers2) {
		System.out.println("Enter username: ");
		c.get = sc.next();
		if (cd.customers2.containsKey(c.get)) {
			System.out.println("Username already exists\nTry again");
			createAccount(customers2);
		} else {
			System.out.println("Enter password: ");
			c.get2 = sc.next();
			cd.customers2.put(c.get, c.get2);
			//ArrayList<Customer> cust = new ArrayList<>();
			//c.cust.add(new Customer(get));
			//cd.customers2.put((get), c.cust.get(1));
			cd.cust.add(new Customer(c.get2));
			CarDriver.caps.put(c.get, new ArrayList<Car>());
			//				cd.caps.get(c.get).add(new Customer(c.get2));
			//System.out.println(cd.caps);
			System.out.println("New account created successfully\n");
			System.out.println("Welcome! " + c.get);
			CustomerDao newCust = new CustomerDaoImpl();
			newCust.createCustomer(c);
			//CarDriver.startDriver();
			displayMenu();
		}		
	}

	public static void displayMenu() {
		System.out.println("What would you like to do?");
		System.out.println("--------------------------------------------------------");
		System.out.println("1. Show all existing cars in the car lot.");
		System.out.println("2. Make an offer.");
		System.out.println("3. Show cars owned.");
		System.out.println("4. View offers made.");
		System.out.println("5. View remaining payments.");
		System.out.println("6. Exit program.\n");

		int menuOption = 0;
		do {
			
			System.out.println("\n\nWhat would you like to do? (0 for main menu, 9 for login page)");
			menuOption = sc.nextInt();
			while(menuOption <0 || menuOption >6 && menuOption != 9 )
			{
				System.out.println("Please enter a correct menu option.(0 to see the menu, 9 for login page)");
				menuOption = sc.nextInt();
			}
			doMenuOption(menuOption,cl.cars);

		} while(menuOption != 6);
	}

	public static void doMenuOption(int action, ArrayList<Car> cars)  {
		switch (action) {
		case 0:
			System.out.println("Main Menu");
			displayMenu();
			break;
		case 1:
			System.out.println("List of Cars in the car lot");
			System.out.println("----------------------------------------------------------");
			//CarLot.viewCars(cars);
			cl.viewCars(cars);
			break;
		case 2:
			System.out.println("Make an offer.");
			//CarLot.viewCars(cars);
			cl.viewCars(cars);
			makeOffer(cars);
			break;
		case 3:
			System.out.println("Show cars owned.");
			cd.getCarsOwned();
			viewCarsOwned2();
			break;
		case 4:
			System.out.println("View offers made.");
			viewOffersMade();
			break;
		case 5:
			System.out.println("View remaining payments.");
			CarDriver.remainMonthlyPay();
			break;
		case 9:
			CarDriver.startDriver();
			break;
		case 6:
			System.out.println("Thanks for stopping by!\nCome back soon!");
//			fdao.saveCar(car);
//			fdao.saveCarLot(cl);
//			fdao.saveCarDriver(cd);
//			fdao.saveCustomer(c);
			LoggingUtil.trace("Program ended successfully.");
			fdao.saveDealership(d);
			System.exit(0);
		}
	}
}