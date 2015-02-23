/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.shapes;

import Controller.shapes.SquareController;
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
               this.rebuild(cornerStart, cornerEnd);
        }
    }

    @Override
    public boolean isPointInShape(Point3D p) {
        Point3D convertedPoint = Tools.world2Obj(p, this);
        SquareController sc = new SquareController();
        double dfoc = size / 2;//distanceFromObjectCenter
        if(Math.abs(convertedPoint.x) <= dfoc && Math.abs(convertedPoint.y) <= dfoc){
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
        double x = this.UpperLeftCorner.x + this.getSize() / 2.0;
        double y = this.UpperLeftCorner.y + this.getSize() / 2.0;
        Point3D p = new Point3D(x, y, 0);
        return p;
        }
        return null;
    }
    public void rebuild(Point3D cornerStart, Point3D cornerEnd){
        double width = Math.abs((cornerStart.x - cornerEnd.x));
        double height = Math.abs((cornerStart.y - cornerEnd.y));        
        this.size = Math.min(width, height);
        this.UpperLeftCorner = Tools.findUpperLeftCornerSqu(cornerStart, cornerEnd, this.size);
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
    public void resetSize(double size) {
        this.size = this.size + size;
    }
    /*public boolean checkRotation(Square s, Point3D mouseClicked){
        Point3D upperLC = new Point3D(-3, (- s.getSize() / 2) - 20, 0);
        Point3D lowerRC = new Point3D(3, (- s.getSize() / 2) - 13, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }
    public boolean checkTopLeft(Square s, Point3D mouseClicked){
        Point3D upperLC = new Point3D((- s.getSize() / 2) - 3, (- s.getSize() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((- s.getSize() / 2) + 3, (- s.getSize() / 2) + 3, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }    
    public boolean checkTopRight(Square s, Point3D mouseClicked){
        Point3D upperLC = new Point3D((s.getSize() / 2) - 3, (- s.getSize() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((s.getSize() / 2) + 3, (- s.getSize() / 2) + 3, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }        
    public boolean checkBottomRight(Square s, Point3D mouseClicked){
        Point3D upperLC = new Point3D((s.getSize() / 2) - 3, (s.getSize() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((s.getSize() / 2) + 3, (s.getSize() / 2) + 3, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }        
    public boolean checkBottomLeft(Square s, Point3D mouseClicked){
        Point3D upperLC = new Point3D((- s.getSize() / 2) - 3, (s.getSize() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((- s.getSize() / 2) + 3, (s.getSize() / 2) + 3, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }*/
}
