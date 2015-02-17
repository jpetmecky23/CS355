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
    protected Point3D center;
    protected ArrayList<Square> handles;
    
    public Shape(Color color) {
        this.color = color;
        this.angle = 0;
        this.isSelected = false;
        this.handles = new ArrayList();//0 = rotation, 1-4 Start at top left and go clockwise 
    }

    public boolean isPointInShape(Point3D p){
        //Call world2Obj and the check to see if the point lies within the shape. 
        return false;
    }   
    public int clickedHandleIndex(Point3D p){
        if(this.isSelected){
            for(int i = 0; i < this.handles.size(); i++){
                if(this.handles.get(i).isPointInShape(p)){
                    return i;
                }
            }
        }
        return -1;
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
    public void setAngle(Point3D angleVec) {
        double angle = Math.atan2(angleVec.y, angleVec.x);
        this.angle = angle;
        this.setupHandles();
        Model.inst().modelChanged();
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
        this.setupHandles();//Setup handles now since there is no point creating them until the object has been selected.
    }
    protected void setupHandles(){
        
    }
    
}
