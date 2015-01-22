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
    private Point3D center;
    private int radis; 
  
    public Circle(Point3D center, Point3D mouseCurrentLocation, Color color){
        super(color);
        if(center != null){
        this.center = center;
        double x = Math.abs((center.x - mouseCurrentLocation.x));
        double y = Math.abs((center.y - mouseCurrentLocation.y));
        this.radis = (int) Math.sqrt((x * x) + (y * y));//pythagorean therom
        }
    }

    public Point3D getCenter() {
        return center;
    }

    public void setCenter(Point3D center) {
        this.center = center;
    }

    public int getRadis() {
        return radis;
    }

    public void setRadis(int radis) {
        this.radis = radis;
    }
    
    
}
