/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.shapes;

import Controller.ModAction;
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
    public void setSize(double size) {
        this.size = size;
    }   
    public void resetSize(double size) {
        this.size = this.size + size;
    }
    public boolean checkRotation(Point3D mouseClicked){
        Point3D upperLC = new Point3D(-3, (- this.getSize() / 2) - 20, 0);
        Point3D lowerRC = new Point3D(3, (- this.getSize() / 2) - 13, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }
    public boolean checkTopLeft(Point3D mouseClicked){
        Point3D upperLC = new Point3D((- this.getSize() / 2) - 3, (- this.getSize() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((- this.getSize() / 2) + 3, (- this.getSize() / 2) + 3, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }    
    public boolean checkTopRight(Point3D mouseClicked){
        Point3D upperLC = new Point3D((this.getSize() / 2) - 3, (- this.getSize() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((this.getSize() / 2) + 3, (- this.getSize() / 2) + 3, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }        
    public boolean checkBottomRight(Point3D mouseClicked){
        Point3D upperLC = new Point3D((this.getSize() / 2) - 3, (this.getSize() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((this.getSize() / 2) + 3, (this.getSize() / 2) + 3, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }        
    public boolean checkBottomLeft( Point3D mouseClicked){
        Point3D upperLC = new Point3D((- this.getSize() / 2) - 3, (this.getSize() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((- this.getSize() / 2) + 3, (this.getSize() / 2) + 3, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }
        @Override
    public ModAction getModAction(Point3D mouseDown){
        Point3D converted = Tools.world2Obj(mouseDown, this);
         if(this.isIsSelected()){
        if(checkRotation(converted)){
            return ModAction.Rotate;
        }
        else if(checkBottomRight(converted)){
            return ModAction.BottomRight;
        }
        else if(checkTopLeft(converted)){
            return ModAction.TopLeft;
        }
                
        else if(checkTopRight(converted)){
            return ModAction.TopRight;
        }

        else if(checkBottomLeft(converted)){
            return ModAction.BottomLeft;
        }
        else if(this.isPointInShape(mouseDown)){
            return ModAction.Moving;
        }
        return ModAction.NoAction;
        }
        return ModAction.NoAction; 
    }
    @Override
    public  boolean modifyShape(Point3D mousePrevLocation, Point3D mouseCurrentLocation, ModAction modAction){
        Point3D convertedCurrent = Tools.world2Obj(mouseCurrentLocation, this);
        Point3D convertedPrev = Tools.world2Obj(mousePrevLocation, this);
        Point3D delta = Tools.findDelta(convertedPrev, convertedCurrent);
        if(this.isIsSelected()){
        if(modAction == ModAction.Rotate){
            double deltaAngle = Tools.findAngleDelta(mouseCurrentLocation);
            double newAngle = deltaAngle;
            this.setAngle(newAngle);
            return true;
        }
        //
        
        else if(modAction == ModAction.BottomRight){
            double x = this.getSize() + delta.x;
            double y = this.getSize() + delta.y;
            if(x > 0 && y > 0){
            double newSize = Math.min(x, y);
            this.setSize(newSize);
            return true;
            }
        }
        else if(modAction == ModAction.TopLeft){
            double x = this.getSize() - delta.x;
            double y = this.getSize() - delta.y;
            if(x > 0 && y > 0){
            double newSize = Math.max(x, y);
            this.setSize(newSize);
            double offset = Math.min(delta.x, delta.y);
            Point3D ulc = new Point3D(this.UpperLeftCorner.x + offset, this.UpperLeftCorner.y + offset, 0);
            this.setUpperLeftCorner(ulc);
            return true;
            }
        }
                
        else if(modAction == ModAction.TopRight){
            double x = this.getSize() + delta.x;
            if(x > 0){
            this.setSize(x);
            Point3D ulc = new Point3D(this.UpperLeftCorner.x, this.UpperLeftCorner.y + delta.y, 0);
            this.setUpperLeftCorner(ulc);
            return true;
            }
        }

        else if(modAction == ModAction.BottomLeft){
            double y = this.getSize() + delta.y;
            if(y > 0){
            this.setSize(y);
            Point3D ulc = new Point3D(this.UpperLeftCorner.x + delta.x, this.UpperLeftCorner.y, 0);
            this.setUpperLeftCorner(ulc);
            return true;
            }
        }
        else if(modAction == ModAction.Moving){
            //move shape
            if(delta != null){
            double x = this.getUpperLeftCorner().x + delta.x;
            double y = this.getUpperLeftCorner().y + delta.y;
            Point3D newCorner = new Point3D(x, y, 0);
            this.setUpperLeftCorner(newCorner);
            return true;
            }
        }
        return false;
        }
        return false;
    } 
}
