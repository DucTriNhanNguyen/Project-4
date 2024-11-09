
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: A class that works with properties and store their information
 * Due: 11/08/2024
 * Platform/compiler:
 * I pledge that I have completed the programming  assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Duc Tri Nhan Nguyen
 */

package application;

public class Property 
{
	private String propertyName, city, owner;
    private double rentAmount;
    private Plot plot;

    // Constructors
    public Property() 
    {
    	this.propertyName = "";
        this.city = "";
        this.rentAmount = 0;
        this.owner = "";
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner) 
    {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner, int xCoor, int yCoor, int widthValue, int depthValue) 
    {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(xCoor,yCoor, widthValue, depthValue);
    }
    
    public Property(Property otherProperty)
    {
    	this.propertyName = otherProperty.propertyName;
    	this.city = otherProperty.city;
    	this.rentAmount = otherProperty.rentAmount;
    	this.owner = otherProperty.owner;
    	this.plot = otherProperty.plot;
    }


    // Getter and Setter methods
    public String getPropertyName() 
    { 
    	return propertyName; 
    }

    public String getCity() 
    { 
    	return city; 
    }
   
    public double getRentAmount() 
    { 
    	return rentAmount; 
    }

    public String getOwner() 
    { 
    	return owner; 
    }

    public Plot getPlot() 
    { 
    	return plot; 
    }
   
    // toString method
    @Override
    public String toString() 
    {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
