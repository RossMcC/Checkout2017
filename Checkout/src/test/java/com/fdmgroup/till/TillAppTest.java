package test.java.com.fdmgroup.till;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.com.fdmgroup.till.TillApp;

public class TillAppTest {

	private TillApp tillApp;
	private String apple;
	private String orange;
	private double accuracy;
	private double expectedVal;
	private double sum;
	private List<String> items;

	@Before
	public void testSetup() {
		tillApp = new TillApp();
		accuracy = 0.001;
		apple = "Apple";
		orange = "Orange";
		items = new ArrayList<String>();
		expectedVal = 0;
		sum = 0;
	}
	
	@Test
	public void testPriceOfAnAppleIsSixtyPence() {
		items.add(apple);
		expectedVal = 0.60;
		sum = tillApp.total(items);
		assertEquals(expectedVal, sum, accuracy);
	}
	
	@Test
	public void testApplePriceCanBeChangedWithContrsuctor(){
		double applePrice = 0.75;
		TillApp appleTill = new TillApp(applePrice,0.25);
		items.add(apple);
		expectedVal = 0.75;
		sum = appleTill.total(items);
		assertEquals(expectedVal, sum, accuracy);
	}
	
	@Test
	public void testOrangePriceCanBeChangedWithContrsuctor(){
		double orangePrice = 0.80;
		TillApp orangeTill = new TillApp(0.60,orangePrice);
		items.add(orange);
		expectedVal = 0.80;
		sum = orangeTill.total(items);
		assertEquals(expectedVal, sum, accuracy);
	}

	
	@Test
	public void testToVerifyIfSomethingUnregognisedIsPassedInItReturnsCurrentTotal() {
		items.add(apple);
		items.add(orange);
		items.add("Koala");
		items.add(apple);
		items.add(orange);
		expectedVal = 0.85;
		sum = tillApp.total(items);
		assertEquals(expectedVal, sum, accuracy);
	}
	
	@Test
	public void testToVerifyIfAnEmptyStringIsPassedInItReturnsCurrentTotal() {
		items.add(apple);
		items.add(orange);
		items.add("");
		items.add(apple);
		items.add(orange);
		expectedVal = 0.85;
		sum = tillApp.total(items);
		assertEquals(expectedVal, sum, accuracy);
	}

	@Test
	public void testPriceOfAnOrangeIsTwentyFivePence() {
		items.add(orange);
		expectedVal = 0.25;
		sum = tillApp.total(items);
		assertEquals(expectedVal, sum, accuracy);
	}

	@Test
	public void testPriceOfTwoOrangesIsFiftyPence() {
		List<String> items = new ArrayList<String>();
		items.add(orange);
		items.add(orange);
		expectedVal = 0.50;
		sum = tillApp.total(items);
		assertEquals(expectedVal, sum, accuracy);
	}

	@Test
	public void testPriceOfAnOrangeAndAnAppleIsEightyPence() {
		items.add(orange);
		items.add(apple);
		expectedVal = 0.85;
		sum = tillApp.total(items);
		assertEquals(expectedVal, sum, accuracy);
	}

	@Test
	public void testThreeOrangesAndAnOrangePriceIsOnePoundAndFortyFivePence() {
		items.add(apple);
		items.add(apple);
		items.add(orange);
		items.add(apple);
		expectedVal = 1.45;
		sum = tillApp.total(items);
		assertEquals(expectedVal, sum, accuracy);
	}

	@Test
	public void testTwoApplesHaveBuyOneGetOneFree() {
		items.add(apple);
		items.add(apple);
		expectedVal = 0.60;
		sum = tillApp.total(items);
		assertEquals(expectedVal, sum, accuracy);
	}

	@Test
	public void testFourApplesHaveBuyOneGetOneFree() {
		items.add(apple);
		items.add(apple);
		items.add(apple);
		items.add(apple);
		expectedVal = 1.20;
		sum = tillApp.total(items);
		assertEquals(expectedVal, sum, accuracy);
	}

	@Test
	public void testPriceOfThreeOrangesIsFiftyPenceWithThreeForPriceOfTwo() {
		items.add(orange);
		items.add(orange);
		items.add(orange);
		expectedVal = 0.50;
		sum = tillApp.total(items);
		assertEquals(expectedVal, sum, accuracy);
	}

	@Test
	public void testPriceOfSixOrangesIsOnePoundWithThreeForPriceOfTwo() {
		items.add(orange);
		items.add(orange);
		items.add(orange);
		items.add(orange);
		items.add(orange);
		items.add(orange);
		expectedVal = 1.00;
		sum = tillApp.total(items);
		assertEquals(expectedVal, sum, accuracy);
	}

	@Test
	public void testPriceOfTwoApplesAndThreeOrangesIsOnePoundTenPence() {
		items.add(orange);
		items.add(orange);
		items.add(orange);
		items.add(apple);
		items.add(apple);
		expectedVal = 1.10;
		sum = tillApp.total(items);
		assertEquals(expectedVal, sum, accuracy);
	}
}
