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



public class Rectangle extends Shape{
    private Point3D UpperLeftCorner;
    private double height;
    private double width;
    
    public Rectangle(Point3D cornerStart, Point3D cornerEnd, Color color){
        super(color);
        if(cornerStart != null){
        if((cornerStart.y > cornerEnd.y) && (cornerStart.x > cornerEnd.x)){
            this.UpperLeftCorner = cornerEnd;
        }
        
        else if((cornerStart.y < cornerEnd.y) && (cornerStart.x < cornerEnd.x)){
            this.UpperLeftCorner = cornerStart;
        }
        
        else if((cornerStart.y > cornerEnd.y) && (cornerStart.x < cornerEnd.x)){
            Point3D p = new Point3D(cornerStart.x, cornerEnd.y, 0);
             this.UpperLeftCorner = p;
        }
        
        else {//if((cornerStart.y < cornerEnd.y) && (cornerStart.x > cornerEnd.x)){
            Point3D p = new Point3D(cornerEnd.x, cornerStart.y, 0);
            this.UpperLeftCorner = p;
        }

        this.width = Math.abs((cornerStart.x - cornerEnd.x));
        this.height = Math.abs((cornerStart.y - cornerEnd.y));
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
    
    public Point3D getCorner() {
        return UpperLeftCorner;
    }

    public void setUpperLeftCorner(Point3D Corner) {
        this.UpperLeftCorner = Corner;
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
