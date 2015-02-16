package Model.shapes;

import java.awt.Color;

/**
 *
 * @author Brennan Smith
 */
public class Point3D //extends Shape 
{
    public double x;
    public double y;
    public double z;
    
    public Point3D(double newX, double newY, double newZ)
    {
        //super(Color.black);//Points dont need a color to my knoledge
        x = newX;
        y = newY;
        z = newZ;
    }

    public Point3D(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double length() 
    {
        return Math.sqrt(x*x+y*y+z*z);
    }
    
    @Override
    public String toString()
    {
        return "X: "+x+", Y: "+y+", Z:"+z;
    }

    public void Normalize() 
    {
        Double denominator = Math.sqrt(x*x+y*y+z*z);
        x/=denominator;
        y/=denominator;
        z/=denominator;
    }
    
    
}
