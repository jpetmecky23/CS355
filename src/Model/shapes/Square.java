/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.shapes;

import Model.Model;
import Utillities.Tools;
import java.awt.Color;

/**
 *
 * @author James
 */
public class Square extends Shape{
    private Point3D UpperLeftCorner;
    private double size;
    
    public Square(Point3D cornerStart, Point3D cornerEnd, Color color){
        super(color);
        if(cornerStart != null){                   
            double width = Math.abs((cornerStart.x - cornerEnd.x));
            double height = Math.abs((cornerStart.y - cornerEnd.y));        
            this.size = Math.min(width, height);
            this.UpperLeftCorner = Tools.findUpperLeftCornerSqu(cornerStart, cornerEnd, this.size);
        }
    }


    @Override
    public Point3D getCenter(){
        if(this.UpperLeftCorner != null){
        double x = this.UpperLeftCorner.x + this.getSize() / 2;
        double y = this.UpperLeftCorner.y + this.getSize() / 2;
        Point3D p = new Point3D(x, y, 0);
        return p;
        }
        return null;
    }
    public Point3D getUpperLeftCorner() {
        return UpperLeftCorner;
    }
    public void setUpperLeftCorner(Point3D Corner) {
        this.UpperLeftCorner = Corner;
    }
    public double getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
