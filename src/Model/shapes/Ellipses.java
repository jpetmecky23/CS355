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
public class Ellipses extends Shape{
    private double height;
    private double width;
    
   public  Ellipses(Point3D center, Point3D mouseCurrentLocation, Color color){
       super(color);
       if(center != null){
       this.setCenter(center);
       this.width = 2 * (Math.abs((center.x - mouseCurrentLocation.x)));//Times 2 since these oare radii
       this.height = 2 * (Math.abs((center.y - mouseCurrentLocation.y)));//Times 2 since these oare radii 
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

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
