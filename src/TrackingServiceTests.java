import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

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
		
		assertEquals("tracking service total was not zero", 0, service.getTotal());
	}
//	@Test
//	//@Ignore
//	@Category(GoodTestsCategory.class)
//	public void WhenAddingProteinTotalIncreasesByThatAmount(){
//		service.addProtein(10);
//		//assertEquals("Protein amount was not correct", 10, service.getTotal());
//		//assertThat(service.getTotal(), is(10));
//		assertThat(service.getTotal(), allof(is(10), instanceOf(Integer.class)));
//
//	}
	
	@Test
	@Category({GoodTestsCategory.class, BadCategory.class})
	public void whenAddingProteinTotalIncreasesByThatAmount() {

		service.addProtein(10);
		assertEquals("Protein amount was not correct",10, service.getTotal());
		assertThat(service.getTotal(), is(10));
		
		assertThat(service.getTotal(), allOf(is(10), instanceOf(Integer.class)));

	}


	@Test
	public void WhenRemovingProteinTotalRemainsZero(){
		service.removeProtein(10);
		assertEquals(0, service.getTotal());
	}
	
//	@Rule
//	public ExpectedException thrown = ExpectedException.none();
//	
//	@Test  //(expected = InvalidGoalExeption.class)
//	public void WhenGoalIsSetToLessThanZeroExeptionIsThrown() throws InvalidGoalExeption {
//		thrown.expect(InvalidGoalExeption.class);
//		thrown.expectMessage("Goal was less that zero!");
//		service.setGoal(-5);
//	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@SuppressWarnings("deprecation")
	@Test
	public void whenGoalIsSetToLessThanZeroExceptionisThrown() throws InvalidGoalExeption{
		thrown.expect(InvalidGoalExeption.class);
		//thrown.expectMessage("Goal was less than zero!");
		thrown.expectMessage(containsString("Goal"));
		service.setGoal(-5);
	}
	
	@SuppressWarnings("deprecation")
	@Rule
	//@Ignore
	public Timeout timeout = new Timeout(20);
	@Test
	//@Test(timeout = 200)
	public void BadTest() {
		for (int i =0; i < 1000000;   i++)
			service.addProtein(1);
	}

}
