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



public class Rectangle extends Shape{
    private Point3D Corner;
    private int height;
    private int width;
    
    public Rectangle(Point3D c, int h, int w, Color color){
        super(color);
        this.Corner = c;
        this.height = h;
        this.width = w;
    }

    public Point3D getCorner() {
        return Corner;
    }

    public void setUpperLeftCorner(Point3D Corner) {
        this.Corner = Corner;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    
}
