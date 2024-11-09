
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: A student JUnit test case that test the initialization and output of the Plot class
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

class PlotTestStudent 
{

	private Plot plot1, plot2, plot3, plot4, plot5, plot6;
	@BeforeEach
	void setUp() throws Exception 
	{
		plot1 = new Plot();
		plot2 = new Plot(1, 2, 1, 2);
		plot3 = new Plot(2,2,1,1);
		plot4 = new Plot(1,1,5,5);
		plot5 = new Plot(plot1);
		plot6 = new Plot(7, 7, 4, 4);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		plot1 = plot2 = plot3 = plot4 = plot5 = null;
	}
	
	@Test
	public void testOverlaps() 
	{
		assertFalse(plot2.overlaps(plot1));
	}
	
	@Test
	public void testEncompasses() 
	{
		assertTrue(plot4.encompasses(plot3));
		assertFalse(plot6.encompasses(new Plot(0,0,10,10)));
	}
	
	@Test
	public void testCopyConstructor() 
	{		
		assertEquals(plot5.getX(),plot1.getX());	
		assertEquals(plot5.getY(),plot1.getY());
		assertEquals(plot5.getWidth(),plot1.getWidth());
		assertEquals(plot5.getDepth(),plot1.getDepth());
	}
	
	@Test
	public void testToString() 
	{		
		assertEquals("0,0,1,1",plot1.toString());		
	}
}
