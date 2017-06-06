package test.java;

import main.java.com.fdmgroup.till.TillApp;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class TillAppTest {

	private TillApp tillApp = new TillApp();
	private final String apple = "Apple";

	@Test
	public void priceOfAnApplesIsSixtyTest() {
		// arrange
		List<String> items = new ArrayList<String>();
		items.add(apple);
		double expectedVal = 0.60;
		// act
		double sum = tillApp.total(items);
		// assert
		assertEquals(expectedVal, sum, 0.001);
	}

}
