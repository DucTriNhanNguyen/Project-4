
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: A class that works the management company, calculate the total rent, find the highest rent,
 * total fees and display those information on the GUI
 * Due: 11/08/2024
 * Platform/compiler:
 * I pledge that I have completed the programming  assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Duc Tri Nhan Nguyen
 */

package application;

public class ManagementCompany 
{
	private String name, taxID;
    private double mgmtFeePercentage;
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    // Constructors
    public ManagementCompany() 
    {
        this.name = "";
        this.taxID = "";
        this.mgmtFeePercentage = 0;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }
    
    public ManagementCompany(String name, String taxID, double mgmtFeePercentage) 
    {
        this.name = name;
        this.taxID = taxID;
        this.mgmtFeePercentage = mgmtFeePercentage;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }
    
    public ManagementCompany(String name, String taxID, double mgmtFeePercentage, int initialX, int initialY, int initialWidth, int initialDepth) 
    {
        this.name = name;
        this.taxID = taxID;
        this.mgmtFeePercentage = mgmtFeePercentage;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(initialX, initialY, initialWidth, initialDepth);
        this.numberOfProperties = 0;
    }
    
    public ManagementCompany(ManagementCompany otherCompany) 
    {
        this.name = otherCompany.name;
        this.taxID = otherCompany.taxID;
        this.mgmtFeePercentage = otherCompany.mgmtFeePercentage;
        this.properties = otherCompany.properties;
        this.plot = otherCompany.plot;
        this.numberOfProperties = 0;
    }
    
    
    //Overloaded addProperty methods
    public int addProperty(String name, String city, double rent, String owner) 
    {
    	Property property = new Property(name, city, rent, owner);
    	return addProperty(property);
    }
    
    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) 
    {
    	Property property = new Property(name, city, rent, owner, x, y, width, depth);
    	return addProperty(property);
    }
    
    public int addProperty(Property property) 
    {
        if (numberOfProperties >= MAX_PROPERTY) 
        {
        	return -1;
        }
        if (property == null) 
        {
        	return -2;
        }
        if (!plot.encompasses(property.getPlot())) 
        {
        	return -3;
        }

        for (int i = 0; i < numberOfProperties; i++) 
        {
            if (properties[i].getPlot().overlaps(property.getPlot())) 
            {
            	return -4;
            }
        }
        
        properties[numberOfProperties] = property;
        return numberOfProperties++;
    }

    // Accessors and other methods
    public double getTotalRent() 
    {
        double totalRent = 0;
        for (int i = 0; i < numberOfProperties; i++) 
        {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    public Property getHighestRentProperty() 
    {
        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) 
        {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) 
            {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }

    public int getPropertiesCount() 
    {
        return numberOfProperties;
    }
    
    public String getName()
    {
    	return name;
    }
    
    public String getTaxID()
    {
    	return taxID;
    }
    
    public double getMgmFeePer()
    {
    	return mgmtFeePercentage;
    }
    
    public Plot getPlot()
    {
    	return plot;
    }
    
    public Property[] getProperty()
    {
    	return properties;
    }
    
    public void removeLastProperty() 
    {
        if (numberOfProperties > 0) 
        {
            properties[--numberOfProperties] = null;
        }
    }

    public boolean isPropertiesFull() 
    {
        return numberOfProperties >= MAX_PROPERTY;
    }
    
    public boolean isManagementFeeValid() 
    {
        return mgmtFeePercentage >= 0 && mgmtFeePercentage <= 100;
    }

    // toString method
    @Override
    public String toString() 
    {
        StringBuilder result = new StringBuilder("List of the properties for " + name + ", taxID: " + taxID + "\n"
                + "______________________________________________________\n");
        for (int i = 0; i < numberOfProperties; i++) 
        {
            result.append(properties[i].toString()).append("\n");
        }
        result.append("______________________________________________________\n");
        double totalManagementFee = getTotalRent() * (mgmtFeePercentage / 100);
        result.append("\n total management Fee: ").append(totalManagementFee);
        return result.toString();
    }
}
