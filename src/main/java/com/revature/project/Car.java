package com.revature.project;

import java.io.Serializable;
import java.util.ArrayList;


public class Car implements Serializable{
	
	private String VIN, make, model, color;
	private int year, mileage;
	private double price, offerPrice;
	//public int 
	
	public Car() {}
	
	public Car(String VIN, String make, String model, String color, int year, int mileage, double price, double offerPrice) {
		this.VIN = VIN;
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.mileage = mileage;
		this.price = price;
		this.offerPrice = offerPrice;
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
    	System.out.println("# " + "| " + "VIN " + "| " + "Make " + "| " + "Model " + "| " + "Color " + "| " + "Year " + "| " + "Mileage " + "| " + "Price ");
        System.out.println(i++ + " " + getVIN() + " " +  getMake() + " " + getModel() + " " + getColor()
        			+ " " + getYear() + " " + getMileage() + " " + getPrice());
        System.out.println();
    }
	return s;
    
}
	
	@Override
	public String toString() {
	
		return viewCars();
	}

	

}
