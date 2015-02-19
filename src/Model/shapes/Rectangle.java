/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.shapes;

import Model.Model;
import Utillities.Tools;
import java.awt.Color;
import java.util.ArrayList;

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
    public boolean isPointInShape(Point3D p) {
        Point3D convertedPoint = Tools.world2Obj(p, this);
        double dfocX = this.width / 2;//distanceFromObjectCenter
        double dfocY = this.height / 2;//distanceFromObjectCenter
        if(Math.abs(convertedPoint.x) <= dfocX && Math.abs(convertedPoint.y) <= dfocY){
          this.isSelected = true;
          Model.inst().setSelectColor(this.getColor());
          return true;
        }
        else{
            this.isSelected = false;
            return false;
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
    
        @Override
    protected void setupHandles(){
        handles = new ArrayList();
        Point3D upperLC = new Point3D((this.UpperLeftCorner.x + width / 2), this.UpperLeftCorner.y - 20, 0);;//Rotation
        Point3D lowerRC = new Point3D(this.UpperLeftCorner.x + width / 2 + 7, this.UpperLeftCorner.y - 13, 0);
        Square s = new Square(upperLC, lowerRC, Color.WHITE);
        handles.add(0, s);
        //g2d.fillRect(0, (-height / 2) - 20, 7, 7);//Rotation
        upperLC = new Point3D(this.UpperLeftCorner.x - 3, this.UpperLeftCorner.y - 3, 0);//TopLeft
        lowerRC = new Point3D(this.UpperLeftCorner.x + 3, this.UpperLeftCorner.y + 3, 0);
        s = new Square(upperLC, lowerRC, Color.WHITE);
        handles.add(1, s);
        
        upperLC = new Point3D((this.UpperLeftCorner.x + width) - 3, this.UpperLeftCorner.y - 3, 0);//Top Right
        lowerRC = new Point3D((this.UpperLeftCorner.x + width) + 3, this.UpperLeftCorner.y  + 3, 0);
        s = new Square(upperLC, lowerRC, Color.WHITE);
        handles.add(2, s);
        
        upperLC = new Point3D((this.UpperLeftCorner.x + width) - 3, (this.UpperLeftCorner.y + height) - 3, 0);//Bottom Right 
        lowerRC = new Point3D((this.UpperLeftCorner.x + width) + 3, (this.UpperLeftCorner.y + height) + 3, 0);
        s = new Square(upperLC, lowerRC, Color.WHITE);
        handles.add(3, s);
        
        upperLC = new Point3D(this.UpperLeftCorner.x - 3, (this.UpperLeftCorner.y + height) - 3, 0);//Bottom Left 
        lowerRC = new Point3D(this.UpperLeftCorner.x + 3, (this.UpperLeftCorner.y + height) + 3, 0);
        s = new Square(upperLC, lowerRC, Color.WHITE);
        handles.add(4, s);
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
