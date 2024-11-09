
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: A JUnit test case that test the initialization and output of the Property class
 * Due: 11/08/2024
 * Platform/compiler:
 * I pledge that I have completed the programming  assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Duc Tri Nhan Nguyen
 */

package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyStudentTest 
{
	
	Property property1, property2, property3, property4;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		property1 = new Property("ABC Bakery", "Montgomery", 3100, "ACB Bank");
		property2 = new Property("House 1", "Germantown", 2500, "Beef Wellington", 2, 2, 3, 3);
		property3 = new Property(property2);
		property4 = new Property();
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		property1 = property2 = property3 = null;
	}
	@Test
	void testGetRentAmount() 
	{
		assertEquals(0, property4.getRentAmount());
	}
	
	@Test
	void testGetCity() 
	{
		assertEquals("Germantown", property2.getCity());
	}
	
	@Test
	void testGetOwner() 
	{
		assertEquals("Beef Wellington", property3.getOwner());
	}
	
	@Test
	void testGetPropertyName() 
	{
		assertEquals("ABC Bakery", property1.getPropertyName());
	}

	@Test
	void testGetPlot() 
	{
		assertEquals(0, property1.getPlot().getX());
		assertEquals(0, property1.getPlot().getY());
		assertEquals(1, property1.getPlot().getWidth());
		assertEquals(1, property1.getPlot().getDepth());
		assertEquals(2, property2.getPlot().getX());
		assertEquals(2, property2.getPlot().getY());
		assertEquals(3, property2.getPlot().getWidth());
		assertEquals(3, property2.getPlot().getDepth());
	}

	@Test
	void testToString() 
	{
		assertEquals("ABC Bakery,Montgomery,ACB Bank,3100.0",property1.toString());	
		assertEquals("House 1,Germantown,Beef Wellington,2500.0",property2.toString());	
		assertEquals("House 1,Germantown,Beef Wellington,2500.0",property3.toString());
	}
}
