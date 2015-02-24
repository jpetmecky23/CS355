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
import java.awt.geom.AffineTransform;

/**
 *
 * @author James
 */
public class Triangle extends Shape{
    private Point3D one;//(I will implemete this when I find that it is benificail)
    private Point3D two;
    private Point3D three;
    
    public Triangle(Point3D a,Color color){
        super(color);
        this.one = a;
        this.two = null;
        this.three = null;
    }

    
    @Override
    public boolean isPointInShape(Point3D p) {
        Point3D convertedPoint = Tools.world2Obj(p, this);
        this.orderPoints();
        boolean testP1 = testPoint(convertedPoint,Tools.world2Obj(this.one, this), Tools.world2Obj(this.two, this));
        boolean testP2 = testPoint(convertedPoint,Tools.world2Obj(this.two, this), Tools.world2Obj(this.three, this));
        boolean testP3 = testPoint(convertedPoint,Tools.world2Obj(this.three, this),Tools.world2Obj(this.one, this));
        if(testP1 && testP2 && testP3){
            this.isSelected = true;
            Model.inst().setSelectColor(this.getColor());
            return true;
        }
        else{
            this.isSelected = false;
            return false;
            }
    }

    private void orderPoints(){
        Point3D temp = null;
        double minX = Math.min(one.x, two.x);
        minX = Math.min(minX, three.x);
        if(one.x == minX){
           this.one = this.one;//redundant I know.
           double minY = Math.min(two.y, three.y);
           if(minY == three.y){
            temp = two;
            two = three;
            three = temp;
           }
        }
        else if(two.x == minX){
           temp = this.one;
           this.one = this.two;
           this.two = temp;
           double minY = Math.min(two.y, three.y);
           if(minY == three.y){
            temp = two;
            two = three;
            three = temp;
           }
        }
        else if(three.x == minX){
           temp = this.one;
           this.one = this.three;
           this.three = temp;
           double minY = Math.min(two.y, three.y);
           if(minY == three.y){
            temp = two;
            two = three;
            three = temp;
           }
        }
       /* if(two.y > one.y && three.y < two.y && two.x < three.x){
            Point3D temp = two;
            two = three;
            three = temp;
        }*/
    }
    
    private boolean testPoint(Point3D convertedPoint, Point3D p1, Point3D p2){
        Point3D f = Tools.subPoints(convertedPoint, p1);
        Point3D g = Tools.subPoints(p2, p1);
        g = Tools.perpVec(g);
        double dotProd = Tools.dotProd(f, g);
        return dotProd > 0;
    }
        
    public Point3D getOne() {
        return one;
    }

    public void setOne(Point3D one) {
        this.one = one;
    }

    public Point3D getTwo() {
        return two;
    }

    public void setTwo(Point3D two) {
        this.two = two;
    }

    public Point3D getThree() {
        return three;
    }

    public void setThree(Point3D three) {
        this.three = three;
    }
    
    public boolean isTwoNull(){
        if(two == null){
            return true;
        }
        return false;
    }
    
    public boolean isThreeNull(){
    if(three == null){
        return true;
    }
    return false;
    }
    @Override
    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    @Override
    public Point3D getCenter(){
        if(this.three != null && this.two != null && this.one != null){
        double centerX = (this.one.x + this.two.x + this.three.x) / 3; //Find the average
        double centerY = (this.one.y + this.two.y + this.three.y) / 3; //Find the average
        Point3D center = new Point3D(centerX, centerY, 0);
        return center;
        }
        return null;
    }
    
    public boolean checkRotation(Point3D mouseDown){
        Point3D upperLC = new Point3D(this.getOne().x - 10, this.getOne().y - 10, 0);
        Point3D lowerRC = new Point3D(this.getOne().x - 5, this.getOne().y - 5, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseDown)){
            return true;
        }
        return false;
    }
    
    public boolean checkOne(Point3D mouseDown){
        Point3D upperLC = new Point3D(this.getOne().x - 3, this.getOne().y - 3, 0);
        Point3D lowerRC = new Point3D(this.getOne().x + 3, this.getOne().y + 3, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseDown)){
            return true;
        }
        return false;
    }
    
    public boolean checkTwo(Point3D mouseDown){
        Point3D upperLC = new Point3D(this.getTwo().x - 3, this.getTwo().y - 3, 0);
        Point3D lowerRC = new Point3D(this.getTwo().x + 3, this.getTwo().y + 3, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseDown)){
            return true;
        }
        return false;
    }
    
    public boolean checkThree(Point3D mouseDown){
        Point3D upperLC = new Point3D(this.getThree().x - 3, this.getThree().y - 3, 0);
        Point3D lowerRC = new Point3D(this.getThree().x + 3, this.getThree().y + 3, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseDown)){
            return true;
        }
        return false;
    }
    
    @Override
    public ModAction getModAction(Point3D mouseDown){
         if(this.isIsSelected()){
        if(checkRotation(mouseDown)){
            return ModAction.Rotate;
        }
        else if(checkOne(mouseDown)){
            return ModAction.triPointOne;
        }
        else if(checkTwo(mouseDown)){
            return ModAction.triPointTwo;
        }
        else if(checkThree(mouseDown)){
            return ModAction.triPointThree;
        }
        else if(this.isPointInShape(mouseDown)){
            return ModAction.Moving;
        }
        else{
            return ModAction.NoAction;
        }
         }
         return ModAction.NoAction;
    }
    
    public void rotate(Point3D mousePrevLocation, Point3D mouseCurrentLocation){
       double deltaAngle = Tools.findAngleDelta(mouseCurrentLocation);
        //double newAngle = this.getAngle() + deltaAngle;
        //this.setAngle(newAngle);
       // this.color = Color.yellow;
        AffineTransform aff = new AffineTransform();
        aff.rotate(deltaAngle);
        Point3D p = Tools.transform2Point(aff, this.one);
        this.setOne(p);
        p = Tools.transform2Point(aff, this.two);
        this.setTwo(p);
        p = Tools.transform2Point(aff, this.three);
        this.setThree(p);
    }
    
    @Override
    public boolean modifyShape(Point3D mousePrevLocation, Point3D mouseCurrentLocation, ModAction modAction) {
        Point3D delta = Tools.findDelta(mousePrevLocation, mouseCurrentLocation);
        
        if(modAction == ModAction.Rotate){
            this.rotate(mousePrevLocation, mouseCurrentLocation);
        }
        else if(modAction == ModAction.triPointOne){
            this.setOne(mouseCurrentLocation);
          return true;  
        }
        
        else if(modAction == ModAction.triPointTwo){
            this.setTwo(mouseCurrentLocation);
            return true;
        }
         else if(modAction == ModAction.triPointThree){
            this.setThree(mouseCurrentLocation);
            return true;
        }
        else if(modAction == ModAction.Moving){
        if(this.isSelected){
        double x = this.one.x + delta.x;
        double y = this.one.y + delta.y;
        Point3D p = new Point3D(x, y, 0);
        this.setOne(p);
        x = this.two.x + delta.x;
        y = this.two.y + delta.y;
        p = new Point3D(x, y, 0);
        this.setTwo(p);
        x = this.three.x + delta.x;
        y = this.three.y + delta.y;
        p = new Point3D(x, y, 0);
        this.setThree(p);
        }
            return true;
        }
        
        return false;
    }
}
