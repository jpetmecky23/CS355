/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.shapes;

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
        this.setupHandles();//Setup handles now since there is no point creating them until the object has been selected.
    }
    protected void setupHandles(){
        
    }
    
}
