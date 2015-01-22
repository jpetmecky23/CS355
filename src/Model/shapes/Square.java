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
    private Point3D UpperLeftCorner;
    private int size;
    
    public Square(Point3D cornerStart, Point3D cornerEnd, Color color){
        super(color);
        if(cornerStart != null){
        if((cornerStart.y > cornerEnd.y) && (cornerStart.x > cornerEnd.x)){
            this.UpperLeftCorner = cornerEnd;
        }
        
        else if((cornerStart.y < cornerEnd.y) && (cornerStart.x < cornerEnd.x)){
            this.UpperLeftCorner = cornerStart;
        }
        
        else if((cornerStart.y > cornerEnd.y) && (cornerStart.x < cornerEnd.x)){
            Point3D p = new Point3D(cornerStart.x, cornerEnd.y, 0);
             this.UpperLeftCorner = p;
        }
        
        else {//if((cornerStart.y < cornerEnd.y) && (cornerStart.x > cornerEnd.x)){
            Point3D p = new Point3D(cornerEnd.x, cornerStart.y, 0);
            this.UpperLeftCorner = p;
        }
        

        
        int width = Math.abs((int) (cornerStart.x - cornerEnd.x));
        int height = Math.abs((int) (cornerStart.y - cornerEnd.y));        
        this.size = Math.max(width, height);
        }
    }

    public Point3D getCorner() {
        return UpperLeftCorner;
    }

    public void setCorner(Point3D Corner) {
        this.UpperLeftCorner = Corner;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
