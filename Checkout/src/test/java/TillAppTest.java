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
	private final double accuracy = 0.01;
	private double expectedVal;
	private double sum;
	private List<String> items;

	@Before
	public void setup() {
		items = new ArrayList<String>();
		expectedVal = 0;
		sum = 0;
	}

	@Test
	public void priceOfAnAppleIsSixtyTest() {
		// arrange
		items.add(apple);
		expectedVal = 0.60;
		// act
		sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, accuracy);
	}

	@Test
	public void priceOfAnOrangeIsTwentyFivePence() {
		// arrange
		items.add(orange);
		expectedVal = 0.25;
		// act
		sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, accuracy);
	}

	@Test
	public void priceOfTwoOrangesIsFiftyPence() {
		// arrange
		List<String> items = new ArrayList<String>();
		items.add(orange);
		items.add(orange);
		expectedVal = 0.50;
		// act
		sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, accuracy);
	}

	@Test
	public void priceOfAnOrangeAndAnAppleIsEightyPence() {
		// arrange
		items.add(orange);
		items.add(apple);
		expectedVal = 0.85;
		// act
		sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, accuracy);
	}

	@Test
	public void ThreeOrangesAndAnOrangePriceIsOnePoundAndFortyFivePence() {
		// arrange
		items.add(apple);
		items.add(apple);
		items.add(orange);
		items.add(apple);
		expectedVal = 1.45;
		// act
		sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, accuracy);
	}

	@Test
	public void TwoApplesHaveBuyOneGetOneFree(){
		// arrange
		items.add(apple);
		items.add(apple);
		expectedVal = 0.60;
		// act
		sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, accuracy);
	}
	
	@Test
	public void FourApplesHaveBuyOneGetOneFree(){
		// arrange
		items.add(apple);
		items.add(apple);
		items.add(apple);
		items.add(apple);
		expectedVal = 1.20;
		// act
		sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, accuracy);
	}
	
	@Test
	public void priceOfThreeOrangesIsFiftyPenceWithThreeForPriceOfTwo() {
		// arrange
		List<String> items = new ArrayList<String>();
		items.add(orange);
		items.add(orange);
		items.add(orange);
		expectedVal = 0.50;
		// act
		sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, accuracy);
	}
	
	@Test
	public void priceOfSixOrangesIsOnePoundWithThreeForPriceOfTwo() {
		// arrange
		items.add(orange);
		items.add(orange);
		items.add(orange);
		items.add(orange);
		items.add(orange);
		items.add(orange);
		expectedVal = 1.00;
		// act
		sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, accuracy);
	}
	
	@Test
	public void priceOfTwoApplesAndThreeOrangesIsOnePoundTenPence(){
		// arrange
		items.add(orange);
		items.add(orange);
		items.add(orange);
		items.add(apple);
		items.add(apple);
		expectedVal = 1.10;
		// act
		sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, accuracy);
	}
}
