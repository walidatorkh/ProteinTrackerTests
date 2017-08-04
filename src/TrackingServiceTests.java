import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.simpleprogrammer.proteintracker.InvalidGoalExeption;
import com.simpleprogrammer.proteintracker.TrackingService;

public class TrackingServiceTests {
	
	private TrackingService service;
	@BeforeClass
	public static void before() {
		System.out.println("Before Class");
	}
	@AfterClass
	public static void after() {
		System.out.println("After Class");
	}
	
	
	@Before
	public void setUp() {
		System.out.println("Before");
		service = new TrackingService();
	}
	@After
	public void tearDown() {
		System.out.println("After");
	}

	
	@Test
	@Category({GoodTestsCategory.class, BadCategory.class})
	public void NewTrackingServiceTotalisZero0() {
		
		assertEquals("tracking service total was not zero", 0, service.getTotal());
	}
	@Test
	//@Ignore
	public void NewTrackingServiceTotalisZero1() {
		TrackingService service = new TrackingService();
		
		assertEquals("tracking service total was not zero", 1, service.getTotal());
	}
	@Test
	public void WhenAddingProteinTotalIncreasesByThatAmount(){
		service.addProtein(10);
		assertEquals("Protein amount was not correct", 10, service.getTotal());
	}
	@Test
	public void WhenRemovingProteinTotalRemainsZero(){
		service.removeProtein(10);
		assertEquals(0, service.getTotal());
	}
	@Test(expected = InvalidGoalExeption.class)
	public void WhenGoalIsSetToLessThanZeroExeptionIsThrown() throws InvalidGoalExeption {
		service.setGoal(-5);
	}
	@Test(timeout = 200)
	public void BadTest() {
		for (int i =0; i < 10000000;   i++)
			service.addProtein(1);
	}

}
