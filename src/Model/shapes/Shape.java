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
    private double angle;
    
    public Shape(Color color) {
        this.color = color;
        this.angle = 0;
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
}
