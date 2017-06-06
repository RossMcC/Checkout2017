package test.java;

import main.java.com.fdmgroup.till.TillApp;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class TillAppTest {

	private TillApp tillApp = new TillApp();
	private final String apple = "Apple";
	private final String orange = "Orange";

	@Test
	public void priceOfAnAppleIsSixtyTest() {
		// arrange
		List<String> items = new ArrayList<String>();
		items.add(apple);
		double expectedVal = 0.60;
		// act
		double sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, 0.001);
	}
	
	@Test
	public void priceOfTwoApplesIsOneTwentyTest() {
		// arrange
		List<String> items = new ArrayList<String>();
		items.add(apple);
		items.add(apple);
		double expectedVal = 1.20;
		// act
		double sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, 0.001);
	}
	
	@Test
	public void priceOfAnOrangeIsTwentyFivePence(){
		// arrange
		List<String> items = new ArrayList<String>();
		items.add(orange);
		double expectedVal = 0.25;
		// act
		double sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, 0.001);
	}
	
	@Test
	public void priceOfTwoOrangesIsFiftyPence(){
		// arrange
		List<String> items = new ArrayList<String>();
		items.add(orange);
		items.add(orange);
		double expectedVal = 0.50;
		// act
		double sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, 0.001);
	}
	
	@Test
	public void priceOfAnOrangeAndAnAppleIsEightyPence(){
		// arrange
		List<String> items = new ArrayList<String>();
		items.add(orange);
		items.add(apple);
		double expectedVal = 0.85;
		// act
		double sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, 0.001);
	}

}
