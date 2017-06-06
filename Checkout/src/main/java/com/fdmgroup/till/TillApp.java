package main.java.com.fdmgroup.till;

import java.util.List;

public class TillApp {

	final static double applePrice = 0.6;
	final static double orangePrice = 0.25;
	final static String orange = "Orange";
	final static String apple = "Apple";

	public double total(List<String> items){
		double total =0;
		for(String item: items){
			if(item.equals(apple)){
				total += applePrice;
			}
			if(item.equals(orange)){
				total+=orangePrice;
			}
		}
		return total;
		
	}
}
