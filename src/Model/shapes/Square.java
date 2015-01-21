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
public class Square extends Shape{
    private Point3D Corner;
    private int size;
    
    public Square(Point3D c, int s, Color color){
        super(color);
        this.Corner = c;
        this.size = s;
    }

    public Point3D getCorner() {
        return Corner;
    }

    public void setCorner(Point3D Corner) {
        this.Corner = Corner;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
