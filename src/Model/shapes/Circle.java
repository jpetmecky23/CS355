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
public class Circle extends Shape{
    private double radis;
    private Point3D UpperLeftCorner;
    
    public Circle(Point3D startPoint, Point3D endPoint, Color color){
        super(color);
        if(startPoint != null){
        double width = Math.abs((startPoint.x - endPoint.x));
        double height = Math.abs((startPoint.y - endPoint.y));        
        this.radis = Math.min(width, height);
        this.UpperLeftCorner = Tools.findUpperLeftCornerSqu(startPoint, startPoint, this.radis);
        }
    }

    @Override
    public boolean isPointInShape(Point3D p) {
       Point3D convertedPoint = Tools.world2Obj(p, this);//COnvert to object coords
       Point3D objectOrigin = new Point3D(0, 0, 0); //Used to make sure the formula make since to me.
        double X = (convertedPoint.x - objectOrigin.x);
        X = X * X;
        double Y = (convertedPoint.y - objectOrigin.y);
        Y = Y * Y;
        double sum = X + Y;
        double radisSquared = (this.radis * this.radis);
        if(sum <= radisSquared){
            this.isSelected = true;
            Model.inst().setSelectColor(this.getColor());
            return true;
        }
        else{
            this.isSelected = false;
            return false;
            }
    }  
    @Override
    public Point3D getCenter(){
        if(this.UpperLeftCorner != null){
        double x = this.UpperLeftCorner.x + this.radis;
        double y = this.UpperLeftCorner.y + this.radis;
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
    public double getRadis() {
        return radis;
    }
    public void setRadis(double radis) {
        this.radis = radis;
    }  
    
}
