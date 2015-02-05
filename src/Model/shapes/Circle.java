/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.shapes;

import java.awt.Color;

/**
 *
 * @author James
 */
public class Circle extends Shape{
    private double radis;
  
    public Circle(Point3D center, Point3D mouseCurrentLocation, Color color){
        super(color);
        if(center != null){
        this.setCenter(center);
        double x = Math.abs((center.x - mouseCurrentLocation.x));
        double y = Math.abs((center.y - mouseCurrentLocation.y));
        this.radis = Math.sqrt((x * x) + (y * y));//pythagorean therom
        }
    }

    @Override
    public boolean isPointInShape(Point3D p) {
       Point3D convertedPoint = this.world2Obj(p);//COnvert to object coords
       Point3D objectOrigin = new Point3D(0, 0, 0); //Used to make sure the formula make since to me.
        double X = (convertedPoint.x - objectOrigin.x);
        X = X * X;
        double Y = (convertedPoint.y - objectOrigin.y);
        Y = Y * Y;
        double sum = X + Y;
        double radisSquared = (this.radis * this.radis);
        if(sum <= radisSquared){
            return true;
        }
        return false;
    }
    
    public double getRadis() {
        return radis;
    }

    public void setRadis(int radis) {
        this.radis = radis;
    }  
    
}
