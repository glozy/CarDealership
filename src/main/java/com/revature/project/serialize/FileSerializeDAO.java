package com.revature.project.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.driver.CarDriver;
import com.revature.driver.Dealership;
import com.revature.project.Car;
import com.revature.project.CarLot;
import com.revature.project.Customer;

public class FileSerializeDAO  implements FileDAO {

//	private static final String FILENAME = "myCar.dat";
//	private static final String FILENAME2 = "myCarLot.dat";
//	private static final String FILENAME3 = "myCarDriver.dat";
//	private static final String FILENAME4 = "myCustomer.dat";
//	private static final String FILENAME5 = "myCarArrayList.dat";
	private static final String FILENAMES = "mydealer.dat";

	@Override
	public void saveDealership(Dealership d) {
		ObjectOutputStream oos = null;
		FileOutputStream foo = null;

		try {
			foo = new FileOutputStream(FILENAMES);
			oos = new ObjectOutputStream(foo);
			oos.writeObject(d);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (foo != null) foo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Dealership loadDealership() {
		Dealership ret = null;

		//try with resources
		try (FileInputStream fis = new FileInputStream(FILENAMES);
				ObjectInputStream ois = new ObjectInputStream(fis);) {

			ret = (Dealership) ois.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return ret;
	}



//	@Override
//	public void saveCarArrayList(ArrayList<Car> cars) {
//		ObjectOutputStream oos = null;
//		FileOutputStream foo = null;
//
//		try {
//			foo = new FileOutputStream(FILENAME5);
//			oos = new ObjectOutputStream(foo);
//			oos.writeObject(cars);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (oos != null) oos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (foo != null) foo.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	@Override
//	public ArrayList loadCarArrayList() {
//		ArrayList ret = null;
//
//		//try with resources
//		try (FileInputStream fis = new FileInputStream(FILENAME5);
//				ObjectInputStream ois = new ObjectInputStream(fis);) {
//
//			ret = (ArrayList) ois.readObject();
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		return ret;
//	}
//
//
//
//	@Override
//	public void saveCar(Car car) {
//		ObjectOutputStream oos = null;
//		FileOutputStream foo = null;
//
//		try {
//			foo = new FileOutputStream(FILENAME);
//			oos = new ObjectOutputStream(foo);
//			oos.writeObject(car);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (oos != null) oos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (foo != null) foo.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	@Override
//	public Car loadCar() {
//		Car ret = null;
//
//		//try with resources
//		try (FileInputStream fis = new FileInputStream(FILENAME);
//				ObjectInputStream ois = new ObjectInputStream(fis);) {
//
//			ret = (Car) ois.readObject();
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		return ret;
//	}
//
//	@Override
//	public void saveCarLot(CarLot carLot) {
//		ObjectOutputStream oos = null;
//		FileOutputStream foo = null;
//
//		try {
//			foo = new FileOutputStream(FILENAME2);
//			oos = new ObjectOutputStream(foo);
//			oos.writeObject(carLot);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (oos != null) oos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (foo != null) foo.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	@Override
//	public CarLot loadCarLot() {
//		CarLot ret = null;
//
//		//try with resources
//		try (FileInputStream fis = new FileInputStream(FILENAME2);
//				ObjectInputStream ois = new ObjectInputStream(fis);) {
//
//			ret = (CarLot) ois.readObject();
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		return ret;
//	}
//
//	@Override
//	public void saveCarDriver(CarDriver carDriver) {
//		ObjectOutputStream oos = null;
//		FileOutputStream foo = null;
//
//		try {
//			foo = new FileOutputStream(FILENAME3);
//			oos = new ObjectOutputStream(foo);
//			oos.writeObject(carDriver);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (oos != null) oos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (foo != null) foo.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	@Override
//	public CarDriver loadCarDriver() {
//		CarDriver ret = null;
//
//		//try with resources
//		try (FileInputStream fis = new FileInputStream(FILENAME3);
//				ObjectInputStream ois = new ObjectInputStream(fis);) {
//
//			ret = (CarDriver) ois.readObject();
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		return ret;
//	}
//
//	@Override
//	public void saveCustomer(Customer customer) {
//		ObjectOutputStream oos = null;
//		FileOutputStream foo = null;
//
//		try {
//			foo = new FileOutputStream(FILENAME4);
//			oos = new ObjectOutputStream(foo);
//			oos.writeObject(customer);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (oos != null) oos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (foo != null) foo.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	@Override
//	public Customer loadCustomer() {
//		Customer ret = null;
//
//		//try with resources
//		try (FileInputStream fis = new FileInputStream(FILENAME4);
//				ObjectInputStream ois = new ObjectInputStream(fis);) {
//
//			ret = (Customer) ois.readObject();
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		return ret;
//	}
}
