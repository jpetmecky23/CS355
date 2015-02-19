/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.shapes;

import Model.shapes.Point3D;
import Model.shapes.Shape;
import Model.shapes.Square;
import Utillities.Tools;
import java.awt.Color;

/**
 *
 * @author James
 */
public class SquareController {
    
    public static int checkCorners(Shape shape, Point3D mouseClicked){
       Square s = (Square) shape;
        mouseClicked = Tools.world2Obj(mouseClicked, s);
        if(checkRotation(s, mouseClicked)){
            return 0;
        }
        
        else if(checkTopLeft(s, mouseClicked)){
            return 1;
        }
        
        else if(checkTopRight(s, mouseClicked)){
            return 2;
        }
        
        else if(checkBottomRight(s, mouseClicked)){
            return 3;
        }
        
        else if(checkBottomLeft(s, mouseClicked)){
            return 4;
        }
        else{
        return -1;
        }
    } 
    
    public static boolean checkRotation(Square s, Point3D mouseClicked){
        Point3D upperLC = new Point3D(-3, (- s.getSize() / 2) - 20, 0);
        Point3D lowerRC = new Point3D(3, (- s.getSize() / 2) - 13, 0);
        Square handle = new Square(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }
    
    public static boolean checkTopLeft(Square s, Point3D mouseClicked){
        Point3D upperLC = new Point3D((- s.getSize() / 2) - 3, (- s.getSize() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((- s.getSize() / 2) + 3, (- s.getSize() / 2) + 3, 0);
        Square handle = new Square(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }
        
    public static boolean checkTopRight(Square s, Point3D mouseClicked){
        Point3D upperLC = new Point3D((s.getSize() / 2) - 3, (- s.getSize() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((s.getSize() / 2) + 3, (- s.getSize() / 2) + 3, 0);
        Square handle = new Square(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }
            
    public static boolean checkBottomRight(Square s, Point3D mouseClicked){
        Point3D upperLC = new Point3D((s.getSize() / 2) - 3, (s.getSize() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((s.getSize() / 2) + 3, (s.getSize() / 2) + 3, 0);
        Square handle = new Square(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }
            
    public static boolean checkBottomLeft(Square s, Point3D mouseClicked){
        Point3D upperLC = new Point3D((- s.getSize() / 2) - 3, (s.getSize() / 2) - 3, 0);
        Point3D lowerRC = new Point3D((- s.getSize() / 2) + 3, (s.getSize() / 2) + 3, 0);
        Square handle = new Square(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseClicked)){
            return true;
        }
        return false;
    }
}
