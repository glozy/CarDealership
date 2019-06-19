package com.revature.dao;

import java.util.ArrayList;


import com.revature.project.Offer;

public interface OfferDao {

	
//public void createCar(Car c);
	
	//public void updateCustomer(Customer c);
	
	//public void deleteOfferbyCarID(Integer id);
	
//	public Offer getOfferByCustomerId(Integer id);
	
	//public Offer getOfferByCarId(Integer id);
	
	//public Offer getOfferByOfferId(Integer id);
	
//	public Car getUserByUsername(String name);
	
	public ArrayList<Offer> getOffersbyCarID(Integer id);
	
	public void insertOffer(Offer o);
	
	
	public int getCustomerIDbyofferID(Integer offerChosen);
	
	

}
