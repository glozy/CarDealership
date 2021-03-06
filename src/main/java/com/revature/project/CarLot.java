package com.revature.project;

import java.io.Serializable;
import java.util.ArrayList;

import com.revature.dao.CarDao;
import com.revature.dao.CarDaoImpl;


public class CarLot implements Serializable{
	
	public static  ArrayList<Car> cars = new ArrayList<Car>();
	
	
	public  static ArrayList<Car> offersMade = new ArrayList<Car>();
	public  static ArrayList<Car> carsOwned2 = new ArrayList<Car>();
	public static CarLot cl;// = new CarLot();
	private static CarDaoImpl cad = new CarDaoImpl();
	
	public static void initCarLot() {
		cl = new CarLot();
     // cl.cars.add(new Car("AB425", "Toyota", "Rav4", "Red  ", 2012, 56000, 5000.00));
      CarDao newCar = new CarDaoImpl();
//      newCar.createCar(new Car("AB425", "Toyota", "Rav4", 2012, 56000, 5000.00));
//      newCar.createCar(new Car("CD553", "Honda", "Civic", 2000, 5000, 1900.00));
//      newCar.createCar(new Car("AT210", "Ford", "Focus", 2018, 21000, 7500.00));
     //  cl.cars.add(new Car("CD553", "Honda", "Civic", "Blue ", 2000, 5000, 1900.00));
     //cl.cars.add(new Car("AT210", "Ford", "Focus", "Silver", 2018, 21000, 7500.00));
	}
	
	

	public static void viewCars(ArrayList<Car> cars) {
		int i = 1;
        for (Car car : cad.getAllCars()) {
        	System.out.println("# " + "| " + "VIN  " + "| " + "Make  " + "| " + "Model " + "| " + "Year " + "| " + "Mileage " + "| " + "Price ");
			System.out.println( i++ +  "  " + car.getVIN() + "  " +  car.getMake() + "    " + car.getModel() + "   " + car.getYear() + "   " + car.getMileage() + "     " + car.getPrice());
            System.out.println();
        }
        
//        for (Car ca: cad.getAllCars()) {
//        	System.out.println(ca);
//        }
	}
	
	public static ArrayList<Car> getCars() {
		System.out.println(cl.cars);
		return cl.cars;
	}

	@Override
	public String toString() {
		return "CarLot [cars=" + cars + ", offersMade=" + offersMade + "]";
	}

	public static ArrayList<Car> getOffersMade() {
		System.out.println(cl.offersMade);
		return cl.offersMade;
	}

	public static void viewOffersMade() {
		//CarLot cl = new CarLot();
		int i = 1;
        for (Car car : cad.getAllOffers()) {
        	System.out.println("# " + "| " + "VIN " + "| " + "Make " + "| " + "Model " + "| " + "Color " + "| " + "Year " + "| " + "Mileage " + "| " + "Price " + "| " + "Offer ");
            System.out.println(i++ + " " + car.getVIN() + " " +  car.getMake() + " " + car.getModel() + " " + car.getColor()
            			+ " " + car.getYear() + " " + car.getMileage() + " " + car.getPrice());
            System.out.println();
        }
	}
	
	
	
	
	
//	public static void main(String[] args) {
//		initCarLot();
//		CarLot cl = new CarLot();
//		
//		CarLot.viewCars(cl.cars);
//		//System.out.println(cl.viewCars(cl.getCars()));
//		//System.out.println(cars2);
//		//cars2.add(new Car("AT210", "Ford", "Focus", "Silver", 2018, 21000, 7500.00));
////		cars2.add(cars.get(1));
////		System.out.println(cars2);
//	}
//	
}
