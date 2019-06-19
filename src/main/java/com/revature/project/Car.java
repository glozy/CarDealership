package com.revature.project;

import java.io.Serializable;
import java.util.ArrayList;


public class Car implements Serializable{
	
	private String VIN, make, model, color;
	private int year, mileage, id, customerId;;
	private boolean offerFlag = false;
	

	private double price, offerPrice;
	//public int 
	
	public Car() {}
	
	public Car(int id,String VIN, String make, String model, int year, int mileage, double price) {
		this.id = id;
		this.VIN = VIN;
		this.make = make;
		this.model = model;
		//this.color = color;
		this.year = year;
		this.mileage = mileage;
		this.price = price;
		this.offerFlag = false;
		
	}

	public Car(int int1, int id, double offerPrice) {
		this.id = id;
		this.offerPrice = offerPrice;
		this.offerFlag = false;
	}
	
	public Car(int id, int customerId, String VIN, String make, String model, int year, int mileage, double price ) {
		this.id = id;
		this.customerId = customerId;
		this.VIN = VIN;
		this.make = make;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
		this.price = price;
	}

	public void setOfferFlag(boolean offerFlag) {
		this.offerFlag = offerFlag;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public double getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(double offerPrice) {
		this.offerPrice = offerPrice;
	}

	public String getVIN() {
		return VIN;
	}
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public String getColor() {
		return color;
	}
	public int getYear() {
		return year;
	}
	public int getMileage() {
		return mileage;
	}
	public double getPrice() {
		return price;
	}
	
	
	public String  viewCars() {
	int i = 1;
	String s = "";
    for (int j = 0; j < 1; j++) {
    	System.out.println("# " + "| " + "VIN " + "| " + "Make " + "| " + "Model " + "| " + "Year " + "| " + "Mileage " + "| " + "Price ");
			System.out.println(getId() +  "  " + getVIN() + "  " +  getMake() + "  " + getModel() + "  " +  getYear() + "  " + getMileage() + "  " + getPrice());
        System.out.println();
    }
	return s;
    
}
	
	@Override
	public String toString() {
	
		return viewCars();
	}

	

}
