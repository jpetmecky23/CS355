/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.shapes;

import Controller.Controller;
import Model.Model;
import Model.shapes.Handle;
import Model.shapes.Point3D;
import Model.shapes.Shape;
import Model.shapes.Square;
import Utillities.Tools;
import java.awt.Color;

/**
 *
 * @author James
 */
public class  SquareController extends ShapeController{

    public SquareController() {
    }
    
    @Override
    public Shape processClick(Shape shape, Point3D mousePressed, Point3D mouseCurrentLocation) {
        Square sq = (Square) shape;
        sq = this.checkCorners(sq, mousePressed, mouseCurrentLocation);
        return sq;
    } 
    
    private  Square checkCorners(Square s, Point3D mousePressed, Point3D mouseCurrentLocation){
        Point3D convertedMouseClicked = Tools.world2Obj(mouseCurrentLocation, s);
        if(s.isIsSelected()){
        if(checkRotation(s, convertedMouseClicked)){
           // s = this.rotate(s, mousePressed, mouseCurrentLocation);
            s.setColor(Color.blue);
        }
        //
        
        else if(checkBottomRight(s, convertedMouseClicked) && s.isIsSelected()){
           double x = mousePressed.x - s.getSize();
           double y = mousePressed.y - s.getSize();
           Point3D upperLeftCorner = new Point3D(x, y, 0);
           s = new Square(upperLeftCorner, mouseCurrentLocation, s.getColor());
            s.setColor(Color.yellow);
        }
        else if(checkTopLeft(s, convertedMouseClicked) && s.isIsSelected()){
          //  double x = mousePressed.x + s.getSize();
          //  double y = mousePressed.y + s.getSize();
          //  Point3D bottomRightCorner = new Point3D(x, y, 0);
          //   s = new Square(bottomRightCorner, mouseCurrentLocation, s.getColor());
            s.setColor(Color.green);
        }
                
        else if(checkTopRight(s, convertedMouseClicked)&& s.isIsSelected() ){
            double x = mousePressed.x  - s.getSize();
            double y = mousePressed.y  + s.getSize();
           Point3D bottomLeftCorner = new Point3D(x, y, 0);
            s = new Square(bottomLeftCorner, mouseCurrentLocation, s.getColor());
            s.setColor(Color.pink);
        }

        else if(checkBottomLeft(s, convertedMouseClicked)&& s.isIsSelected() ){
          //  double x = mousePressed.x + s.getSize();
          //  double y = mousePressed.y - s.getSize();
           // Point3D topRightCorner = new Point3D(x, y, 0);
           // s = new Square(topRightCorner, mouseCurrentLocation, s.getColor());
            s.setColor(Color.red);
        }
        }
        else if (!s.isIsSelected()){
            s = new Square(mousePressed, mouseCurrentLocation, s.getColor());
        }
        return s;
    } 
    
    public boolean checkRotation(Square s, Point3D mouseClicked){
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
    }
   
    private Square resize(Square s, Point3D mousePressed, Point3D mouseCurrentLocation){
        s.rebuild(mousePressed, mouseCurrentLocation);
        return s;
    }
    
    private Square rotate(Square s, Point3D mousePressed, Point3D mouseCurrentLocation){
        return null;
    }
    
    private Square move(Square s){
        Point3D transVec = Controller.inst().getMouseDelta();
        double x = s.getUpperLeftCorner().x + transVec.x;
        double y = s.getUpperLeftCorner().y + transVec.y;
        Point3D p = new Point3D(x, y, 0);
        s.setUpperLeftCorner(p);
        return s;
    }
    
}
