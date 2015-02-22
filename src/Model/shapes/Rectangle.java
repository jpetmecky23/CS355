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



public class Rectangle extends Shape{
    private Point3D UpperLeftCorner;
    private double height;
    private double width;
    
    public Rectangle(Point3D cornerStart, Point3D cornerEnd, Color color){
        super(color);
        if(cornerStart != null){
        this.UpperLeftCorner = Tools.findUpperLeftCornerRec(cornerStart, cornerEnd);
        this.width = Math.abs((cornerStart.x - cornerEnd.x));
        this.height = Math.abs((cornerStart.y - cornerEnd.y));
        }
    }
   
    @Override
    public boolean isPointInShape(Point3D p) {
        Point3D convertedPoint = Tools.world2Obj(p, this);
        double dfocX = this.width / 2;//distanceFromObjectCenter
        double dfocY = this.height / 2;//distanceFromObjectCenter
        if(Math.abs(convertedPoint.x) <= dfocX && Math.abs(convertedPoint.y) <= dfocY){
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
        double x = this.UpperLeftCorner.x + this.getWidth() / 2;
        double y = this.UpperLeftCorner.y + this.getHeight() / 2;
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
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
}
