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
    public Point3D world2Obj(Point3D p) {
        return super.world2Obj(p); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean isPointInShape(Point3D p) {
        return super.isPointInShape(p); //To change body of generated methods, choose Tools | Templates.
    }
    
    public double getRadis() {
        return radis;
    }

    public void setRadis(int radis) {
        this.radis = radis;
    }  
    
}
