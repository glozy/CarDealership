package com.revature.driver;

import com.revature.project.CarLot;

public class Dealership{

	public static void startHere() {
		CarLot.initCarLot();
		CarDriver.startDriver();
	}

}
