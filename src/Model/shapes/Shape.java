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
public class Shape{
    protected Color color;
    protected double angle;
    protected boolean isSelected;
    protected Point3D center;
    
    public Shape(Color color) {
        this.color = color;
        this.angle = 0;
        this.isSelected = false;
    }
       
    public Point3D world2Obj(Point3D p){        
        double transX = p.x - center.x;
        double transY = p.y - center.y;
        Point3D transPoint = new Point3D(transX, transY, 0);
        return transPoint;
    }
    
    public void translateShape(Point3D transVec){
        if(this.isSelected){
            Point3D p = null;
           // if(){//rotation handle selected
               //  p = world2Obj(transVec);
             //  angle = Math.atan2(p.x, p.y); 
           // }
           // else{
            double x = this.center.x + transVec.x;
            double y = this.center.y + transVec.y;
             p = new Point3D(x, y, 0);
            this.setCenter(p);
           // }
        }
    }
    
    public boolean isPointInShape(Point3D p){
        //Call world2Obj and the check to see if the point lies within the shape. 
        return false;
    }
    
    public Color getColor() {
        return color;
    }   

    public void setColor(Color color) {
        this.color = color;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Point3D getCenter() {
        return center;
    }

    public void setCenter(Point3D center) {
        this.center = center;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
    
}
