/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.shapes;

/**
 *
 * @author James
 */



public class Rectangle extends Shape{
    private Point3D upperLeftCorner;
    private int height;
    private int width;
    
    public Rectangle(Point3D ulc, int h, int w){
        this.upperLeftCorner = ulc;
        this.height = h;
        this.width = w;
    }

    public Point3D getUpperLeftCorner() {
        return upperLeftCorner;
    }

    public void setUpperLeftCorner(Point3D upperLeftCorner) {
        this.upperLeftCorner = upperLeftCorner;
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
