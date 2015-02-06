/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.drawableShapes;

import java.awt.Color;
import java.awt.Graphics2D;

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
    
  public void draw(Graphics2D g2d){

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

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
    
}
