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
public class Square extends Shape{
    private Point3D UpperLeftCorner;
    private double size;
    
    public Square(Point3D cornerStart, Point3D cornerEnd, Color color){
        super(color);
        if(cornerStart != null){
                        
        double width = Math.abs((cornerStart.x - cornerEnd.x));
        double height = Math.abs((cornerStart.y - cornerEnd.y));        
        this.size = Math.min(width, height);
            
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
        double centerX = this.UpperLeftCorner.x + (this.size / 2);
        double centerY = this.UpperLeftCorner.y + (this.size / 2);
        this.center = new Point3D(centerX, centerY, 0);
        }
    }
   
    @Override
    public void isPointInShape(Point3D p) {
        Point3D convertedPoint = this.world2Obj(p);
        double dfoc = size / 2;//distanceFromObjectCenter
        if(Math.abs(convertedPoint.x) <= dfoc && Math.abs(convertedPoint.y) <= dfoc){
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
