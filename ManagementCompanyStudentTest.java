
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: A student JUnit test case that test the initialization and output of the ManagementCompany class
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

class ManagementCompanyStudentTest 
{
	Property testProperty1, testProperty2;
	ManagementCompany superRealEstate, ghostCompany, cloneCompany1, cloneCompany2;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		superRealEstate= new ManagementCompany("Super Co.", "11111199",12);
		ghostCompany = new ManagementCompany();
		cloneCompany1 = new ManagementCompany ("Clone Estate", "222222", 5, 0, 0, 8, 8 );
		cloneCompany2 = new ManagementCompany(cloneCompany1);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		superRealEstate = ghostCompany = cloneCompany1 = cloneCompany2 =  null;
	}
	
	@Test
	public void testAddProperty() 
	{
		testProperty1 = new Property ("Apartment Block A", "City Z", 2613, "Willy Wonka",3,2,2,2);		 
		assertEquals(superRealEstate.addProperty(testProperty1),0,0);	//property has been successfully added to index 0
	}
	
	@Test
	public void testGetPropertiesCount() 
	{
		testProperty1 = new Property ("Apartment Block A", "City Z", 2613, "Willy Wonka",3,2,2,2);	 
		testProperty2 = new Property ("Dental Warfare Clinic", "Rockville", 2745, "Jason Voorhees");
		assertEquals(superRealEstate.getPropertiesCount(), 0);
		superRealEstate.addProperty(testProperty1);
		superRealEstate.addProperty("Dental Warfare Clinic", "Rockville", 2745, "Jason Voorhees", 1, 1, 1, 1);
		assertEquals(superRealEstate.getPropertiesCount(), 2);
		cloneCompany1.addProperty("Dreamy Dinner", "Elm Streets", 2000, "Freddy Krueger");
		assertEquals(cloneCompany1.getPropertiesCount(), 1);
	}
	
	@Test
	public void testGetTotalRent() 
	{
		testProperty1 = new Property ("Apartment Block A", "City Z", 5000, "Willy Wonka",3,2,2,2);	 
		testProperty2 = new Property ("Dental Warfare Clinic", "Rockville", 0, "Jason Voorhees");
		cloneCompany2.addProperty(testProperty1);
		cloneCompany2.addProperty(testProperty2);
		cloneCompany2.addProperty("Woodside apartment", "Silent Hill", 2700, "James Bond", 7, 7, 1, 1);
		assertEquals(cloneCompany2.getTotalRent(), 7700);
	}
	
	@Test
	public void testGetHighestRentProperty() 
	{
		testProperty1 = new Property ("Apartment Block A", "City Z", 3100, "Willy Wonka",3,2,2,2);	 
		testProperty2 = new Property ("Dental Warfare Clinic", "Rockville", 0, "Jason Voorhees");
		superRealEstate.addProperty(testProperty1);
		superRealEstate.addProperty(testProperty2);
		assertEquals(superRealEstate.getHighestRentProperty().getRentAmount(), 3100);
	}
	
	@Test
	public void testGetName() 
	{
		assertEquals(ghostCompany.getName(), "");
	}
	
	@Test
	public void testGetTaxID() 
	{
		assertEquals(superRealEstate.getTaxID(), "11111199");
	}
	
	@Test
	public void testMgmtFeePer() 
	{
		assertEquals(superRealEstate.getMgmFeePer(), 12);
	}
	
	@Test
	public void testToString() 
	{
		testProperty1 = new Property ("Apartment Block A", "City Z", 2613, "Willy Wonka",3,2,2,2);
		superRealEstate.addProperty(testProperty1);
		String expectedString = "List of the properties for Super Co., taxID: 11111199\n"
				+ "______________________________________________________\n"
				+ "Apartment Block A,City Z,Willy Wonka,2613.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 313.56";
		System.out.println(expectedString);
		System.out.println(superRealEstate.toString());
		assertEquals(expectedString, superRealEstate.toString());
				
	}
}
