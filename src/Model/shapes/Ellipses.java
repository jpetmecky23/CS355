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
public class Ellipses extends Shape{
    private double height;
    private double width;
    private Point3D UpperLeftCorner;
    
   public  Ellipses(Point3D startPoint, Point3D endPoint, Color color){
       super(color);
       if(UpperLeftCorner != null){
       this.UpperLeftCorner = Tools.findUpperLeftCornerRec(startPoint, endPoint);
       this.width = 2 * (Math.abs((center.x - endPoint.x)));//Times 2 since these oare radii
       this.height = 2 * (Math.abs((center.y - endPoint.y)));//Times 2 since these oare radii 
       }
    }
   
   
   
    @Override
    public boolean isPointInShape(Point3D p) {
        Point3D convertedPoint = Tools.world2Obj(p, this);
        Point3D objectOrigin = new Point3D(0, 0, 0); //Used to make sure the formula make since to me.
        double X = (convertedPoint.x - objectOrigin.x);
        X = X / (this.width / 2);//divid by half the width
        X = X * X;
        double Y = (convertedPoint.y - objectOrigin.y);
        Y = Y / (this.height / 2);//divid by half the hieght
        Y = Y * Y;
        double sum = X + Y;

        if(sum <= 1){//1 is just part of the formula
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
    public void move(Point3D transVec) {
        if(this.UpperLeftCorner != null){
        double x = this.UpperLeftCorner.x + transVec.x;
        double y = this.UpperLeftCorner.y + transVec.y;
        Point3D p = new Point3D(x, y, 0);
        this.UpperLeftCorner = p;
        }
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void resize(int width, int hieght){
        this.width = this.width + width;
        this.height = this.height + height;
    }
}
