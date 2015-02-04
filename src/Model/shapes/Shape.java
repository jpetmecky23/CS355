/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author James
 */
public class Shape{
    private Color color;
    protected double angle;
    protected Point3D center;
    
    public Shape(Color color) {
        this.color = color;
        this.angle = 0;
    }
       
    public Point3D world2Obj(Point3D p){        
        double transX = p.x - center.x;
        double transY = p.y - center.y;
        Point3D transPoint = new Point3D(transX, transY, 0);
        return transPoint;
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
        
    public void selectShape(Color color){
        this.color = color;
    }
    
    public void deselectShape(){
        
    }
}
