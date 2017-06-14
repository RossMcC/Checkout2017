package main.java.com.fdmgroup.till;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TillApp {
	public TillApp(double differentApplePrice, double differentOrangePrice) {
		TillApp.applePrice = differentApplePrice;
		TillApp.orangePrice = differentOrangePrice;
	}

	public TillApp() {
		TillApp.applePrice = 0.6;
		TillApp.orangePrice = 0.25;
	}

	static double applePrice;
	static double orangePrice;
	final static String orange = "Orange";
	final static String apple = "Apple";
	final static Logger LOGGER = LogManager.getLogger(TillApp.class);
	private int numberOfApples = 0;
	private int numberOfOranges = 0;

	public double total(List<String> items) {
		double total = 0;
		for (String item : items) {
			if (item.equals(apple)) {
				total = addApple(total);
			} else if (item.equals(orange)) {
				total = addOrange(total);
			} else {
				LOGGER.error("One or more items are not recognised");
				LOGGER.error("Returning current total of £" + priceFormatter(total));
				return total;
			}
		}

		LOGGER.info("Returning total of £" + priceFormatter(total));
		return total;
	}

	private String priceFormatter(double total) {
		NumberFormat formatter = new DecimalFormat("#0.00");
		return formatter.format(total);
	}

	private double addOrange(double total) {
		total += orangePrice;
		numberOfOranges += 1;
		if (numberOfOranges == 3) {
			LOGGER.info("Three for the price of two on Oranges");
			total -= orangePrice;
			numberOfOranges = 0;
		}
		return total;
	}

	private double addApple(double total) {
		total += applePrice;
		numberOfApples += 1;
		if (numberOfApples == 2) {
			LOGGER.info("Buy One Get One Free on Apples");
			total -= applePrice;
			numberOfApples = 0;
		}
		return total;
	}
}
