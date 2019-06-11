package com.revature.project;

import java.io.ObjectInputStream.GetField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.revature.driver.CarDriver;
import com.revature.driver.Dealership;
import com.revature.project.serialize.FileSerializeDAO;


public class Employee implements Serializable{//implements User{
	private boolean passwordFlag = false;
	static Scanner sc = new Scanner(System.in);
	private int count = 0;
	public static CarDriver cd = new CarDriver();  
	private static FileSerializeDAO fdao = new FileSerializeDAO();
	public static CarLot cl = new CarLot();
	public static Customer c = new Customer();
	public static Car car;
	private static Dealership d;
	private static Employee e;
	
	public ArrayList<Car> cars2 = new ArrayList<Car>(cl.cars);
	public ArrayList<Car> offersMade2 = new ArrayList<Car>(cl.offersMade);
	public ArrayList<Car> carsOwned22 = new ArrayList<Car>(cl.carsOwned2);
	public Map <String, String> customers22  = new HashMap<String, String>(cd.customers2);
	public Map<String, ArrayList<Car>> caps2 = new HashMap<String, ArrayList<Car>>(cd.caps);
	
	// ArrayList<Car> cars2 = new ArrayList<Car>(cl.cars);
//		/* ArrayList<Car> */ e.offersMade2 = new ArrayList<Car>(cl.offersMade);
//		/* ArrayList<Car> */ e.carsOwned22 = new ArrayList<Car>(cl.carsOwned2);
//		/* Map <String, String> */ e.customers22 = new HashMap<String, String>(cd.customers2);
//		/* Map<String, ArrayList<Car>> */ e.caps2 = new HashMap<String, ArrayList<Car>>(cd.caps);
	
	
	public static void addCar(ArrayList<Car> cars) {
		 	boolean validInput;
	        String VIN, make, model, color;
	        int mileage = 0, year = 0;
	        double price = 0.0;
	        
	        System.out.println("Add a new car in the following format:");
	        System.out.println("VIN MAKE MODEL COLOR YEAR MILEAGE PRICE");
	        System.out.println("EX: WC347 Honda Accord Grey 2015 9500 20000");
	        do {
	            validInput = true;
	            VIN = sc.next();
	            make = sc.next();
	            model = sc.next();
	            color = sc.next();
	            if(sc.hasNextInt()) 
	                year = sc.nextInt();
	            else validInput = false;
	            if(sc.hasNextInt())
	                mileage = sc.nextInt();
	            else validInput = false;
	            if(sc.hasNextDouble())
	                price = sc.nextDouble();
	            else validInput = false;
	            if(!validInput)
	            {
	                System.out.println("\nIncorrect Format.");
	                System.out.println("Enter a new car in the following format:");
	                System.out.println("VIN MAKE MODEL YEAR MILEAGE PRICE");
	                System.out.println("EX: 123456 Honda Accord 2015 9500 20000\n");
	            }
	        } while(validInput == false);
	        cl.cars.add(new Car(VIN,make,model,color,year,mileage,price, 0.0));
	       // cl.cars.add(new Car("AT210", "Ford", "Focus", "Silver", 2018, 21000, 7500.00));
	   
	        System.out.println("-------------------------");
	        System.out.println("New car added succesfully");
	        System.out.println("-------------------------");
	        
	}
	
	public static void removeCar(ArrayList<Car> cars) {
		int carNumber;
		if(cars.size()>0) {
			System.out.println("Please select # of the car you want to delete");
			//CarLot.viewCars(cars);
			do {
				System.out.print("Delete car #: ");
				while(!sc.hasNextInt())
				{
					System.out.println("Thats not a valid input");
					sc.next();
				}
				carNumber = sc.nextInt();

			} while (carNumber < 1 || carNumber > cars.size());
			cars.remove(carNumber-1);
			System.out.println("-----------------------");
	        System.out.println("Car removed succesfully");
	        System.out.println("-----------------------");
		} else System.out.println("There are no cars to remove.");
	}
	
	public static void viewOffersMade() {
		int i = 1;
		for (Car car : cl.offersMade) {
			System.out.println("# " + "| " + "VIN  " + "| " + "Make  " + "| " + "Model " + "| " + "Color " + "| " + "Year " + "| " + "Mileage " + "| " + "Price " + "| " + "Offer ");
            System.out.println(i++ + "  " + car.getVIN() + "  " +  car.getMake() + "    " + car.getModel() + "   " + car.getColor()
            			+ "   " + car.getYear() + "   " + car.getMileage() + "     " + car.getPrice() + "   " + c.offeringPrice );//+ cd.customers2.get(car));
			System.out.println();
		}
	}
	
	public static void viewCars2(ArrayList<Car> cars) {
		int i = 1;
        for (Car car : cars) {
        	System.out.println("# " + "| " + "VIN " + "| " + "Make " + "| " + "Model " + "| " + "Color " + "| " + "Year " + "| " + "Mileage " + "| " + "Price " + "| " + "Offer ");
            System.out.println(i++ + " " + car.getVIN() + " " +  car.getMake() + " " + car.getModel() + " " + car.getColor()
            			+ " " + car.getYear() + " " + car.getMileage() + " " + "$"+ car.getPrice());
            System.out.println();
        }
	}
	
	public static void acceptOffer(ArrayList<Car> cars) {
		int carNumber, offer;
		if(cl.offersMade.size()>0) {
			System.out.println("Please select # of the car");
			do {
				System.out.print("Select car #: ");
				while(!sc.hasNextInt()) {
					System.out.println("Thats not a valid input");
					sc.next();
				}
				carNumber = sc.nextInt();
			} while (carNumber < 1 || carNumber > cl.cars.size());				
			System.out.println("What would you like to do? (1) to accept offer, (2) to reject offer");
			offer = sc.nextInt();
			if (offer == 1) {
				cl.carsOwned2.add(cl.offersMade.get(carNumber-1));
//				cd.carsOwned.put(c.get, new ArrayList<Car>());
//				cd.carsOwned.get(c.get).add((cl.offersMade.get(carNumber-1)));
				System.out.println("--------------");
		        System.out.println("Offer accepted");
		        System.out.println("--------------");
		        cl.offersMade.remove(cl.offersMade.get(carNumber-1));
		        //cars.remove(carNumber-1);
		        //cl.offersMade.clear();
			} else if (offer == 2) {
				cl.offersMade.remove(cl.offersMade.get(carNumber-1));
				System.out.println("--------------");
		        System.out.println("Offer rejected");
		        System.out.println("--------------");
			} else {
				System.out.println("Enter a valid #");
				acceptOffer(cars);
			}
		} else System.out.println("There are no offers made.");
	}
	
	public static void displayMenu() {
         System.out.println("What would you like to do?");
         System.out.println("--------------------------------------------------------");
         System.out.println("1. Show all existing cars in the car lot (in any order).");
         System.out.println("2. Add a new car to the car lot.");
         System.out.println("3. Remove a car from the car lot.");
         System.out.println("4. View offers made.");
         System.out.println("5. View all payments");
//         System.out.println("7. View customers.");
         System.out.println("6. Exit program.\n\n");
         System.out.println("--------------------------------------------------------");
         
         int menuOption = 0;
         do {
             System.out.println("\n\nWhat would you like to do? (0 for main menu, 9 for login page)");
             menuOption = sc.nextInt();
             while(menuOption <0 || menuOption >7 && menuOption != 9)
             {
                 System.out.println("Please enter a correct menu option.(0 to see the menu, 9 for login page)");
                 menuOption = sc.nextInt();
             }
             Employee e = new Employee();
             doMenuOption(menuOption, e.cl.cars);
             
             
         } while(menuOption != 6);
}

	//@Override
	public void login(int password) {
		if (password == 1254) {
			passwordFlag = true;
			System.out.println();
			System.out.println("Welcome Back!");
			displayMenu();
		} else {
			count++;
			passwordFlag = false;
			System.out.println("Wrong Password! Try again");
			if (count >=3) {
				System.out.println("\nMaximum trial reached!");
				System.out.println();
				CarDriver.startDriver();
			} 
		}
	}

	public boolean isPasswordFlag() {
		return passwordFlag;
	}
	
	public static void doMenuOption(int action, ArrayList<Car> cars)  {
//        String newCar, VIN, make, model, color;
//        Car foundCar = null;
//        int carNumber = 0, year = 0, mileage = 0;
//        float priceMin = 0.00F, priceMax = 0.00F, price = 0.00F;
//        boolean validInput = true;
        //initCarLot();
        switch (action) {
            case 0:
                System.out.println("Main Menu");
                displayMenu();
                break;
            case 1:
                System.out.println("List of Cars in the car lot");
                System.out.println("----------------------------------------------------------");
                cl.viewCars(cars);
                //cl.getCars();
               // System.out.println(Arrays.toString(cl.cars.toArray()));
                break;
            case 2:
                System.out.println("Add a new car to the car lot.");
                addCar(cl.cars);
                break;
            case 3:
                System.out.println("Remove a car from the car lot.");
                cl.viewCars(cars);
                removeCar(cars);
                break;
            case 4:
                System.out.println("View offers made.");
                viewOffersMade();
                acceptOffer(cars);
                break;
            case 5:
                System.out.println("View all payments.");
                cd.remainMonthlyPay();
                break;
//            case 7:
//                System.out.println("List of cars by given price range.");
//                cd.getCustomers2();
//                cd.getCaps();
//                break;
            case 9:
                //System.out.println("Trying to return.");
                cd.startDriver();
                break;
            case 6:
            	System.out.println("Thanks for stopping by!\nCome back soon!");
//			 ArrayList<Car> cars2 = new ArrayList<Car>(cl.cars);
//			/* ArrayList<Car> */ e.offersMade2 = new ArrayList<Car>(cl.offersMade);
//			/* ArrayList<Car> */ e.carsOwned22 = new ArrayList<Car>(cl.carsOwned2);
//			/* Map <String, String> */ e.customers22 = new HashMap<String, String>(cd.customers2);
//			/* Map<String, ArrayList<Car>> */ e.caps2 = new HashMap<String, ArrayList<Car>>(cd.caps);
            	fdao.saveDealership(d);
            	System.exit(0);
//            default:
//                break;
                
      //  }
                
        
    }
}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(boolean passwordFlag, int count) {
		super();
		this.passwordFlag = passwordFlag;
		this.count = count;
	}

	//@Override
//	public void viewCars(Car c) {
//		// TODO Auto-generated method stub
//		
//	}
}