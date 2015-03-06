/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.shapes;

import Controller.Controller;
import Controller.ModAction;
import Model.Model;
import Utillities.Tools;
import java.awt.Color;
import java.awt.geom.AffineTransform;

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
        AffineTransform world2Obj = Tools.world2Obj(this.angle, this.getCenter());
        Point3D convertedPoint = Tools.transform2Point(world2Obj, p);
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
    
    public boolean checkRotation(Point3D mouseClicked){
        int handleScaler =  (int)(16 / Controller.inst().getZoom());
        Point3D upperLC = new Point3D(0, (- this.getRadis()) - 20, 0);
        Point3D lowerRC = new Point3D(handleScaler, (- this.getRadis()) - handleScaler / 2, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }
    public boolean checkTopLeft(Point3D mouseClicked){
        int handleScaler =  (int)(16 / Controller.inst().getZoom());
        Point3D upperLC = new Point3D((- this.getRadis()) - handleScaler, (- this.getRadis()) - handleScaler, 0);
        Point3D lowerRC = new Point3D((- this.getRadis()) + handleScaler, (- this.getRadis()) + handleScaler, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }    
    public boolean checkTopRight(Point3D mouseClicked){
        int handleScaler =  (int)(16 / Controller.inst().getZoom());
        Point3D upperLC = new Point3D((this.getRadis()) - handleScaler, (this.getRadis()) - handleScaler, 0);
        Point3D lowerRC = new Point3D((this.getRadis()) + handleScaler, (this.getRadis()) + handleScaler, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }        
    public boolean checkBottomRight(Point3D mouseClicked){
        int handleScaler =  (int)(16 / Controller.inst().getZoom());
        Point3D upperLC = new Point3D((this.getRadis()) - handleScaler, (this.getRadis()) - handleScaler, 0);
        Point3D lowerRC = new Point3D((this.getRadis()) + handleScaler, (this.getRadis()) + handleScaler, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }        
    public boolean checkBottomLeft( Point3D mouseClicked){
        int handleScaler =  (int)(16 / Controller.inst().getZoom());
        Point3D upperLC = new Point3D((- this.getRadis()) - handleScaler, (this.getRadis()) - handleScaler, 0);
        Point3D lowerRC = new Point3D((- this.getRadis()) + handleScaler, (this.getRadis()) + handleScaler, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }
    
     @Override
    public ModAction getModAction(Point3D mouseDown){
       AffineTransform world2Obj = Tools.world2Obj(this.angle, this.getCenter());//COnvert to object coords
       Point3D converted = Tools.transform2Point(world2Obj, mouseDown);
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
        AffineTransform world2Obj = Tools.world2Obj(this.angle, this.getCenter());
        Point3D convertedCurrent = Tools.transform2Point(world2Obj, mouseCurrentLocation);
        Point3D convertedPrev = Tools.transform2Point(world2Obj, mousePrevLocation);
        Point3D delta = Tools.findDelta(convertedPrev, convertedCurrent);
        if(this.isIsSelected()){
        if(modAction == ModAction.Rotate){
               //Do nothing. It's a circle
            return true;
        }
        //
        
        else if(modAction == ModAction.BottomRight){
            double x = this.getRadis() + delta.x;
            double y = this.getRadis() + delta.y;
            if(x > 0 && y > 0){
            double newSize = Math.min(x, y);
            this.setRadis(newSize);
            return true;
            }
        }
        else if(modAction == ModAction.TopLeft){
            double x = this.getRadis() - delta.x;
            double y = this.getRadis() - delta.y;
            if(x > 0 && y > 0){
            double newSize = Math.max(x, y);
            this.setRadis(newSize);
            double offset = Math.min(delta.x, delta.y);
            Point3D ulc = new Point3D(this.UpperLeftCorner.x + offset, this.UpperLeftCorner.y + offset, 0);
            this.setUpperLeftCorner(ulc);
            return true;
            }
        }
                
        else if(modAction == ModAction.TopRight){
            double x = this.getRadis() + delta.x;
            if(x > 0){
            this.setRadis(x);
            Point3D ulc = new Point3D(this.UpperLeftCorner.x, this.UpperLeftCorner.y + delta.y, 0);
            this.setUpperLeftCorner(ulc);
            return true;
            }
        }

        else if(modAction == ModAction.BottomLeft){
            double y = this.getRadis() + delta.y;
            if(y > 0){
            this.setRadis(y);
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
