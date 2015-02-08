/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.shapes;

import Model.Model;
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
        
        double centerX = this.UpperLeftCorner.x + (this.width / 2);
        double centerY = this.UpperLeftCorner.y + (this.height / 2);
        this.setCenter(new Point3D(centerX, centerY, 0));
        }
    }
   
    @Override
    public void isPointInShape(Point3D p) {
        Point3D convertedPoint = this.world2Obj(p);
        double dfocX = this.width / 2;//distanceFromObjectCenter
        double dfocY = this.height / 2;//distanceFromObjectCenter
        if(Math.abs(convertedPoint.x) <= dfocX && Math.abs(convertedPoint.y) <= dfocY){
          this.isSelected = true;
          Model.inst().setSelectColor(this.getColor());
        }
        else{
            this.isSelected = false;
            }
    }
    
        @Override
    public void setCenter(Point3D center) {
        if(this.center != null && this.UpperLeftCorner != null){
        double x = center.x - this.center.x;//recreate the trans vector for moving the uppper corner point
        double y = center.y - this.center.y; 
        Point3D transVec = new Point3D(x, y, 0);//Trans vec
        x = this.UpperLeftCorner.x + transVec.x;
        y = this.UpperLeftCorner.y + transVec.y;
        Point3D p = new Point3D(x, y, 0);
        this.UpperLeftCorner = p;
        }
        this.center = center;
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
