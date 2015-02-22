/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.shapes;

import Utillities.Tools;
import java.awt.Color;

/**
 *
 * @author James
 */
public class Handle extends Shape{
    private Point3D UpperLeftCorner;
    private double size;
    
    public  Handle(Point3D cornerStart, Point3D cornerEnd, Color c){
        super(c);
        if(cornerStart != null){                   
               this.rebuild(cornerStart, cornerEnd);
        }
    }

    public boolean isPointInShape(Point3D p) {
        Point3D convertedPoint = Tools.world2Obj(p, this);
        double dfoc = size / 2;//distanceFromObjectCenter
        
        if(Math.abs(convertedPoint.x) <= dfoc && Math.abs(convertedPoint.y) <= dfoc){

            return true;
        }
        else{
            return false;
            }
    } 
    @Override
    public Point3D getCenter(){
        if(this.UpperLeftCorner != null){
        double x = this.UpperLeftCorner.x + this.getSize() / 2.0;
        double y = this.UpperLeftCorner.y + this.getSize() / 2.0;
        Point3D p = new Point3D(x, y, 0);
        return p;
        }
        return null;
    }
    public void rebuild(Point3D cornerStart, Point3D cornerEnd){
        double width = Math.abs((cornerStart.x - cornerEnd.x));
        double height = Math.abs((cornerStart.y - cornerEnd.y));        
        this.size = Math.min(width, height);
        this.UpperLeftCorner = Tools.findUpperLeftCornerSqu(cornerStart, cornerEnd, this.size);
    }
    public Point3D getUpperLeftCorner() {
        return UpperLeftCorner;
    }
    public void setUpperLeftCorner(Point3D Corner) {
        this.UpperLeftCorner = Corner;
    }
    public double getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    
    public void resetSize(double size) {
        this.size = this.size + size;
    }
}


