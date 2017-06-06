package main.java.com.fdmgroup.till;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TillApp {

	final static double applePrice = 0.6;
	final static double orangePrice = 0.25;
	final static String orange = "Orange";
	final static String apple = "Apple";
	private final static Logger LOGGER = Logger.getLogger("till");
	private int numberOfApples = 0;

	public double total(List<String> items) {
		LOGGER.log(Level.INFO, "Starting till");
		double total = 0;
		for (String item : items) {
			if (item.equals(apple)) {
				LOGGER.log(Level.INFO, "Adding price of apple to total");
				total += applePrice;
				numberOfApples +=1;
				if(numberOfApples == 2){
					LOGGER.log(Level.INFO, "Buy One Get One Free on Apples");
					total -= applePrice;
				}
			}
			if (item.equals(orange)) {
				LOGGER.log(Level.INFO, "Adding price of orange to total");
				total += orangePrice;
			}
		}
		LOGGER.log(Level.INFO, "Returning total of £" + total);
		return total;
	}
}
