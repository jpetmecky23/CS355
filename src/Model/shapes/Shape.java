/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.shapes;

import Model.Model;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author James
 */
public class Shape{
    protected Color color;
    protected double angle;
    protected boolean isSelected;
    
    public Shape(Color color) {
        this.color = color;
        this.angle = 0;
        this.isSelected = false; 
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
        Model.inst().modelChanged();
    }    
    public Point3D getCenter() {
        return null;
    }

    
    public boolean isIsSelected() {
        return isSelected;
    }
    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
