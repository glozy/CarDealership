package com.revature.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.driver.CarDriver;
import com.revature.project.Car;
import com.revature.project.Employee;

public class CarDealershipTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoginOption() {
		CarDriver cd = new CarDriver();
		int action = 1;
		//assertEquals(2, CarDriver.doLoginOption(action));
	}

	@Test
	public void testPasswordFlag() {
		Employee e = new Employee();
		int action = 1;
		e.login(12734);
		assertTrue(e.isPasswordFlag());
	}

	
	@Test
	public void testGetCarColor() {
		Car c = new Car();
		int action = 1;
		assertEquals("",c.getVIN());
	}
	
	@Test
	public void testAddCar() {
		Car c = new Car();
		int action = 1;
		//assertEquals(null, Employee.addCar(null);
	}

	@Test
	public void testMonthlyPayment() {
		CarDriver cd = new CarDriver();
		double pay;
		//assertEquals(null, cd.calcMonthlyPay(4));
	}
	
	

}
