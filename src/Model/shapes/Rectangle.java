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
    public boolean checkRotation(Point3D mouseClicked){
        Point3D upperLC = new Point3D(-5, (- this.getHeight() / 2) - 20, 0);
        Point3D lowerRC = new Point3D(5, (- this.getHeight() / 2) - 13, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }
    public boolean checkTopLeft(Point3D mouseClicked){
        Point3D upperLC = new Point3D((- this.getWidth() / 2) - 3, (- this.getHeight() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((- this.getWidth() / 2) + 3, (- this.getHeight() / 2) + 3, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }    
    public boolean checkTopRight(Point3D mouseClicked){
        Point3D upperLC = new Point3D((this.getWidth() / 2) - 3, (- this.getHeight() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((this.getWidth() / 2) + 3, (- this.getHeight() / 2) + 3, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }        
    public boolean checkBottomRight(Point3D mouseClicked){
        Point3D upperLC = new Point3D((this.getWidth() / 2) - 3, (this.getHeight() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((this.getWidth() / 2) + 3, (this.getHeight() / 2) + 3, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }        
    public boolean checkBottomLeft(Point3D mouseClicked){
        Point3D upperLC = new Point3D((- this.getWidth() / 2) - 3, (this.getHeight() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((- this.getWidth() / 2) + 3, (this.getHeight() / 2) + 3, 0);
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
            return ModAction.BottomLeft;
        }
                
        else if(checkTopRight(converted)){
            return ModAction.TopRight;
        }

        else if(checkBottomLeft(converted)){
            return ModAction.BottomLeft;
        }
        else if(this.isPointInShape(converted)){
            return ModAction.Moving;
        }
        return ModAction.NoAction;
        }
        return ModAction.NoAction;
    } 
    }
    
    @Override
    public boolean modifyShape(Point3D mousePrevLocation, Point3D mouseCurrentLocation, ModAction modAction){
        /*Point3D convertedCurrent = Tools.world2Obj(mouseCurrentLocation, this);
        Point3D convertedPrev = Tools.world2Obj(mousePrevLocation, this);
        Point3D delta = Tools.findDelta(convertedPrev, convertedCurrent);
        if(this.isIsSelected()){
        if(ModAction.Rotate){
            double deltaAngle = Math.atan2(mouseCurrentLocation.x - mousePrevLocation.x, mouseCurrentLocation.y - mousePrevLocation.y);
            double newAngle = this.getAngle() + deltaAngle;
            //this.setAngle(newAngle);
            return true;
        }

        else if(ModAction.BottomRight){
            double x = this.getWidth() + delta.x;
            double y = this.getHeight() + delta.y;
            if(x > 0 && y > 0){
            this.setWidth(x);
            this.setHeight(y);
            return true;
            }
        }
        else if(ModAction.TopLeft){
            double x = this.getWidth() - delta.x;
            double y = this.getHeight() - delta.y;
            if(x > 0 && y > 0){
            this.setWidth(x);
            this.setHeight(y);
            Point3D ulc = new Point3D(this.UpperLeftCorner.x + delta.x, this.UpperLeftCorner.y + delta.y, 0);
            this.setUpperLeftCorner(ulc);
            return true;
            }
        }
                
        else if(ModAction.TopRigth)){
            double x = this.getWidth() + delta.x;
            double y = this.getHeight() - delta.y;
            if(x > 0 && y > 0){
            this.setWidth(x);
            this.setHeight(y);
            Point3D ulc = new Point3D(this.UpperLeftCorner.x, this.UpperLeftCorner.y + delta.y, 0);
            this.setUpperLeftCorner(ulc);
            return true;
            }
        }

        else if(ModAction.BottomLeft){
            double x = this.getWidth() - delta.x;
            double y = this.getHeight() + delta.y;
            if(x > 0 && y > 0){
            this.setWidth(x);
            this.setHeight(y);
            Point3D ulc = new Point3D(this.UpperLeftCorner.x + delta.x, this.UpperLeftCorner.y, 0);
            this.setUpperLeftCorner(ulc);
            return true;
            }
        }
        else if(ModAction.Moving){
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
        }*/
        return false;
    } 
}
