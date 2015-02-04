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
       Point3D convertedPoint = this.world2Obj(p);
        double X = (convertedPoint.x - center.x);
        X = X * X;
        double Y = (convertedPoint.y - center.y);
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
