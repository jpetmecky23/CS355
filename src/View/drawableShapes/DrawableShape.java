/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.drawableShapes;

import Controller.Controller;
import Model.shapes.Point3D;
import Utillities.Tools;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 *
 * @author James
 */
public class DrawableShape {
    protected Color color;
    protected double angle;
    protected boolean isSelected;

    public DrawableShape(Color color, double angle, boolean isSelected) {
        this.color = color;
        this.angle = angle;
        this.isSelected = isSelected;
    }
    
    
  public void drawShape(Graphics2D g2d){

    } 
  
    public void drawHandles(Graphics2D g2d){

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

    public Point3D getCenter(){
        return null;
    }
    public void setAngle(double angle) {
        this.angle =  angle;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
    public AffineTransform getTransform(){
        Point3D center = getCenter();
        AffineTransform obj2World = Tools.obj2World(angle, center);
        AffineTransform world2View = Tools.world2View(Controller.inst().getZoom(), Controller.inst().getViewOffset());
       world2View.concatenate(obj2World);
       return world2View;
    }
}
