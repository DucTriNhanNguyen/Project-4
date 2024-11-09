
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: A class that store the values for plotting the properties, check if the property overlaps or 
 * encompasses
 * Due: 11/08/2024
 * Platform/compiler:
 * I pledge that I have completed the programming  assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Duc Tri Nhan Nguyen
 */

package application;

public class Plot 
{
	private int x, y, width, depth;

    // Constructors
    public Plot() 
    {
    	this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }

    public Plot(int x, int y, int width, int depth) 
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }
    
    public Plot (Plot otherPlot)
    {
    	this.x = otherPlot.x;
    	this.y = otherPlot.y;
    	this.width = otherPlot.width;
    	this.depth = otherPlot.depth;
    }

    // Getter and Setter methods
    public int getX() 
    { 
    	return x; 
    }
    public void setX(int x) 
    { 
    	this.x = x; 
    }

    public int getY() 
    { 
    	return y; 
    }
    
    public void setY(int y) 
    { 
    	this.y = y; 
    }

    public int getWidth() 
    { 
    	return width; 
    }
    
    public void setWidth(int width) 
    { 
    	this.width = width; 
    }

    public int getDepth() 
    { 
    	return depth; 
    }
    
    public void setDepth(int depth) 
    { 
    	this.depth = depth; 
    }

    // Method to check if the plot overlaps with another plot
    public boolean overlaps(Plot plot) 
    {
        return !(x + width <= plot.x || plot.x + plot.width <= x ||
                 y + depth <= plot.y || plot.y + plot.depth <= y);
    }

    // Method to check if the current plot encompasses another plot
    public boolean encompasses(Plot plot) 
    {
        return x <= plot.x && y <= plot.y &&
               x + width >= plot.x + plot.width &&
               y + depth >= plot.y + plot.depth;
    }

    // toString method
    @Override
    public String toString() 
    {
        return x + "," + y + "," + width + "," + depth;
    }
}
