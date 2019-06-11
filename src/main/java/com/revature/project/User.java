package com.revature.project;

import java.util.ArrayList;

public interface User {
	
	void login(int password);
	
	void viewCars(Car c);

	void viewCars(ArrayList<Car> cars);

}
