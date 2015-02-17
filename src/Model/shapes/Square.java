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
public class Square extends Shape{
    private Point3D UpperLeftCorner;
    private double size;
    
    public Square(Point3D cornerStart, Point3D cornerEnd, Color color){
        super(color);
        if(cornerStart != null){                   
            double width = Math.abs((cornerStart.x - cornerEnd.x));
            double height = Math.abs((cornerStart.y - cornerEnd.y));        
            this.size = Math.min(width, height);
            this.setUpperLeftCorner(cornerStart, cornerEnd);
            double centerX = this.UpperLeftCorner.x + (this.size / 2);
            double centerY = this.UpperLeftCorner.y + (this.size / 2);
            this.center = new Point3D(centerX, centerY, 0);
            if(centerX < 0 || centerY < 0){
                this.center = null;
            }
        }
    }
   
    @Override
    public boolean isPointInShape(Point3D p) {
        Point3D convertedPoint = Tools.world2Obj(p, this.angle, this);
        double dfoc = size / 2;//distanceFromObjectCenter
        
        if(Math.abs(convertedPoint.x) <= dfoc && Math.abs(convertedPoint.y) <= dfoc){
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
        Point3D upperLC = new Point3D((this.UpperLeftCorner.x + size / 2), this.UpperLeftCorner.y - 20, 0);;//Rotation
        Point3D lowerRC = new Point3D(this.UpperLeftCorner.x + size / 2 + 7, this.UpperLeftCorner.y - 13, 0);
        Square s = new Square(upperLC, lowerRC, Color.WHITE);
        handles.add(0, s);
        //g2d.fillRect(0, (-height / 2) - 20, 7, 7);//Rotation
        upperLC = new Point3D(this.UpperLeftCorner.x - 3, this.UpperLeftCorner.y - 3, 0);//TopLeft
        lowerRC = new Point3D(this.UpperLeftCorner.x + 3, this.UpperLeftCorner.y + 3, 0);
        s = new Square(upperLC, lowerRC, Color.WHITE);
        handles.add(1, s);
        
        upperLC = new Point3D((this.UpperLeftCorner.x + size) - 3, this.UpperLeftCorner.y - 3, 0);//Top Right
        lowerRC = new Point3D((this.UpperLeftCorner.x + size) + 3, this.UpperLeftCorner.y  + 3, 0);
        s = new Square(upperLC, lowerRC, Color.WHITE);
        handles.add(2, s);
        
        upperLC = new Point3D((this.UpperLeftCorner.x + size) - 3, (this.UpperLeftCorner.y + size) - 3, 0);//Bottom Right 
        lowerRC = new Point3D((this.UpperLeftCorner.x + size) + 3, (this.UpperLeftCorner.y + size) + 3, 0);
        s = new Square(upperLC, lowerRC, Color.WHITE);
        handles.add(3, s);
        
        upperLC = new Point3D(this.UpperLeftCorner.x - 3, (this.UpperLeftCorner.y + size) - 3, 0);//Bottom Left 
        lowerRC = new Point3D(this.UpperLeftCorner.x + 3, (this.UpperLeftCorner.y + size) + 3, 0);
        s = new Square(upperLC, lowerRC, Color.WHITE);
        handles.add(4, s);
    }
    private void setUpperLeftCorner(Point3D cornerStart, Point3D cornerEnd){
        if((cornerStart.y > cornerEnd.y) && (cornerStart.x > cornerEnd.x)){
            Point3D p = new Point3D(cornerStart.x - size, cornerStart.y - size, 0);
            this.UpperLeftCorner = p;
        }
        
        else if((cornerStart.y < cornerEnd.y) && (cornerStart.x < cornerEnd.x)){
            this.UpperLeftCorner = cornerStart;
        }
        
        else if((cornerStart.y > cornerEnd.y) && (cornerStart.x < cornerEnd.x)){
            Point3D p = new Point3D(cornerStart.x, cornerStart.y - size, 0);
            this.UpperLeftCorner = p;
        }
        
        else {//if((cornerStart.y < cornerEnd.y) && (cornerStart.x > cornerEnd.x)){
            Point3D p = new Point3D(cornerStart.x - size, cornerStart.y, 0);
            this.UpperLeftCorner = p;
        }  
    }  
    public Point3D getCorner() {
        return UpperLeftCorner;
    }
    public void setCorner(Point3D Corner) {
        this.UpperLeftCorner = Corner;
    }
    public double getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
