package com.revature.driver;



import com.revature.logging.LoggingUtil;
import com.revature.project.serialize.FileDAO;
import com.revature.project.serialize.FileSerializeDAO;

public class Run {

	private static FileDAO fdao = new FileSerializeDAO();
	
	public static void main(String[] args) {
		LoggingUtil.trace("This is a trace log.");
		
		Dealership d = new Dealership();
		d = fdao.loadDealership();
		d.startHere();
		
		
		
		//fdao.saveDealership(d);
		//d = fdao.loadDealership();
;	}

}
